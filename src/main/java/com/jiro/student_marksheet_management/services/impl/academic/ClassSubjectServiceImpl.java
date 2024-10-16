package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.ClassSubject;
import com.jiro.student_marksheet_management.repositories.academic.ClassSubjectRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassSubjectServiceImpl implements ClassSubjectService {

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Override
    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    @Override
    public ClassSubject getClassSubjectById(Long id) {
        Optional<ClassSubject> classSubject = classSubjectRepository.findById(id);
        return classSubject.orElseThrow(() -> new RuntimeException("ClassSubject not found with id " + id));
    }

    @Override
    public ClassSubject createClassSubject(ClassSubject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    @Override
    public ClassSubject updateClassSubject(Long id, ClassSubject classSubject) {
        ClassSubject existingClassSubject = getClassSubjectById(id);
        existingClassSubject.setFaculty(classSubject.getFaculty());
        existingClassSubject.setLevel(classSubject.getLevel());
        existingClassSubject.setProgram(classSubject.getProgram());
        existingClassSubject.setSchoolClass(classSubject.getSchoolClass());
        existingClassSubject.setExamType(classSubject.getExamType());
        existingClassSubject.setSubject(classSubject.getSubject());
        existingClassSubject.setCreditHour(classSubject.getCreditHour());
        existingClassSubject.setIsOptional(classSubject.getIsOptional());
        return classSubjectRepository.save(existingClassSubject);
    }

    @Override
    public void deleteClassSubject(Long id) {
        classSubjectRepository.deleteById(id);
    }
}
