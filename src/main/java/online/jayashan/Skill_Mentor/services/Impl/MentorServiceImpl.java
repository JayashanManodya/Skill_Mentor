package online.jayashan.Skill_Mentor.services.Impl;

import lombok.AllArgsConstructor;
import online.jayashan.Skill_Mentor.entities.Mentor;
import online.jayashan.Skill_Mentor.repositories.MentorRepository;
import online.jayashan.Skill_Mentor.services.MentorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    @Override
    public Mentor createNewMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Page<Mentor> getAllMentors(Pageable pageable) {
        return mentorRepository.findAll(pageable);
    }

    @Override
    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id).get();
    }

    @Override
    public Mentor updateMentorById(Long id, Mentor updatedMentor) {
        Mentor mentor = mentorRepository.findById(id).get();
        mentor.setFirstName(updatedMentor.getFirstName());
        mentor.setLastName(updatedMentor.getLastName());
        mentor.setEmail(updatedMentor.getEmail());
        return mentorRepository.save(mentor);
    }

    @Override
    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}
