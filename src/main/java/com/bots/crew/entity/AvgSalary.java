package com.bots.crew.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class AvgSalary {

    @Id
    private Double avgSalary;
    private String departmentName;

    public AvgSalary(Double avgSalary, String departmentName) {
        this.avgSalary = avgSalary;
        this.departmentName = departmentName;
    }

    public AvgSalary() {
    }

    @Override
    public String toString() {
        return "The average salary of "
                 + departmentName +
                " is " + avgSalary;
    }
}
