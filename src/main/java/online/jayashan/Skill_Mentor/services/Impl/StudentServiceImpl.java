package online.jayashan.Skill_Mentor.services.Impl;

import lombok.AllArgsConstructor;
import online.jayashan.Skill_Mentor.entities.Student;
import online.jayashan.Skill_Mentor.repositories.StudentRepository;
import online.jayashan.Skill_Mentor.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentrepository;


    @Override
    public Student createNewStudent(Student student) {
        return studentrepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentrepository.findAll(pageable);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentrepository.findById(id).get();
    }

    @Override
    public Student updateStudentById(Integer id, Student updatedStudent) {
        Student student = studentrepository.findById(id).get();
        student.setFirstName((updatedStudent.getFirstName()));
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        return studentrepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentrepository.deleteById(id);
    }
}
