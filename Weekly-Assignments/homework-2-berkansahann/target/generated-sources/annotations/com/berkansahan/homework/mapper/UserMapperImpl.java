package com.berkansahan.homework.mapper;

import com.berkansahan.homework.dto.UserDTO;
import com.berkansahan.homework.dto.UserSaveRequest;
import com.berkansahan.homework.entity.User;
import com.berkansahan.homework.enums.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T03:38:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(UserSaveRequest userSaveRequest) {
        if ( userSaveRequest == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userSaveRequest.username() );
        user.setPassword( userSaveRequest.password() );
        user.setPhoneNumber( userSaveRequest.phoneNumber() );
        user.setEmail( userSaveRequest.email() );
        user.setUserType( userSaveRequest.userType() );

        return user;
    }

    @Override
    public UserDTO converToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String phoneNumber = null;
        String email = null;
        UserType userType = null;

        id = user.getId();
        username = user.getUsername();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
        userType = user.getUserType();

        UserDTO userDTO = new UserDTO( id, username, phoneNumber, email, userType );

        return userDTO;
    }

    @Override
    public List<UserDTO> converToUserDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( converToUserDTO( user ) );
        }

        return list;
    }
}
