package com.enigma.wulan.controllers;
import com.enigma.wulan.repositories.UserRepository;
import com.enigma.wulan.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
public class UserController {


    final
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        String fullname = body.get("fullname");
        userRepository.save(new User(username, encodedPassword, fullname));
        return true;
    }

}


