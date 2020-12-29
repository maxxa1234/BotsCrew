package com.bots.crew.service.impl;

import com.bots.crew.dao.LectorDao;
import com.bots.crew.entity.AvgSalary;
import com.bots.crew.service.DepartmentService;
import com.bots.crew.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LectorServiceImpl implements LectorService {
    private LectorDao lectorDao;
    private DepartmentService departmentService;

    @Autowired
    public LectorServiceImpl(LectorDao lectorDao, DepartmentService departmentService) {
        this.lectorDao = lectorDao;
        this.departmentService = departmentService;
    }

    @Override
    public void getStatistic(String name) {
        System.out.println(lectorDao.findStatistic(departmentService.getDepartmentByName(name).getId()));
    }

    @Override
    public void getAvgSalary(String name) {
        Optional<AvgSalary> avgSalary = lectorDao
                .findAvgSalary(departmentService
                        .getDepartmentByName(name)
                        .getId());
        avgSalary.ifPresent(System.out::println);
    }

    @Override
    public void getEmployeeCount(String name) {
        Optional<Integer> integer = lectorDao
                .findEmployeeCount(departmentService
                        .getDepartmentByName(name)
                        .getId());
        integer.ifPresent(System.out::println);
    }

    @Override
    public void search(String title) {
        lectorDao.findByNameContains(title).forEach(x -> System.out.println(x.getName()));
    }
}
