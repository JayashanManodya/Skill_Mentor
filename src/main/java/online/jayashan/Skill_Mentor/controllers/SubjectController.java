package online.jayashan.Skill_Mentor.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import online.jayashan.Skill_Mentor.dto.SubjectDTO;
import online.jayashan.Skill_Mentor.entities.Subject;
import online.jayashan.Skill_Mentor.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController extends AbstractController{
    private final ModelMapper modelMapper;
    private final SubjectService subjectService;

    @GetMapping
    public Page<Subject> getAllSubjects(Pageable pageable) {

        return subjectService.getAllSubjects(pageable);
    }

    @GetMapping("{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@Valid @RequestBody SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        return subjectService.createSubject(subject);
    }

    @PutMapping("{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody SubjectDTO updatedSubjectDTO) {
        Subject subject = modelMapper.map(updatedSubjectDTO, Subject.class);
        return subjectService.updateSubjectById(id, subject);
    }

    @DeleteMapping("{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
