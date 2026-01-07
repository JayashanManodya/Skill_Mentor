package online.jayashan.Skill_Mentor.services;

import online.jayashan.Skill_Mentor.entities.Student;

import java.util.List;

public interface StudentService {

    Student createNewStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student updateStudentById(Integer id, Student updatedStudent);
    void deleteStudent(Integer id);
}
