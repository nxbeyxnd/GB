package ru.alexeisherkhonov.app.configurations;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alexeisherkhonov.app.entities.Role;
import ru.alexeisherkhonov.app.entities.User;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private Collection<GrantedAuthority> grantedAuthorities;

    public static CustomUserDetails getFromEntityToUserDetails(User user){
        CustomUserDetails c = new CustomUserDetails();
        c.email = user.getEmail();
        c.password = user.getPassword();
        for(Role r:user.getRoles()){
            c.grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
