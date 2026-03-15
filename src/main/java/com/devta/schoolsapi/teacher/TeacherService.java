package com.devta.schoolsapi.teacher;

import com.devta.schoolsapi.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + id));
    }

    public Teacher create(Teacher teacher) {
        teacher.setId(null);
        return teacherRepository.save(teacher);
    }

    public Teacher update(Long id, Teacher request) {
        Teacher existing = getById(id);
        existing.setName(request.getName());
        existing.setSubject(request.getSubject());
        existing.setExperienceYears(request.getExperienceYears());
        return teacherRepository.save(existing);
    }

    public void delete(Long id) {
        Teacher existing = getById(id);
        teacherRepository.delete(existing);
    }
}
