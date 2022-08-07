package com.movie.backend.service;

import com.movie.backend.dtos.UserDto;
import com.movie.backend.dtos.converter.UserDtoConverter;
import com.movie.backend.dtos.request.CreateUserRequest;
import com.movie.backend.model.User;
import com.movie.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserDtoConverter userDtoConverter;

    public UserDto save(CreateUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setMail(request.getMail());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto getUserByUserName(String userName) {
        return userDtoConverter.convert(userRepository.findUsersByUserName(userName));
    }

    public UserDto getUserByMail(String mail) {
       return userDtoConverter.convert(userRepository.findUsersByMail(mail));
    }

    public List<UserDto> getAll() {
        return userDtoConverter.convert(userRepository.findAll());
    }

    public void delete(String mail) {
        User user = userRepository.findUsersByMail(mail);
        userRepository.deleteById(user.getId());
    }

}
