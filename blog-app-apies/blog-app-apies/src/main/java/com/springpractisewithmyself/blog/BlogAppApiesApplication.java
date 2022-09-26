package com.springpractisewithmyself.blog;

import com.springpractisewithmyself.blog.config.AppConstants;
import com.springpractisewithmyself.blog.entities.Role;
import com.springpractisewithmyself.blog.repositories.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApiesApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApiesApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("abcdef"));
//        try {
//            Role role = new Role();
//            role.setId(AppConstants.ADMIN_USER);
//            role.setName("ADMIN_USER");
//
//            Role role1 = new Role();
//            role.setId(AppConstants.NORMAL_USER);
//            role.setName("NORMAL_USER");
//
//            List<Role> roles = List.of(role, role1);
//            this.roleRepo.saveAll(roles);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
