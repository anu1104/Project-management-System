package com.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.dto.Status;
import com.project.dto.UserStoryDTO;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStoryDTO,Integer>{
	
  @Modifying
  @Query(nativeQuery=true , value="update user_story_details   set status=:status , is_Backlog=false where id in (:ids) returning id")
	public List<Integer> setStatusById(@Param("status") Status status, @Param("ids")List<Integer>ids);
  
  @Query(nativeQuery=true, value ="select id, name from user_story_details where id=:id")
	public List<Map<String,Object>>  searchById (@Param("id") int id);
	
	@Query(nativeQuery=true, value ="select id, name from user_story_details where name=:name")
	public List<Map<String,Object>>  searchByName (@Param("name") String name);
}
