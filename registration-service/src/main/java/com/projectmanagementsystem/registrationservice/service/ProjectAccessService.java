package com.projectmanagementsystem.registrationservice.service;

import com.projectmanagementsystem.registrationservice.dto.UserDetailsDTO;

public interface ProjectAccessService {
    UserDetailsDTO manageProjectAccess(UserDetailsDTO userDetailsDTO);
}
