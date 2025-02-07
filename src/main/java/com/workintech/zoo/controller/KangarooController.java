package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import com.workintech.zoo.exceptions.ZooGlobalExceptionHandler;
import com.workintech.zoo.validations.ZooKangarooValidation;
import com.workintech.zoo.validations.ZooKoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

   private Map<Integer, Kangaroo> kangaroos;



    @PostConstruct
    public void initCall() {
        kangaroos = new HashMap<>();
    }


//    //ArrayList olarak response dönmek istersek
@GetMapping
public List<Kangaroo> getAllKangaroos() {
    ZooKangarooValidation.isAnyKangarooExist(kangaroos);
    return kangaroos.values().stream().toList();
}

//    @GetMapping
//    public ResponseEntity<Map<Integer,Kangaroo> > getAllKangaroos() {
//        if(kangaroos.size()==0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(kangaroos,HttpStatus.OK);
//    }



    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable("id") Integer id) {
        ZooKangarooValidation.buVal(kangaroos,id);
        ZooKangarooValidation.isIdValid(id);
        if(kangaroos.containsKey(id)) {
            return kangaroos.get(id);
        }
        return null;
    }


    @PostMapping
    public Kangaroo addAKangaroo(@RequestBody Kangaroo kangaroo) {
        ZooKangarooValidation.isKangarooExist(kangaroos, kangaroo.getId(),false);
        ZooKangarooValidation.isNameValid(kangaroo.getName());
        ZooKangarooValidation.isWeightValid(kangaroo.getWeight());
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }


    @PutMapping("/{id}")
     public Kangaroo updateAKangaroo(@PathVariable("id") Integer id, @RequestBody Kangaroo kangaroo) {
        ZooKangarooValidation.isIdValid(id);
        ZooKangarooValidation.isKangarooExist(kangaroos, id, false);
        ZooKangarooValidation.isWeightValid(kangaroo.getWeight());
        kangaroo.setId(id);
        if (kangaroos.containsKey(id)) {
            kangaroos.put(id, kangaroo);
            return kangaroos.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable("id") int id) {
        ZooKangarooValidation.isIdValid(id);

        return kangaroos.remove(id);
    }







}
