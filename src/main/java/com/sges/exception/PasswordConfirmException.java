package com.sges.exception;

import lombok.Getter;

@Getter
public class PasswordConfirmException extends RuntimeException {
    private final String password2Error;

    public PasswordConfirmException(String password2Error) {
        this.password2Error = password2Error;
    }

}
