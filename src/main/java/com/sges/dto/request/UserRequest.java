package com.sges.dto.request;

import com.sges.entity.Address;
import com.sges.entity.Role;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
public class UserRequest {
    @NotBlank(message = "User name cannot be empty")
    private String username;

    private String avatar;

    @NotBlank(message = "Full name cannot be empty")
    private String fullname;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email invalid!")
    private String email;

    @Length(message = "Phone invalid!", min = 8, max = 15)
    private String phone;

    @NotNull(message = "Gender invalid!")
    private Integer gender;

    @NotNull(message = "Status invalid!")
    private Integer status;

    private String otpCode;
    private Set<Role> roles;
}

