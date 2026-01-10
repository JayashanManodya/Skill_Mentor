package online.jayashan.Skill_Mentor.services.Impl;

import lombok.RequiredArgsConstructor;
import online.jayashan.Skill_Mentor.dto.SubjectDTO;
import online.jayashan.Skill_Mentor.entities.Mentor;
import online.jayashan.Skill_Mentor.entities.Subject;
import online.jayashan.Skill_Mentor.repositories.MentorRepository;
import online.jayashan.Skill_Mentor.repositories.SubjectRepository;
import online.jayashan.Skill_Mentor.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    private final MentorRepository mentorRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }


    public Subject getSubjectById(Long id){
        return subjectRepository.findById(id).get();
    }

    public Subject updateSubjectById(Long id, Subject updatedSubject){
        Subject subject = subjectRepository.findById(id).get();
        subject.setSubjectName(updatedSubject.getSubjectName());
        subject.setDescription(updatedSubject.getDescription());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }
}
