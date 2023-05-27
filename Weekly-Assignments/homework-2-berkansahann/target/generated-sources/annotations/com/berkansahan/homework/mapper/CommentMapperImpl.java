package com.berkansahan.homework.mapper;

import com.berkansahan.homework.dto.CommentDTO;
import com.berkansahan.homework.dto.CommentSaveRequest;
import com.berkansahan.homework.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T03:38:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment convertToComment(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setComment( commentSaveRequest.comment() );
        comment.setItemId( commentSaveRequest.itemId() );
        comment.setUserId( commentSaveRequest.userId() );

        return comment;
    }

    @Override
    public CommentDTO convertToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long id = null;
        String comment1 = null;
        Long itemId = null;
        Long userId = null;

        id = comment.getId();
        comment1 = comment.getComment();
        itemId = comment.getItemId();
        userId = comment.getUserId();

        CommentDTO commentDTO = new CommentDTO( id, comment1, itemId, userId );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> convertToCommentDTOList(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( convertToCommentDTO( comment ) );
        }

        return list;
    }
}
