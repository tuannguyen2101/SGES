package com.sges.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePasswordRequest {

    @NotBlank(message = "Not blank")
    String currentPassword;
    @NotBlank(message = "Not blank")
    @Size(min = 6,max = 12,message = "length Invalid")
    String newPassword;

    public ChangePasswordRequest(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public ChangePasswordRequest() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }


    public String getNewPassword() {
        return newPassword;
    }

}
