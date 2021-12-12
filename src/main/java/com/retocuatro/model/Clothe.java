/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retocuatro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lilia
 */
@Document(collection = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Clothe {

@Id
private String reference;
private String category;
private String size;
private String description;
private boolean availability = true;
private double price;
private int quantity;
private String photography;

}