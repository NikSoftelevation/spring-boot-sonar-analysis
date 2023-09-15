package com.spring.sonar.service;

import com.spring.sonar.dto.UserDto;
import com.spring.sonar.entity.User;

import java.util.List;

public interface UserService {

    public UserDto createUser(User user);

    public UserDto updateUser(User user, int userId);

    public UserDto findUserByUserId(int userId);

    public List<UserDto> findAllUsers();

    public void deleteUserByUserId(int userId);
}
