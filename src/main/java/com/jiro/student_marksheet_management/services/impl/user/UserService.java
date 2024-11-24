package com.jiro.student_marksheet_management.services.impl.user;

import com.jiro.student_marksheet_management.dtos.LoginDto;
import com.jiro.student_marksheet_management.dtos.SignUpDto;
import com.jiro.student_marksheet_management.dtos.UserDto;
import com.jiro.student_marksheet_management.entities.user.User;
import com.jiro.student_marksheet_management.exceptions.ResourceNotFoundException;
import com.jiro.student_marksheet_management.repositories.user.UserRepository;
import com.jiro.student_marksheet_management.services.jwt.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user with email"+username+" not found"));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with id "+userId+" not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User>user=userRepository.findByEmail(signUpDto.getEmail());
        if (user.isPresent()){
            throw new BadCredentialsException("User with email  already exits"+signUpDto.getEmail());

        }
        User toBeCreated=modelMapper.map(signUpDto,User.class);
        toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
        User savedUser=userRepository.save(toBeCreated);
        return modelMapper.map(savedUser, UserDto.class);
    }


}
