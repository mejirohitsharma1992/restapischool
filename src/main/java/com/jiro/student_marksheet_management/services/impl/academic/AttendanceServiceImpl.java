package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.Attendance;
import com.jiro.student_marksheet_management.repositories.academic.AttendanceRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        return attendance.orElseThrow(() -> new RuntimeException("Attendance not found with id " + id));
    }

    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existingAttendance = getAttendanceById(id);
        existingAttendance.setFaculty(attendance.getFaculty());
        existingAttendance.setLevel(attendance.getLevel());
        existingAttendance.setProgram(attendance.getProgram());
        existingAttendance.setSchoolClass(attendance.getSchoolClass());
        existingAttendance.setSection(attendance.getSection());
        existingAttendance.setExamType(attendance.getExamType());
        existingAttendance.setTotalDays(attendance.getTotalDays());
        existingAttendance.setRollNo(attendance.getRollNo());
        existingAttendance.setStudentName(attendance.getStudentName());
        existingAttendance.setPresentDays(attendance.getPresentDays());
        return attendanceRepository.save(existingAttendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
