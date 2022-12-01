package com.example.blogAppApiesExtended.services.repositories;

import com.example.blogAppApiesExtended.config.AppConstrants;
import com.example.blogAppApiesExtended.entities.Role;
import com.example.blogAppApiesExtended.entities.User;
import com.example.blogAppApiesExtended.exceptions.ResourceNotFoundException;
import com.example.blogAppApiesExtended.payloads.UserDto;
import com.example.blogAppApiesExtended.repositories.UserRepo;
import com.example.blogAppApiesExtended.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        User foundedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        foundedUser.setName(user.getName());
        foundedUser.setUserName(user.getUserName());
        foundedUser.setEmail(user.getEmail());
        foundedUser.setPassword(user.getPassword());
        foundedUser.setAbout(user.getAbout());

        User updatedUser = userRepo.save(foundedUser);
        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        User role = this.userRepo.findById(AppConstrants.USER_ID).get();
        user.getRoles().add(role);
        User newUser = this.userRepo.save(user);
        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));;
        this.userRepo.delete(user);
    }
}
