package com.sges.service.impl;

import com.sges.entity.User;
import com.sges.jwt.JwtHelper;
import com.sges.repo.UserRepo;
import com.sges.service.AuthenticationService;
import com.sges.service.email.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder encoder;
    private final JwtHelper jwtHelper;
    private final MailSender mailSender;
    private final UserRepo userRepo;


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
}
