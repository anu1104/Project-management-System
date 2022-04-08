package com.project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project_Details")
public class ProjectDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
     private int id;
     private String name;
     private String type;
     private String owner;
    
 
public ProjectDTO(int id, String name,String type,String owner) {
	super();
	this.id = id;
	this.name = name;
	this.type=type;
	this.owner=owner;
	
}

public ProjectDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getOwner() {
	return owner;
}

public void setOwner(String owner) {
	this.owner = owner;
}


@Override
public String toString() {
	return "ProjectDTO [id=" + id + ", name=" + name + ", type=" + type
			+ ", owner=" + owner + "]";
}



 

 
 
}
