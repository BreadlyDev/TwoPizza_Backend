package com.example.TwoPizza.services;

import com.example.TwoPizza.entities.UserEntity;
import com.example.TwoPizza.exceptions.InvalidEmailException;
import com.example.TwoPizza.exceptions.UserAlreadyExistsException;
import com.example.TwoPizza.exceptions.UserNotFoundException;
import com.example.TwoPizza.exceptions.WrongPasswordException;
import com.example.TwoPizza.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void checkEmail(UserEntity user) throws InvalidEmailException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@gmail.com");
        Matcher matcher = pattern.matcher(user.getEmail());

        if (!matcher.find()) {
            throw new InvalidEmailException();
        }
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException, InvalidEmailException {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException();
        }
        checkEmail(user);
        String hashedPassword = encodePassword(user.getPassword());
        user.setPassword(hashedPassword);
        System.out.println("Working");
        return userRepo.save(user);
    }

    public UserEntity login(UserEntity user) throws UserNotFoundException, WrongPasswordException {
        UserEntity currentUser = userRepo.findByEmail(user.getEmail());
        if (currentUser == null) {
            throw new UserNotFoundException();
        }
        if(!matchPassword(user.getPassword(), currentUser.getPassword())) {
            throw new WrongPasswordException();
        }
        return currentUser;
    }
}
