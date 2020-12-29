package com.bots.crew.service.impl;

import com.bots.crew.dao.DepartmentDao;
import com.bots.crew.entity.Department;
import com.bots.crew.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void getDepartmentHeadName(String name) {
        System.out.println(getDepartmentByName(name).getHead_name());
    }

    @Override
    public Department getDepartmentByName(String name) {
        Optional<Department> department = departmentDao.findByName(name);
        if (department.isPresent()) {
            return department.get();
        }
        throw new NoSuchElementException("department: " + name + " not found");
    }

    @Override
    public void search(String title) {
        departmentDao.findByNameContains(title).forEach(x -> System.out.println(x.getName()));
    }
}
