package com.example.nobodycanstopus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestsDto {
    private String username;
    private String nickname;
    private String password;
    private String passwordCk;
}
