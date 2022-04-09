package com.projectmanagementsystem.registrationservice.controller;

import com.projectmanagementsystem.registrationservice.dto.UserDetailsDTO;
import com.projectmanagementsystem.registrationservice.exception.InvalidProjectAccessException;
import com.projectmanagementsystem.registrationservice.model.*;
import com.projectmanagementsystem.registrationservice.service.ProjectAccessService;
import com.projectmanagementsystem.registrationservice.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1.0/project-tracker")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final ProjectAccessService projectAccessService;
    private final ModelMapper modelMapper;

    @Autowired
    public RegistrationController(RegistrationService registrationService,
                                  ProjectAccessService projectAccessService, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.projectAccessService = projectAccessService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/user/register")
    public ResponseEntity<RegistrationResponseModel> userSignup(@RequestBody RegistrationRequestModel loginRequestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDetailsDTO userDetailsDTO = modelMapper.map(loginRequestModel, UserDetailsDTO.class);
        UserDetailsDTO createdUser = registrationService.userSignup(userDetailsDTO);
        RegistrationResponseModel registrationResponseModel = modelMapper.map(createdUser, RegistrationResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponseModel);
    }

    @GetMapping("/user/get-details/{emailId}")
    public ResponseEntity<UserDetailsResponseModel> getUserDetailsByEmailId(@PathVariable String emailId){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDetailsDTO loginDTO = registrationService.getUserDetailsByEmailId(emailId);
        UserDetailsResponseModel userDetailsResponseModel = modelMapper.map(loginDTO, UserDetailsResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(userDetailsResponseModel);
    }

    @PostMapping("/manager/manage-user")
    public ResponseEntity<List<UserDetailsResponseModel>> manageProjectAccess(@RequestBody ProjectAccessRequestModel
                                                                        projectAccessRequestModel,
                                                                              @RequestHeader("projectIds") String projectIds){
        List<String> projectIdsFromRequest = new ArrayList<>();
        List<String> projectIdsFromHeader = Arrays.asList(projectIds.split(","));
        for(ProjectAccessRequest projectAccessRequest : projectAccessRequestModel.getProjectAccessRequests()){
            for(ProjectRoleModel projectRoleModel : projectAccessRequest.getProjectRoles()){
                projectIdsFromRequest.add(projectRoleModel.getProjectId());
            }
        }
        if(! projectIdsFromHeader.containsAll(projectIdsFromRequest))
            throw new InvalidProjectAccessException("ProjectIds mismatch between header and request");
        List<UserDetailsResponseModel> response = new ArrayList<>();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        projectAccessRequestModel.getProjectAccessRequests().forEach(projectAccessRequest -> {
            UserDetailsDTO userDetailsDTO = modelMapper.map(projectAccessRequest, UserDetailsDTO.class);
            UserDetailsDTO singleUserResponse = projectAccessService.manageProjectAccess(userDetailsDTO);
            response.add(modelMapper.map(singleUserResponse, UserDetailsResponseModel.class));
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
