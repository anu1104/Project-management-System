package com.project.dao;

import com.project.dto.SprintDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<SprintDTO,Integer> {
}
