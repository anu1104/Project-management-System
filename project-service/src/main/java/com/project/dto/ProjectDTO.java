package com.project.dto;

import com.project.model.ProjectType;
import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Project_Details")
public class ProjectDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
     private int projectId;
     private String projectName;
    @Enumerated(EnumType.STRING)
     private ProjectType projectType;
     private String managerId;
}
