package org.example.practiceproject4.controller;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject4.dto.UserRequestDto;
import org.example.practiceproject4.dto.UserResponseDto;
import org.example.practiceproject4.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResponseDto createUser(
            @RequestBody UserRequestDto userRequestDto
    ) {
        return this.userService.createUser(userRequestDto);
    }
    @GetMapping("/users")
    public List<UserResponseDto> findAllUsers() {
        return this.userService.findAllUsers();
    }
    @GetMapping("/users/{userId}")
    public UserResponseDto findUserById(
            @PathVariable Long userId
    ) {
        return this.userService.findUserById(userId);
    }
    @PutMapping("/users/{userId}/names")
    public UserResponseDto updateUserId(
            @PathVariable Long userId,
            @RequestBody UserRequestDto userRequestDto
    ) {
        return this.userService.updateUserId(userId, userRequestDto);
    }
    @PutMapping("/users/{userId}/passwords")
    public UserResponseDto updateUserPassword(
            @PathVariable Long userId,
            @RequestBody UserRequestDto userRequestDto
    ) {
        return this.userService.updateUserPassword(userId, userRequestDto);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(
            @PathVariable Long userId
    ) {
        this.userService.deleteUser(userId);
    }
}
