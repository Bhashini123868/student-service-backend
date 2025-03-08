package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {

    //http://localhost:8081/student/get

    private final StudentService service;

    @GetMapping("/get-all")
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/version")
    public String getVersion(){
        return service.getVersion();
    }
    @PostMapping("/add-student")
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }
    @GetMapping("/search-by-id/{id}")
    public Student searchById(@PathVariable Integer id){
        return service.searchById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean deleteStudentById(@PathVariable Integer id){
       return service.deleteStudent(id);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
       return service.updateStudent(student);
    }
}
