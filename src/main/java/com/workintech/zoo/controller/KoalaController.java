package com.workintech.zoo.controller;


import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import com.workintech.zoo.validations.ZooKangarooValidation;
import com.workintech.zoo.validations.ZooKoalaValidation;
import com.workintech.zoo.validations.ZooKoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;


    @PostConstruct
    public void init() {
        this.koalas = new HashMap<>();
    }


    @GetMapping
    public List<Koala> getAllKoalas() {
        return koalas.values().stream().toList();
    }


    @GetMapping("/{id}")
    public Koala findKoalaById(@PathVariable("id") int id) {

        return koalas.get(id);
    }



    @PostMapping
    public Koala addAKoala(@RequestBody Koala koala) {
        ZooKoalaValidation.isKoalaExist(koalas, koala.getId(),false);
//        ZooKoalaValidation.isNameValid(koala.getName());
        ZooKoalaValidation.isWeightValid(koala.getWeight());
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }


    @PutMapping("/{id}")
    public Koala updateAKoala(@PathVariable("id") Integer id, @RequestBody Koala koala) {
        ZooKoalaValidation.isIdValid(id);
        ZooKoalaValidation.isKoalaExist(koalas, id, false);
        ZooKoalaValidation.isWeightValid(koala.getWeight());
//        ZooKoalaValidation.isNameValid(koala.getName());
        koala.setId(id);
        if (koalas.containsKey(id)) {
            koalas.put(id, koala);
            return koalas.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable("id") int id) {
        return koalas.remove(id);
    }

}
