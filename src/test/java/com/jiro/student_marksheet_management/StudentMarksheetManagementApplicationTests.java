package com.jiro.student_marksheet_management;

import com.jiro.student_marksheet_management.entities.user.User;
import com.jiro.student_marksheet_management.services.jwt.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentMarksheetManagementApplicationTests {

	@Autowired
	private JWTService jwtService;

	@Test
	void contextLoads() {
		User user=new User(4L,"aaa@gmail.com","123");
		String token=jwtService.generateToken(user);
		System.out.println(token);
		Long id=jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
