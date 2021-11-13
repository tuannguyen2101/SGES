package com.sges.dto.request;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class SignupRequest {
    @NotNull(message = "Username invalid!")
    @NotBlank(message = "Username invalid!")
    @Length(message = "Username invalid!", min = 6, max = 45)
    private String username;
    @NotNull(message = "Password invalid!")
    @NotBlank(message = "Password invalid!")
    @Length(message = "Password invalid!", min = 6, max = 45)
    private String password;
    @NotBlank
    private String avatar;
    @NotNull(message = "Fullname invalid!")
    @NotBlank(message = "Fullname invalid!")
    private String fullname;
    @Email(message = "Email invalid!")
    @NotNull(message = "Email invalid!")
    @NotBlank(message = "Email invalid!")
    private String email;
    @Length(message = "Phone invalid!", min = 8, max = 15)
    @NotNull(message = "Phone invalid!")
    @NotBlank(message = "Phone invalid!")
    private String phone;
    @NotNull(message = "Gender invalid!")
    private Integer gender;
    @NotNull(message = "Status invalid!")
    private Integer status;
    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
