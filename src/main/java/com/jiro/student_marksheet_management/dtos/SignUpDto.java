package com.jiro.student_marksheet_management.dtos;

import lombok.Data;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String name;
}
