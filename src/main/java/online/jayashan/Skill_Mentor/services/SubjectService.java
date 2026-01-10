package online.jayashan.Skill_Mentor.services;

import online.jayashan.Skill_Mentor.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    Page<Subject> getAllSubjects(Pageable pageable);
    Subject createSubject(Subject subject);
    Subject getSubjectById(Long id);
    Subject updateSubjectById(Long id, Subject updatedSubject);
    void deleteSubject(Long id);
}
