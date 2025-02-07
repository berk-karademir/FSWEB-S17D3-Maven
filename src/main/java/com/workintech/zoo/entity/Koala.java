package com.workintech.zoo.entity;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koala extends Animal {
    private double sleepHour;

//    public Koala(int id, String name, GenderType gender, double weight, double sleepHour) {
//        super(id, name, gender, weight);
//        this.sleepHour = sleepHour;
//    }

   public Koala(int id, String name, double sleepHour, double weight, Gender gender) {
       super(id, name, gender, weight);
       this.sleepHour = sleepHour;
   }




    @Override
    public String toString() {
        return super.toString()  +
                "sleepHour=" + sleepHour +
                '}';
    }
}