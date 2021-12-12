package com.retocuatro;

import com.retocuatro.repository.OrderRepository;
import com.retocuatro.repository.UserRepository;
import com.retocuatro.repository.crud.ClotheCrudRepository;
import com.retocuatro.repository.crud.OrderCrudRepository;
import com.retocuatro.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;


@SpringBootApplication
public class RetocuatroApplication implements CommandLineRunner {
   
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
	public static void main(String[] args) {
		SpringApplication.run(RetocuatroApplication.class, args);
	}
     @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        clotheCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }  

}