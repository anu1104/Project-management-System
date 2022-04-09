package com.projectmanagementsystem.registrationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectAccessRequestModel {
    private List<ProjectAccessRequest> projectAccessRequests;
}
