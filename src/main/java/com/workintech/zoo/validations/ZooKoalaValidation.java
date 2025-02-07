package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Gender;
import com.workintech.zoo.entity.Koala;

import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.EnumSet;
import java.util.Map;

public class ZooKoalaValidation {


    public static void isIdValid(Integer id) {
        if (id == null || id < 0) {
            throw new ZooException("Koala ID " + id + " is not valid.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isAnyKoalaExist(Map<Integer, Koala> koalas) {
        if (koalas == null || koalas.isEmpty()) {
            throw new ZooException("Can not found any koalas.", HttpStatus.NOT_FOUND);
        }
    }

    public static void isKoalaExist(Map<Integer, Koala> koalas, int id, boolean existence) {
        if (existence) {
            if (!koalas.containsKey(id)) {
                throw new ZooException("Koala with id " + id + " not found!", HttpStatus.NOT_FOUND);
            } else {
                if (koalas.containsKey(id)) {
                    throw new ZooException("Koala with id " + id + " is already exist! ", HttpStatus.BAD_REQUEST);
                }
            }
        }
    }


//    public static void isNameValid(String name) {
//        if (name == null || name.trim().isEmpty()) {
//            throw new ZooException("'" + name +"' invalid animal name!", HttpStatus.BAD_REQUEST);
//        }
//    }

    public static void isWeightValid(Double weight) {
        if( weight == null ||weight < 0 ) {
            throw new ZooException("'"+ weight + "' Koala's weight is not valid!",HttpStatus.BAD_REQUEST);
        }
    }



    public static void isHeightValid(Double height) {
        if( height == null ||height < 0 ) {
            throw new ZooException("'"+ height + "'Animals height is not valid!",HttpStatus.BAD_REQUEST);
        }
    }


    public static void isGenderValid(Gender gender) {
        if (gender == null) {
            throw new ZooException("Gender cannot be null.", HttpStatus.BAD_REQUEST);
        }

        if (!EnumSet.allOf(Gender.class).contains(gender)) {
            throw new ZooException("Invalid gender type.", HttpStatus.BAD_REQUEST);
        }
    }
}
