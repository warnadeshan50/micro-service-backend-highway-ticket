package com.example.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class UserEntity implements Serializable {

    @Id
    private String user_id;
    @NotNull(message = "First name is mandatory")
    private String user_first_name;
    @NotNull(message = "Last name mandatory")
    private String user_last_name;
    @Email(message = "Email is not valid")
    @NotNull(message = "Email is mandatory")
    private String user_email;
    @NotNull(message = "Phone number is mandatory")
    private String user_phone;
    @NotNull(message = "Address is mandatory")
    private String user_address;
    @NotNull(message = "Password is mandatory")
    private String user_password;
}
