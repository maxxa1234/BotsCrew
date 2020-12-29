package com.bots.crew.dao;

import com.bots.crew.entity.AvgSalary;
import com.bots.crew.entity.Statistic;
import com.bots.crew.entity.Department;
import com.bots.crew.entity.Lector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorDao extends CrudRepository<Lector, Long> {


    @Query(value = "SELECT new Statistic(v.degree, count (v.degree)) from Lector v WHERE v.department.id = ?1 group by v.degree" )
    List<Statistic> findStatistic(Long id);

    @Query(value = "SELECT new AvgSalary (avg (v.salary), v.department.name ) from Lector v where  v.department.id = ?1  group by v.department")
    Optional<AvgSalary> findAvgSalary(Long id);

    @Query(value = "SELECT count (id) from Lector where department.id = ?1 group by department")
    Optional<Integer> findEmployeeCount(Long id);

    List<Lector> findByNameContains(String title);
}
