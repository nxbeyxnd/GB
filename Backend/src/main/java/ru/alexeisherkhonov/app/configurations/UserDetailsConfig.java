package ru.alexeisherkhonov.app.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.alexeisherkhonov.app.entities.User;
import ru.alexeisherkhonov.app.services.UserService;

public class UserDetailsConfig implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(s);
        return CustomUserDetails.getFromEntityToUserDetails(user);
    }
}
