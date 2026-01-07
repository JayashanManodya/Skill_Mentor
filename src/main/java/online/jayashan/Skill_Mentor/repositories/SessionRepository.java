package online.jayashan.Skill_Mentor.repositories;

import online.jayashan.Skill_Mentor.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
}
