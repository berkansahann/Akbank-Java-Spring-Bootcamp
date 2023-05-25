package com.berkansahan.homework.controller.contract;

import com.berkansahan.homework.dto.UserDTO;
import com.berkansahan.homework.dto.UserSaveRequest;
import org.mapstruct.control.MappingControl;

import java.util.List;

/**
 * @author berkansahan
 */
public interface UserControllerContract {

    UserDTO save(UserSaveRequest request);

    List<UserDTO> findAll();

    void delete(Long id);

    UserDTO findById(Long id);

    UserDTO findByUsername(String username);

    void deleteByUsernameAndPhoneNumber(String username, String phoneNumber);
}
