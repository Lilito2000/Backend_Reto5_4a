/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retocuatro.repository.crud;

import com.retocuatro.model.Clothe;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilia
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {
    public List<Clothe> findByPriceLessThanEqual(double precio);
}

