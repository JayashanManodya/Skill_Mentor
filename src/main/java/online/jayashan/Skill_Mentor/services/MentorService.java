package online.jayashan.Skill_Mentor.services;

import online.jayashan.Skill_Mentor.entities.Mentor;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MentorService {
    Mentor createNewMentor(Mentor mentor);
    List<Mentor> getAllMentors();
    Mentor getMentorById(Long id);
    Mentor updateMentorById(Long id, Mentor updatedMentor);
    void deleteMentor(Long id);
}
