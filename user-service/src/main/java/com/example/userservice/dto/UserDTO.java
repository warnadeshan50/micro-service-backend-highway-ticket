package com.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private String user_id;
    @NotNull
    private String user_first_name;
    @NotNull
    private String user_last_name;
    @Email
    @NotNull
    private String user_email;
    @NotNull
    private String user_phone;
    @NotNull
    private String user_address;
    @NotNull
    private String user_password;
}