package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final ObjectMapper mapper;

    @Override
    public List<Student> getAll() {
        List<StudentEntity> entities = repository.findAll();
        List<Student> studentList = new ArrayList<>();

        entities.forEach(studentEntity -> studentList.add(
                mapper.convertValue(
                        studentEntity, Student.class
                )
        ));
        return studentList;
    }

    @Override
    public String getVersion() {
        return "";
    }

    @Override
    public Student addStudent(Student student) {
        return mapper.convertValue(
                repository.save(
                        mapper.convertValue(
                                student,
                                StudentEntity.class
                        )
                ),Student.class
        );
    }

    @Override
    public Student searchById(Integer id) {
        return mapper.convertValue(repository.findById(id),Student.class);
    }

    @Override
    public Student updateStudent(Student student) {
        return mapper.convertValue(
                repository.save(
                        mapper.convertValue(
                                student,
                                StudentEntity.class
                        )
                ),Student.class
        );
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
