package com.workintech.zoo.entity;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String displayValue;


    Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
