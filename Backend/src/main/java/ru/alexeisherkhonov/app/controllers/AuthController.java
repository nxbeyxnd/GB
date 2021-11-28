package ru.alexeisherkhonov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.alexeisherkhonov.app.models.dto.UserAuthDto;
import ru.alexeisherkhonov.app.models.dto.UserPageDto;
import ru.alexeisherkhonov.app.models.dto.UserRegisterDto;
import ru.alexeisherkhonov.app.services.UserService;

@RestController
@RequestMapping("api/v1/user")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void createNewUser(@RequestBody UserRegisterDto userRegisterDto){
        userService.createNewUser(userRegisterDto);
    }

    @PostMapping(value = "/login")
    public UserPageDto getUserByLoginAndPass(@RequestBody UserAuthDto userLoginDto){
        return userService.findUserByEmailAndPassword(userLoginDto);
    }
}
