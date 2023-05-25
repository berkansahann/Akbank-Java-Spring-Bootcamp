package com.berkansahan.homework.repository;

import com.berkansahan.homework.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berkansahan
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
