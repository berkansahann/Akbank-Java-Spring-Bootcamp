package com.berkansahan.homework.repository;

import com.berkansahan.homework.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berkansahan
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
