package com.expense_tracker.api.service.impl;

import com.expense_tracker.api.model.entity.UserEntity;
import com.expense_tracker.api.repository.UserRepository;
import com.expense_tracker.api.security.UserInfoDetails;
import com.expense_tracker.api.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Value("${superuser.username}")
    private String superuserUsername;

    @Value("${superuser.password}")
    private String superuserPassword;

    @Value("${superuser.email}")
    private String superuserEmail;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username '%s' not found!", username));
        }

        return new UserInfoDetails(userOpt.get());
    }

    @Override
    public void registerSuperuser() {
        Optional<UserEntity> superuserOpt = userRepository.findByUsername(superuserUsername);

        if (superuserOpt.isPresent()) {
            return;
        }

        UserEntity superuserEntity = new UserEntity();
        superuserEntity.setUsername(superuserUsername);
        superuserEntity.setEmail(superuserEmail);
        superuserEntity.setPassword(encoder.encode(superuserPassword));
        userRepository.save(superuserEntity);
    }
}
