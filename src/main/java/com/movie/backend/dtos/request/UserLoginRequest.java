package com.movie.backend.dtos.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userName;
    private String password;
}
