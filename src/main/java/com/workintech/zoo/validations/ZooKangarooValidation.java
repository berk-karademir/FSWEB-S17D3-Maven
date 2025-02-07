package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Gender;
import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.EnumSet;
import java.util.Map;

public class ZooKangarooValidation {


    public static void isIdValid(Integer id) {
        if (id == null || id < 0) {
            throw new ZooException("Kangaroo ID " + id + " is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isAnyKangarooExist(Map<Integer, Kangaroo> kangaroos) {
        if (kangaroos == null || kangaroos.isEmpty()) {
            throw new ZooException("Can not found any kangaroos.", HttpStatus.NOT_FOUND);
        }
    }

    public static void isKangarooExist(Map<Integer, Kangaroo> kangaroos, int id, boolean existence) {
        if (existence) {
            if (!kangaroos.containsKey(id)) {
                throw new ZooException("Kangaroo with id " + id + " not found!", HttpStatus.NOT_FOUND);
            } else {
                if (kangaroos.containsKey(id)) {
                    throw new ZooException("Kangaroo with id " + id + " is already exist! ", HttpStatus.BAD_REQUEST);
                }
            }
        }
    }


    public static void isNameValid(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ZooException("'" + name +"' invalid name!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void buVal(Map<Integer, Kangaroo> kangaroos,Integer id) {
        if (kangaroos.get(id) == null) {
            throw new ZooException("not found", HttpStatus.NOT_FOUND);
        }
    }

    public static void isWeightValid(Double weight) {
        if( weight == null ||weight < 0 ) {
            throw new ZooException("'"+ weight + "' kangaroo's weight is not valid!",HttpStatus.BAD_REQUEST);
        }
    }



    public static void isHeightValid(Double height) {
        if( height == null ||height < 0 ) {
            throw new ZooException("'"+ height + "' kangaroo's height is not valid!",HttpStatus.BAD_REQUEST);
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