package com.spring.sonar.service.implementation;

import com.spring.sonar.dto.UserDto;
import com.spring.sonar.entity.User;
import com.spring.sonar.exception.UserException;
import com.spring.sonar.repository.UserRepository;
import com.spring.sonar.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(User user) {

        User createdUser = userRepository.save(user);

        return modelMapper.map(createdUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(User user, int userId) {

        User userByUserId = userRepository.findById(userId).orElseThrow(() -> new UserException("user with userId " + userId + "not found !"));

        userByUserId.setName(user.getName());
        userByUserId.setEmail(user.getEmail());
        userByUserId.setPhone(user.getPhone());
        userByUserId.setAddress(user.getAddress());
        userByUserId.setJobProfile(user.getJobProfile());
        userByUserId.setPassword(user.getPassword());

        User updatedUser = userRepository.save(userByUserId);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto findUserByUserId(int userId) {

        User userByUserId = userRepository.findById(userId).orElseThrow(() -> new UserException("user with userId " + userId + "not found !"));

        return modelMapper.map(userByUserId, UserDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {

        List<User> getAllUsers = userRepository.findAll();

        return getAllUsers.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUserByUserId(int userId) {

        userRepository.deleteById(userId);
    }
}