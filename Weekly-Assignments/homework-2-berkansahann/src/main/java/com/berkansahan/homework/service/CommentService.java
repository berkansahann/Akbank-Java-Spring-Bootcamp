package com.berkansahan.homework.service;

import com.berkansahan.homework.dto.CommentSaveRequest;
import com.berkansahan.homework.entity.Comment;
import com.berkansahan.homework.general.BaseEntityService;
import com.berkansahan.homework.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository> {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Comment> findByUserId(Long userId){
        return repository.findByUserId(userId);
    }

    public List<Comment> findByItemId(Long itemId) {
        return repository.findByItemId(itemId);
    }
}
