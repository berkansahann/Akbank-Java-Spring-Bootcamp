package com.berkansahan.homework.dto;

import com.berkansahan.homework.enums.UserType;

/**
 * @author berkansahan
 */
public record UserSaveRequest(String username,
                              String password,
                              String phoneNumber,
                              String email,
                              UserType userType) {
}
