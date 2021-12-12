/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retocuatro.repository;

import com.retocuatro.model.Clothe;
import com.retocuatro.repository.crud.ClotheCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lili
 */
@Repository
public class ClotheRepository {
    
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;

    public List<Clothe> getAll() {
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getByReference(String reference) {
        return clotheCrudRepository.findById(reference);
    }
    public Clothe create(Clothe clothe) {
        return clotheCrudRepository.save(clothe);
    }

    public void update(Clothe clothe) {
        clotheCrudRepository.save(clothe);
    }
    
    public void delete(String reference) {
        clotheCrudRepository.deleteById(reference);
    }
    
    
}
