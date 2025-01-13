package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class WebController {

    private final StudentService studentService;

    @Autowired
    public WebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // Returnează pagina principală (index.html)
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students"; // Returnează pagina students.html
    }

    @GetMapping("/students/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student"; // Returnează pagina add-student.html
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students"; // Redirecționează către lista de studenți
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students"; // Redirecționează către lista de studenți
    }

    @GetMapping("/students/login")
    public String loginForm(Model model) {
        model.addAttribute("message", "Introduceți email-ul pentru a vă autentifica sau pentru a vă înregistra.");
        return "login"; // Returnează pagina login.html
    }

    @PostMapping("/students/login")
    public String loginOrSignUpStudent(@RequestParam String email,
                                       @RequestParam(required = false) String name,
                                       Model model) {
        Optional<Student> existingStudent = studentService.findStudentByEmail(email);

        if (existingStudent.isPresent()) {
            model.addAttribute("message", "Bun venit înapoi, " + existingStudent.get().getName() + "!");
            return "students"; // Returnează lista de studenți
        } else {
            if (name == null || name.isEmpty()) {
                model.addAttribute("message", "Nu există un student cu acest email. Te rugăm să completezi numele pentru a te înregistra.");
                return "login"; // Revino la pagina de login pentru completarea numelui
            }
            Student newStudent = new Student(name, email, LocalDate.now()); // Data nașterii poate fi setată implicit
            studentService.addNewStudent(newStudent);
            model.addAttribute("message", "Studentul a fost înregistrat cu succes!");
        }
        return "redirect:/students"; // Redirecționează către lista de studenți
    }
}
