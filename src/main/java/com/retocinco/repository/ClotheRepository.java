package com.retocinco.repository;

import com.retocinco.model.Clothe;
import com.retocinco.repository.crud.ClotheCrudRepository;
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
    //Reto 5
    public List<Clothe> gadgetsByPrice(double precio) {
        return clotheCrudRepository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Clothe> findByDescriptionLike(String description) {
        return clotheCrudRepository.findByDescriptionLike(description);
    }
    
    
}
