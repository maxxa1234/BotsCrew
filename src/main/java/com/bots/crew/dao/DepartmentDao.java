package com.bots.crew.dao;

import com.bots.crew.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Long> {
    Optional<Department> findByName(String name);
    List<Department> findByNameContains(String title);
 }
