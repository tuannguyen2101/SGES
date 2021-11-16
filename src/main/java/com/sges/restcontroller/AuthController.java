package com.sges.restcontroller;

import com.sges.config.AuthenticationMapper;
import com.sges.dto.CustomUserDetail;
import com.sges.dto.request.ForgotPasswordRequest;
import com.sges.dto.request.SigninRequest;
import com.sges.dto.request.SignupRequest;
import com.sges.dto.response.JwtResponse;
import com.sges.dto.response.MessageResponse;
import com.sges.dto.response.UserResponse;
import com.sges.entity.AuthProvider;
import com.sges.entity.ERole;
import com.sges.entity.Role;
import com.sges.entity.User;
import com.sges.exception.ApiRequestException;
import com.sges.exception.PasswordConfirmException;
import com.sges.exception.PasswordException;
import com.sges.jwt.JwtHelper;
import com.sges.repo.RoleRepo;
import com.sges.repo.UserRepo;
import com.sges.service.RoleService;
import com.sges.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationMapper authenticationMapper;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if (userRepo.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getAvatar(),
                signupRequest.getFullname(),
                signupRequest.getEmail(),
                signupRequest.getPhone(),
                signupRequest.getGender(),
                signupRequest.getStatus());
        Set<String> strRoles= signupRequest.getRole();
        Set<Role> roles= new HashSet<>();
        if (strRoles==null){
            Role userRole = roleRepo.findByRole(ERole.USER)
                    .orElseThrow(()->new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }else {
            strRoles.forEach(role->{
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepo.findByRole(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "user":
                        Role userRole = roleRepo.findByRole(ERole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);

                        break;
                    default:
                        Role guestRole = roleRepo.findByRole(ERole.GUEST)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(guestRole);
                }
            });
        }
        user.setRoles(roles);
        user.setProvider(AuthProvider.LOCAL);
        userRepo.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody SigninRequest signinRequest){
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),signinRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtHelper.generateJwtToken(authentication);

        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        List<String> roles = userDetail.getAuthorities().stream()
                .map(item->item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(token,
                                                userDetail.getId(),
                                                userDetail.getUsername(),
                                                userDetail.getFullname(),
                                                userDetail.getAvatar(),
                                                userDetail.getPhone(),
                                                userDetail.getGender(),
                                                userDetail.getStatus(),
                                                userDetail.getEmail(),
                                                roles));
    }
    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest passwordReset) {
        boolean forgotPassword = authenticationMapper.sendPasswordResetCode(passwordReset.getEmail());
        if (!forgotPassword) {
            throw new ApiRequestException("Email not found", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Reset password code is send to your E-mail");
    }

    // reset password by otpCode
    @GetMapping("/reset/{code}")
    public ResponseEntity<UserResponse> getPasswordResetCode(@PathVariable String code) {
        UserResponse user = authenticationMapper.findByOtpCode(code);
        if (user == null) {
            throw new ApiRequestException("Password reset code is invalid!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> passwordReset(@RequestBody ForgotPasswordRequest passwordReset) {
        if (authenticationMapper.isPasswordConfirmEmpty(passwordReset.getPassword2())) {
            throw new PasswordConfirmException("Password confirmation cannot be empty.");
        }
        if (authenticationMapper.isPasswordDifferent(passwordReset.getPassword(), passwordReset.getPassword2())) {
            throw new PasswordException("Passwords do not match.");
        }
        return ResponseEntity.ok(authenticationMapper.passwordReset(passwordReset.getEmail(), passwordReset.getPassword()));
    }
}
