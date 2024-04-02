package ru.mirea.University.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.University.models.Student;
import ru.mirea.University.services.StudentsService;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("students", studentsService.findAll());
        return "students/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id,
                       Model model){
        model.addAttribute("student", studentsService.findOne(id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student){
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student){
        studentsService.save(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        studentsService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,
                       Model model){
        model.addAttribute(studentsService.findOne(id));
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("student") Student student){
        //studentsService.delete(id);
        studentsService.update(id, student);
        return "redirect:/students";
    }
}
