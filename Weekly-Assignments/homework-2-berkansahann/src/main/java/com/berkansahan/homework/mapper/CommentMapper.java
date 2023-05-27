package com.berkansahan.homework.mapper;

import com.berkansahan.homework.dto.CommentDTO;
import com.berkansahan.homework.dto.CommentSaveRequest;
import com.berkansahan.homework.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequest commentSaveRequest);

    CommentDTO convertToCommentDTO(Comment comment);

    List<CommentDTO> convertToCommentDTOList(List<Comment> commentList);

}
