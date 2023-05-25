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

    public UserService(UserRepository repository) {
        super(repository);
    }
}
