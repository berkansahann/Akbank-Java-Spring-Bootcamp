package com.berkansahan.homework.dto;

import com.berkansahan.homework.entity.Item;
import com.berkansahan.homework.entity.User;

/**
 * @author berkansahan
 */
public record CommentSaveRequest(String comment,
                                 Long itemId,
                                 Long userId) {
}
