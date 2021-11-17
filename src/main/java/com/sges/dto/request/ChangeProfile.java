package com.sges.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeProfile {
    private String username;
    private String fullname;
    private String phone;
    private Integer gender;
    private Integer status;
    private String email;

    public ChangeProfile() {
    }

    public ChangeProfile(String username,String fullname, String phone, Integer gender, Integer status, String email) {
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.email = email;
    }
}
