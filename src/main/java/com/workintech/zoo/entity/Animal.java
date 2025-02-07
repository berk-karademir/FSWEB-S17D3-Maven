package com.workintech.zoo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Animal {
    private int id;
    private String name;
    private Gender gender;
    private double weight;

    @Override
    public String toString() {
        return "Animal > " + getClass().getSimpleName() + " {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}