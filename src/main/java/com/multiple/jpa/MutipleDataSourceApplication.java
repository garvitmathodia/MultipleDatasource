package com.multiple.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.multiple.jpa.orderentity.Order;
import com.multiple.jpa.orderrepository.OrderDAO;
import com.multiple.jpa.productentity.Product;
import com.multiple.jpa.productrepository.ProductDAO;

@SpringBootApplication
public class MutipleDataSourceApplication implements CommandLineRunner {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(MutipleDataSourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("inserting the data in db");
		Product product = new Product(1, "Laptop", 200000.00);
		productDAO.save(product);
		
		Order order = new Order(1 , "Amazon" , LocalDate.now());
		orderDAO.save(order);
		
	}

}
