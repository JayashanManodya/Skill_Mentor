package online.jayashan.Skill_Mentor.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import online.jayashan.Skill_Mentor.dto.StudentDTO;
import online.jayashan.Skill_Mentor.entities.Student;
import online.jayashan.Skill_Mentor.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/students")
@RequiredArgsConstructor

public class StudentController extends AbstractController{
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentService.getAllStudents(pageable);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return studentService.createNewStudent(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO updatedStudentDTO) {
        Student student = modelMapper.map(updatedStudentDTO, Student.class);
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
