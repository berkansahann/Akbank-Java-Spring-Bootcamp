package com.berkansahan.homework.repository;

import com.berkansahan.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berkansahan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    void deleteByUsernameAndPhoneNumber(String username, String phoneNumber);
}
