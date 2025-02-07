package com.workintech.zoo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo extends Animal {
    private double height;
    private Boolean isAggressive;

    public Kangaroo(int id, String name, double height, double weight, Gender gender, Boolean isAggressive) {
       super(id,name, gender,weight);
       this.height = height;
       this.isAggressive = isAggressive;

    }

    public Gender getGender() {
        return super.getGender();
    }

    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    @Override
    public String toString() {
        return super.toString()  +
                "height=" + height +
                ", isAggressive=" + isAggressive +
                '}';
    }
}