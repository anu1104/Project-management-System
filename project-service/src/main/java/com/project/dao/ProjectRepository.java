package com.project.dao;

import java.util.List;
import java.util.Map;

import com.project.model.ProjectDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.dto.ProjectDTO;
import com.project.model.ProjectDetailsModel;
import com.project.queries.ProjectQuery;

public interface ProjectRepository extends JpaRepository<ProjectDTO, String> {
	
	@Query(nativeQuery=true, value="select * from project_details where project_id in(:projectIds)")
	public List<ProjectDTO> findProjectDetailsById(@Param("projectIds") List<String> projectIds);
	
	@Query(nativeQuery=true, value=ProjectQuery.query)
	public List<ProjectDetailsModel> getAllDetails();

	public List<ProjectDTO> findByManagerId(String managerId);
	
	@Query(nativeQuery=true, value ="select id, name from project_details where id=:id")
	public List<Map<String,Object>>  searchById (@Param("id") int id);
	
	@Query(nativeQuery=true, value ="select id, name from project_details where name=:name")
	public List<Map<String,Object>>  searchByName (@Param("name") String name);

}
