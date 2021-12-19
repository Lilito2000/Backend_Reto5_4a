/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retocinco.controller;

import com.retocinco.model.Clothe;
import com.retocinco.service.ClotheService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilia
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ClotheController {
 
    @Autowired
    private ClotheService clotheService;

    /**
     * Map the clothe collection and bring all clothes
     * @return a list of clothes in DB
     */
    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }
    
    /**
     * Map the clothe collection and bring a clothe by its id
     * @return a list of users in DB
     */
    @GetMapping("/{id}")
    public Optional<Clothe> getClothe(@PathVariable("id") String reference){ 
        return clotheService.getByReference(reference); }

    /**
     *
     * @param clothe
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe) {
        return clotheService.create(clothe);
    }
    
    /**
     * Allows to map an update of a clothe
     * @param clothe
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe) {
        return clotheService.update(clothe);
    }

    /**
     * Delete a clothe
     * @param reference
     * @return
     */
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Clothe> gadgetsByPrice(@PathVariable("price") double precio) {
        return clotheService.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Clothe> findByDescriptionLike(@PathVariable("description") String description) {
        return clotheService.findByDescriptionLike(description);
    }
  
}


