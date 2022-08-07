package com.movie.backend.controller;

import com.movie.backend.dtos.UserDto;
import com.movie.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{mail}")
    public ResponseEntity<String> deleteById(@PathVariable("mail") String mail) {
        userService.delete(mail);
        return new ResponseEntity<>(mail, HttpStatus.OK);
    }

    @GetMapping("/get-by-mail/{mail}")
    public ResponseEntity<UserDto> getUserByMail(@PathVariable("mail") String mail) {
        return new ResponseEntity<>(userService.getUserByMail(mail), HttpStatus.OK);
    }

    @GetMapping("/get-by-userName/{userName}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
    }
}
