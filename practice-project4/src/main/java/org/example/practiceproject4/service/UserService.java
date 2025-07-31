package org.example.practiceproject4.service;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject4.dto.UserRequestDto;
import org.example.practiceproject4.dto.UserResponseDto;
import org.example.practiceproject4.entity.User;
import org.example.practiceproject4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = this.userRepository.save(new User(userRequestDto.getUserName(), userRequestDto.getPassword()));
        return new UserResponseDto(user.getId(), user.getUserName(), user.getPassword());
    }
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> new UserResponseDto(user.getId(), user.getUserName(), user.getPassword())).toList();
    }
    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 사용자 없습니다.")
        );
        return new UserResponseDto(user.getId(), user.getUserName(), user.getPassword());
    }
    @Transactional
    public UserResponseDto updateUserId(Long userId, UserRequestDto userRequestDto) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 사용자 없습니다.")
        );
        user.changeUserName(userRequestDto.getUserName());
        return new UserResponseDto(user.getId(), user.getUserName(), user.getPassword());
    }
    @Transactional
    public UserResponseDto updateUserPassword(Long userId, UserRequestDto userRequestDto) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 사용자 없습니다.")
        );
        user.changeUserPassword(userRequestDto.getPassword());
        return new UserResponseDto(user.getId(), user.getUserName(), user.getPassword());
    }
    @Transactional
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 사용자 없습니다.")
        );
        this.userRepository.delete(user);
    }
}
