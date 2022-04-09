package com.projectmanagementsystem.registrationservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projectmanagementsystem.registrationservice.model.CollaborationRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class ProjectRole {
    @EmbeddedId
    private ProjectRoleKey projectRoleKey;
    @Enumerated(EnumType.STRING)
    private CollaborationRole collaborationRole;
    @JsonBackReference
    @ManyToOne
    @MapsId("projectRoleKey")
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private ProjectUser projectUser;
}
