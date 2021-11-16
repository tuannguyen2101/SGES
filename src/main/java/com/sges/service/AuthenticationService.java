package com.sges.service;

import com.sges.entity.User;
import com.sges.securiry.auth2.OAuth2UserInfo;

public interface AuthenticationService {
    User findByResetOtpCode(String code);
    boolean sendPasswordResetCode(String email);
    String passwordReset(String email,String password);
    User registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo);

    User updateOauth2User(User user, String provider, OAuth2UserInfo oAuth2UserInfo);
}
