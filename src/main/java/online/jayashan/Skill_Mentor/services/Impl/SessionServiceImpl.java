package online.jayashan.Skill_Mentor.services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.jayashan.Skill_Mentor.dto.SessionDTO;
import online.jayashan.Skill_Mentor.entities.Mentor;
import online.jayashan.Skill_Mentor.entities.Session;
import online.jayashan.Skill_Mentor.entities.Student;
import online.jayashan.Skill_Mentor.entities.Subject;
import online.jayashan.Skill_Mentor.exceptions.SkillMentorException;
import online.jayashan.Skill_Mentor.repositories.MentorRepository;
import online.jayashan.Skill_Mentor.repositories.SessionRepository;
import online.jayashan.Skill_Mentor.repositories.StudentRepository;
import online.jayashan.Skill_Mentor.repositories.SubjectRepository;
import online.jayashan.Skill_Mentor.services.SessionService;
import online.jayashan.Skill_Mentor.utils.ValidationUtils;


import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final MentorRepository mentorRepository;
    private final SubjectRepository subjectRepository;


    @Override
    public Session createNewSession(SessionDTO sessionDTO) {
        try{
            Student student = studentRepository.findById(sessionDTO.getStudentId()).orElseThrow(
                    () -> new SkillMentorException("Student not found", HttpStatus.NOT_FOUND)
            );
            Mentor mentor = mentorRepository.findById(sessionDTO.getMentorId()).orElseThrow(
                    () -> new SkillMentorException("Mentor not found", HttpStatus.NOT_FOUND)
            );
            Subject subject = subjectRepository.findById(sessionDTO.getSubjectId()).orElseThrow(
                    () -> new SkillMentorException("Subject not found", HttpStatus.NOT_FOUND)
            );

            // Checking availability
            ValidationUtils.validateMentorAvailability(mentor, sessionDTO.getSessionAt(), sessionDTO.getDurationMinutes());
            ValidationUtils.validateStudentAvailability(student, sessionDTO.getSessionAt(), sessionDTO.getDurationMinutes());

            Session session = modelMapper.map(sessionDTO, Session.class);
            session.setMentor(mentor);
            session.setStudent(student);
            session.setSubject(subject);

            return sessionRepository.save(session);

        } catch (SkillMentorException e){
            log.error("Dependencies not found to map: {}, Failed to create new session",e.getMessage());
            throw e;
        } catch (Exception exception) {
            log.error("Failed to create new session", exception);
            throw new SkillMentorException("Failed to create new session", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<Session> getAllSessions(Pageable pageable) {
        return sessionRepository.findAll(pageable);
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.getReferenceById(id);
    }

    @Override
    public Session updateSessionById(Long id, SessionDTO updatedSessionDTO) {
        Session session = sessionRepository.findById(id).get();
        // source -> destination
        modelMapper.map(updatedSessionDTO, session);

        // Update the related entities
        if (updatedSessionDTO.getStudentId() != null) {
            Student student = studentRepository.findById(updatedSessionDTO.getStudentId()).get();
            session.setStudent(student);
        }
        if (updatedSessionDTO.getMentorId() != null) {
            Mentor mentor = mentorRepository.findById(updatedSessionDTO.getMentorId()).get();
            session.setMentor(mentor);
        }
        if (updatedSessionDTO.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(updatedSessionDTO.getSubjectId()).get();
            session.setSubject(subject);
        }
        return sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
