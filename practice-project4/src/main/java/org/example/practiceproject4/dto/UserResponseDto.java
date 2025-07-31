package org.example.practiceproject4.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String userName;
    private final String password;

    public UserResponseDto(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
