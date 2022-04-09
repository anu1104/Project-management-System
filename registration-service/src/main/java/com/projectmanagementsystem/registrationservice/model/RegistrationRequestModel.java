package com.projectmanagementsystem.registrationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequestModel {
    @NotNull(message = "Username should not be empty")
    @Email
    private String emailId;
    @NotNull(message = "Password should not be empty")
    @Size(min = 8, message = "Password should be of minimum 8 characters")
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
