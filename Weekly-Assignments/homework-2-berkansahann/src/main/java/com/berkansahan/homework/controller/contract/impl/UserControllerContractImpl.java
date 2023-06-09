package com.berkansahan.homework.controller.contract.impl;

import com.berkansahan.homework.controller.contract.UserControllerContract;
import com.berkansahan.homework.dto.UserDTO;
import com.berkansahan.homework.dto.UserSaveRequest;
import com.berkansahan.homework.entity.User;
import com.berkansahan.homework.mapper.UserMapper;
import com.berkansahan.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;

    @Override
    public UserDTO save(UserSaveRequest request) {
        User user = UserMapper.INSTANCE.convertToUser(request);
        userService.save(user);
        return UserMapper.INSTANCE.converToUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.converToUserDTOList(userList);
    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userService.findByIdWithControl(id);
        return UserMapper.INSTANCE.converToUserDTO(user);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userService.findByUsername(username);
        return UserMapper.INSTANCE.converToUserDTO(user);
    }

    @Override
    public void deleteByUsernameAndPhoneNumber(String username, String phoneNumber) {
        Optional<User> user = userService.findByUsernameAndPhoneNumber(username, phoneNumber);
        if (user.isEmpty()){
            throw new RuntimeException();
        }
        userService.deleteById(user.get().getId());
    }
}
