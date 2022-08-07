package com.movie.backend.dtos.converter;

import com.movie.backend.dtos.UserDto;
import com.movie.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(User user) {
        return new UserDto(user.getUserName(),
                user.getMail());
    }

    public List<UserDto> convert(List<User> users) {
        return users.stream().map(this::convert).collect(Collectors.toList());
    }
}
