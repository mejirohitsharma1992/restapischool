package com.jiro.student_marksheet_management.services.impl.student;
import com.jiro.student_marksheet_management.entities.student.SchoolClass;
import com.jiro.student_marksheet_management.repositories.student.ClassRepository;
import com.jiro.student_marksheet_management.services.interfaces.student.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassServiceImpl implements ClassService {

    @Autowired
    private final ClassRepository classRepository;


    public SchoolClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public SchoolClass createClass(SchoolClass classEntity) {
        return classRepository.save(classEntity);
    }

    @Override
    public SchoolClass getClassById(Long id) {
        return classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class not found"));
    }

    @Override
    public List<SchoolClass> getAllClasses() {
        return classRepository.findAll();
    }


    @Override
    public SchoolClass updateClass(Long id, SchoolClass classDetails) {
        SchoolClass classEntity = classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class not found"));
        classEntity.setClassName(classDetails.getClassName());
        // Other setters
        return classRepository.save(classEntity);
    }

    @Override
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}

