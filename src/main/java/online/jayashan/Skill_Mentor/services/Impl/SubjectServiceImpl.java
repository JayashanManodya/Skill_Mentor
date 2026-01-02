package online.jayashan.Skill_Mentor.services.Impl;

import lombok.RequiredArgsConstructor;
import online.jayashan.Skill_Mentor.entities.Subject;
import online.jayashan.Skill_Mentor.repositories.SubjectRepository;
import online.jayashan.Skill_Mentor.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    //private final MentorRepository mentorRepository;
    private final ModelMapper modelMapper;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll(); // SELECT * from subject
    }

    public Subject addNewSubject(Long mentorId, Subject subject){
//        Mentor mentor = mentorRepository.findById(mentorId).get();
//        subject.setMentor(mentor);
//        return subjectRepository.save(subject); // INSERT
            return null;
    }

    public Subject getSubjectById(Long id){
        return subjectRepository.findById(id).get(); // ... WHERE id=={}
    }

    public Subject updateSubjectById(Long id, Subject updatedSubject){
        Subject subject = subjectRepository.findById(id).get();
        // TODO: use model mapper
        subject.setSubjectName(updatedSubject.getSubjectName());
        subject.setDescription(updatedSubject.getDescription());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }
}
