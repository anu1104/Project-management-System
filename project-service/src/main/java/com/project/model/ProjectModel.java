package com.project.model;

public class ProjectModel {

	 private int id;
     private String name;
     private String type;
     private String owner;
 
public ProjectModel(int id, String name,String type,String owner) {
	super();
	this.id = id;
	this.name = name;
	this.type=type;
	this.owner=owner;
}

public ProjectModel() {
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
