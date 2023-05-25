package com.berkansahan.homework.dto;

import com.berkansahan.homework.enums.UserType;

/**
 * @author berkansahan
 */
public record UserDTO(Long id,
                      String username,
                      String phoneNumber,
                      String email,
                      UserType userType) {
}
