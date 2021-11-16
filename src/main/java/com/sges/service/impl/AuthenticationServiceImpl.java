package com.sges.service.impl;

import com.sges.entity.AuthProvider;
import com.sges.entity.ERole;
import com.sges.entity.Role;
import com.sges.entity.User;
import com.sges.jwt.JwtHelper;
import com.sges.repo.RoleRepo;
import com.sges.repo.UserRepo;
import com.sges.securiry.auth2.OAuth2UserInfo;
import com.sges.service.AuthenticationService;
import com.sges.service.email.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder encoder;
    private final JwtHelper jwtHelper;
    private final MailSender mailSender;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Value("${hostname}")
    private String hostname;

    @Override
    public User findByResetOtpCode(String code) {
        return userRepo.findByOtpCode(code);
    }

    @SneakyThrows
    @Override
    public boolean sendPasswordResetCode(String email) {
        User user = userRepo.findByEmail(email);
        if (user==null) return false;
        user.setOtpCode(UUID.randomUUID().toString());
        userRepo.save(user);

        String subject = "Password reset";
        String template= "password-reset";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName",user.getFullname());
        attributes.put("resetUrl", "http://" + hostname + "/reset/" + user.getOtpCode());
        mailSender.sendMessageHtml(user.getEmail(),subject,template,attributes);
        return true;
    }

    @Override
    public String passwordReset(String email, String password) {
        User user= userRepo.findByEmail(email);
        user.setPassword(encoder.encode(password));
        user.setOtpCode(null);
        userRepo.save(user);
        return "Password successfully changed!";
    }

    @Override
    public User registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo) {
        Role userRole = roleRepo.findByRole(ERole.USER).orElseThrow(()->new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setPassword(Long.toHexString(System.currentTimeMillis()));
        user.setUsername(oAuth2UserInfo.getLastName());
        user.setFullname(oAuth2UserInfo.getFirstName()+oAuth2UserInfo.getLastName());
        user.setStatus(1);
        user.setRoles(roles);
        user.setProvider(AuthProvider.valueOf(provider.toLowerCase()));
        return userRepo.save(user);
    }

    @Override
    public User updateOauth2User(User user, String provider, OAuth2UserInfo oAuth2UserInfo) {
        return null;
    }
}
