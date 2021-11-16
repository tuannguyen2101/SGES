package com.sges.dto.response;

import com.sges.entity.Role;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String avatar;
    private String fullname;
    private String email;
    private String phone;
    private Integer gender;
    private Integer status;
    private String otpCode;
    private Set<Role> roles;
}
