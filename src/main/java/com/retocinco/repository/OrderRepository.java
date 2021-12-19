package com.retocinco.repository;


import com.retocinco.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.retocinco.repository.crud.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
/**
 *
 * @author lilia
 */
@Repository
public class OrderRepository {
    //Atributo de relación
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *
     * @return
     */
    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    /**
     *
     * @param order
     */
    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    /**
     *
     * @param order
     */
    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    /**
     *
     * @param zona
     * @return
     */
    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }

    /**
     *
     * @return
     */
    public Optional<Order> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * Ordenes de un vendedor por fecha
     * @param dateStr
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    /**
     *
     * @param state
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
    
    /*
    Recuperar las ordenes de un vendedor
    */
    public List<Order> ordersSalesManByID(Integer id) {
    Query query = new Query();
        
    Criteria criterio = Criteria.where("salesMan.id").is(id);
    query.addCriteria(criterio);
        
    List<Order> orders = mongoTemplate.find(query, Order.class);
        
    return orders;
        
 }
    
    
}
