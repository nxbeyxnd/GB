package ru.alexeisherkhonov.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexeisherkhonov.app.dto.UserLoginDto;
import ru.alexeisherkhonov.app.dto.UserPageDto;
import ru.alexeisherkhonov.app.dto.UserRegisterDto;
import ru.alexeisherkhonov.app.entities.Role;
import ru.alexeisherkhonov.app.entities.User;
import ru.alexeisherkhonov.app.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void createNewUser(UserRegisterDto userRegisterDto){
        User user = new User();
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findRoleByName("CLIENT"));
        user.setRoles(roles);
        userRepository.save(user);
    }

    public UserPageDto findUserByEmailAndPassword(UserLoginDto userLoginDto){
        return new UserPageDto(userRepository.findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()));
    }
}
