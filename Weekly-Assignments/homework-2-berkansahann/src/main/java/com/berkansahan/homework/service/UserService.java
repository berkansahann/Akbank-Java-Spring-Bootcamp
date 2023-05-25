package com.berkansahan.homework.service;

import com.berkansahan.homework.entity.User;
import com.berkansahan.homework.general.BaseEntityService;
import com.berkansahan.homework.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public void deleteByUsernameAndPhoneNumber(String username, String phoneNumber) {
        repository.deleteByUsernameAndPhoneNumber(username, phoneNumber);
    }
}
