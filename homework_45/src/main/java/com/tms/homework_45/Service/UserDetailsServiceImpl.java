package com.tms.homework_45.Service;

import com.tms.homework_45.model.Role;
import com.tms.homework_45.model.UserSecurity;
import com.tms.homework_45.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.tms.homework_45.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByName(username);
        List<Role> roles = user.getRoles();
        List<String> rolesAsString = roles.stream().map(Role::getName).collect(Collectors.toList());
        return new UserSecurity(user.getName(), user.getPassword(),rolesAsString);
    }
}
