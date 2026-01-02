package online.jayashan.Skill_Mentor.repositories;

import online.jayashan.Skill_Mentor.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    // custom queries
}
