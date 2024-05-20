package com.multiple.jpa.orderentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	private int id;
	
	private String orderfrom;
	
	private LocalDate orderDate;

	public Order() {
		
	}

	public Order(int id, String orderfrom, LocalDate date) {
		super();
		this.id = id;
		this.orderfrom = orderfrom;
		this.orderDate = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderfrom=" + orderfrom + ", date=" + orderDate + "]";
	}
	
	
	
	
}
