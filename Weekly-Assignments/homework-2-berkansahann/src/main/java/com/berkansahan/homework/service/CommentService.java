package com.berkansahan.homework.service;

import com.berkansahan.homework.entity.Comment;
import com.berkansahan.homework.general.BaseEntityService;
import com.berkansahan.homework.repository.CommentRepository;
import org.springframework.stereotype.Service;

/**
 * @author berkansahan
 */
@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository> {
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
