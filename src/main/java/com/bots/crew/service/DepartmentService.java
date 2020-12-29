package com.bots.crew.service;

import com.bots.crew.entity.Department;

import java.util.Optional;

public interface DepartmentService {
    void getDepartmentHeadName(String name);
    Department getDepartmentByName(String name);
    void search(String title);
}
