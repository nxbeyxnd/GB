package ru.alexeisherkhonov.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alexeisherkhonov.app.models.dto.UserAuthDto;
import ru.alexeisherkhonov.app.models.dto.UserPageDto;
import ru.alexeisherkhonov.app.models.dto.UserRegisterDto;
import ru.alexeisherkhonov.app.models.entities.Role;
import ru.alexeisherkhonov.app.models.entities.User;
import ru.alexeisherkhonov.app.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Value("${base.roles.customer}")
    private String CUSTOMER;

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
        roles.add(roleService.findRoleByName(CUSTOMER));

        user.setRoles(roles);
        userRepository.save(user);
    }

    public UserPageDto findUserByEmailAndPassword(UserAuthDto userLoginDto){
        return new UserPageDto(userRepository.findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()));
    }
}
