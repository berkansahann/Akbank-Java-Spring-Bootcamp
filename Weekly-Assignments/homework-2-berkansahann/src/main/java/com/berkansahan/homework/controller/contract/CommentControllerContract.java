package com.berkansahan.homework.controller.contract;

import com.berkansahan.homework.dto.CommentDTO;
import com.berkansahan.homework.dto.CommentSaveRequest;

import java.util.List;

/**
 * @author berkansahan
 */
public interface CommentControllerContract {

    CommentDTO save(CommentSaveRequest request);

    void deleteById(Long id);

    List<CommentDTO> findByUserId(Long userId);

    List<CommentDTO> findByItemId(Long itemId);
}
