package online.jayashan.Skill_Mentor.repositories;



import online.jayashan.Skill_Mentor.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
