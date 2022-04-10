package com.projectmanagementsystem.registrationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "project-service")
public interface ProjectServiceClient {

    @GetMapping("/api/v1.0/project-tracker/all-projectids")
    public List<String> getAllProjectIds();
}
