package com.projectmanagementsystem.registrationservice.service;

import com.projectmanagementsystem.registrationservice.dto.UserDetailsDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RegistrationService extends UserDetailsService {
    public UserDetailsDTO userSignup(UserDetailsDTO userDetailsDTO);
    public UserDetailsDTO getUserDetailsByEmailId(String emailId);
}
