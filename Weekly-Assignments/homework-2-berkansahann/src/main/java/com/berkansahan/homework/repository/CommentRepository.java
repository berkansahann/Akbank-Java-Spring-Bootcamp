package com.berkansahan.homework.repository;

import com.berkansahan.homework.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author berkansahan
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserId(Long userId);

    List<Comment> findByItemId(Long itemId);
}
