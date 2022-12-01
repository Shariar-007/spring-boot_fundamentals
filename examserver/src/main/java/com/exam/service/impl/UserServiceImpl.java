package com.exam.service.impl;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findUserByUserName(user.getUserName());

        if (local != null) {
            System.out.println("User is already there !!");
            throw new Exception("User already present");
        } else {
            // user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public List<User> getAllUser() throws Exception {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User getUser(String userName) throws Exception {
        return this.userRepository.findUserByUserName(userName);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        return this.userRepository.findById(userId).orElseThrow(() -> new Exception("user not Found"));
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, Long userId) throws Exception {
        // userName and password can not be updatable
        User foundedUser = this.userRepository.findById(userId).orElseThrow(() -> new Exception("User is not present !!"));
        foundedUser.setFirstName(user.getFirstName());
        foundedUser.setLastName(user.getLastName());
        foundedUser.setEmail(user.getEmail());
        foundedUser.setAbout(user.getAbout());
        foundedUser.setProfile(user.getProfile());
        foundedUser.setPhone(user.getPhone());
        foundedUser.setEnable(user.getEnable());

        User updatedUser = this.userRepository.save(foundedUser);
        return updatedUser;
    }
}
