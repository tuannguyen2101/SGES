package com.sges.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String fullname;
    private String avatar;
    private String phone;
    private Integer gender;
    private Integer status;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, Integer id, String username, String fullname, String avatar, String phone, Integer gender, Integer status, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.avatar = avatar;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.email = email;
        this.roles = roles;
    }
}
