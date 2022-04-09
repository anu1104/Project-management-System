package com.projectmanagementsystem.registrationservice.dao;

import com.projectmanagementsystem.registrationservice.entity.ProjectRole;
import com.projectmanagementsystem.registrationservice.entity.ProjectRoleKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectAccessDAO extends CrudRepository<ProjectRole, ProjectRoleKey> {
}
