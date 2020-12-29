package com.bots.crew.service;

import com.bots.crew.entity.Department;

import java.util.List;

public interface LectorService {
    void getStatistic(String name);
    void getAvgSalary(String name);
    void getEmployeeCount(String name);
    void search(String title);
}
