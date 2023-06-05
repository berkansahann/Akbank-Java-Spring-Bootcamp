package com.berkansahan.project.repository;

import com.berkansahan.project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berkansahan
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
