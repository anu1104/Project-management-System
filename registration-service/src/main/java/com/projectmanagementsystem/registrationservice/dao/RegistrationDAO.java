package com.projectmanagementsystem.registrationservice.dao;

import com.projectmanagementsystem.registrationservice.entity.ProjectUser;
import com.projectmanagementsystem.registrationservice.entity.ProjectUserKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDAO extends CrudRepository<ProjectUser, ProjectUserKey> {
    ProjectUser findByEmailId(String emailId);
}
