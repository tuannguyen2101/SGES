package com.sges.config;

import com.sges.dto.response.UserResponse;
import com.sges.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public UserResponse findByOtpCode(String code){
        return userMapper.convertToResponseDto(authenticationService.findByResetOtpCode(code));
    }
    public boolean sendPasswordResetCode(String email){
        return authenticationService.sendPasswordResetCode(email);
    }

    public String passwordReset(String email,String password){
        return authenticationService.passwordReset(email,password);
    }

    public boolean isPasswordConfirmEmpty(String password2){
        return StringUtils.isEmpty(password2);
    }

    public boolean isPasswordDifferent(String password, String password2) {
        return password != null && !password.equals(password2);
    }
}
