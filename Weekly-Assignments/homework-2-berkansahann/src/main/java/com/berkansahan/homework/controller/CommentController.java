package com.berkansahan.homework.controller;

import com.berkansahan.homework.controller.contract.CommentControllerContract;
import com.berkansahan.homework.dto.CommentDTO;
import com.berkansahan.homework.dto.CommentSaveRequest;
import com.berkansahan.homework.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author berkansahan
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> save(@RequestBody CommentSaveRequest commentSaveRequest){
        var commentDTO = commentControllerContract.save(commentSaveRequest);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> deleteById(@PathVariable Long id) {
        commentControllerContract.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/userid")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findByUserId(@RequestParam Long userId) {
        var commentDTO = commentControllerContract.findByUserId(userId);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping("/itemid")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findByItemId(@RequestParam Long itemId) {
        var commentDTO = commentControllerContract.findByItemId(itemId);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }
}
