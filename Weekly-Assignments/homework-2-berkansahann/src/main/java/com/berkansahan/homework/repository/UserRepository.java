package com.berkansahan.homework.repository;

import com.berkansahan.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author berkansahan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findByUsernameAndPhoneNumber(String username, String phoneNumber);
}
