package com.devta.schoolsapi.student;

import com.devta.schoolsapi.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    public Student create(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student update(Long id, Student request) {
        Student existing = getById(id);
        existing.setName(request.getName());
        existing.setAge(request.getAge());
        existing.setGrade(request.getGrade());
        return studentRepository.save(existing);
    }

    public void delete(Long id) {
        Student existing = getById(id);
        studentRepository.delete(existing);
    }
}
