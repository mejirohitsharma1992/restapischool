package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendanceRecords();
    Attendance getAttendanceById(Long id);
    Attendance createAttendance(Attendance attendance);
    Attendance updateAttendance(Long id, Attendance attendance);
    void deleteAttendance(Long id);
}
