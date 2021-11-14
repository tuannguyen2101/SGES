package com.sges.service;

import com.sges.entity.User;

public interface AuthenticationService {
    User findByResetOtpCode(String code);
    boolean sendPasswordResetCode(String email);
    String passwordReset(String email,String password);
}
