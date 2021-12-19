package com.retocinco.repository.crud;

import com.retocinco.model.Clothe;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author lilia
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {
    public List<Clothe> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Clothe> findByDescriptionLike(String description);
}

