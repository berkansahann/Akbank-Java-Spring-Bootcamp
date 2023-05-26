package com.berkansahan.homework.service;

import com.berkansahan.homework.entity.User;
import com.berkansahan.homework.general.BaseEntityService;
import com.berkansahan.homework.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author berkansahan
 */
@Service
public class UserService extends BaseEntityService<User, UserRepository> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Optional<User> findByUsernameAndPhoneNumber(String username, String phoneNumber) {
        return repository.findByUsernameAndPhoneNumber(username, phoneNumber);
    }
}
