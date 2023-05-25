package com.berkansahan.homework.controller;

import com.berkansahan.homework.controller.contract.UserControllerContract;
import com.berkansahan.homework.dto.UserDTO;
import com.berkansahan.homework.dto.UserSaveRequest;
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
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserControllerContract userControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> save(@RequestBody UserSaveRequest userSaveRequest){
        var userDTO = userControllerContract.save(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        userControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id) {
        var userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/username")
    public ResponseEntity<RestResponse<UserDTO>> findByUsername(@RequestParam String username) {
        var userDTO = userControllerContract.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @DeleteMapping("/username")
    public ResponseEntity<RestResponse<Object>> deleteByUsernameAndPhoneNumber(@RequestParam String username, @RequestParam String phoneNumber) {
        userControllerContract.deleteByUsernameAndPhoneNumber(username, phoneNumber);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
