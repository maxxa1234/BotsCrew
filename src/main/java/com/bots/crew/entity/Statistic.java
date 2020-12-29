package com.bots.crew.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statistic {

    @Id
    private Long count;
    private Degree degree;

    public Statistic(Degree degree, Long count) {
        this.degree = degree;
        this.count = count;
    }

    public Statistic() {
    }

    @Override
    public String toString() {
        return degree + "S" +
                " - " + count;
    }
}
