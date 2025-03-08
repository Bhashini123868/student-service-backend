package edu.icet.service;

import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    String getVersion();

    Student addStudent(Student student);

    Student searchById(Integer id);
    Student updateStudent(Student student);
    Boolean deleteStudent(Integer id);



}
