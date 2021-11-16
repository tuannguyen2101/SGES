package com.sges.config;

import com.sges.dto.request.UserRequest;
import com.sges.dto.response.UserResponse;
import com.sges.entity.User;
import com.sges.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;
    private final UserService userService;

    private User convertToEntity(UserRequest userRequest){
        return modelMapper.map(userRequest, User.class);
    }

    UserResponse convertToResponseDto(User user){
        return modelMapper.map(user,UserResponse.class);
    }
}
