package com.berkansahan.homework.controller.contract.impl;

import com.berkansahan.homework.controller.contract.CommentControllerContract;
import com.berkansahan.homework.dto.CommentDTO;
import com.berkansahan.homework.dto.CommentSaveRequest;
import com.berkansahan.homework.entity.Comment;
import com.berkansahan.homework.mapper.CommentMapper;
import com.berkansahan.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentService commentService;

    @Override
    public CommentDTO save(CommentSaveRequest request) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(request);
        commentService.save(comment);
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentService.deleteById(id);
    }

    @Override
    public List<CommentDTO> findByUserId(Long userId) {
        List<Comment> commentList = commentService.findByUserId(userId);
        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

    @Override
    public List<CommentDTO> findByItemId(Long itemId) {
        List<Comment> commentList = commentService.findByItemId(itemId);
        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }
}
