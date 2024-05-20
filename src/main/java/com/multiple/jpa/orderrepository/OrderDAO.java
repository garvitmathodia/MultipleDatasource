package com.multiple.jpa.orderrepository;

import org.springframework.data.repository.CrudRepository;

import com.multiple.jpa.orderentity.Order;

public interface OrderDAO extends CrudRepository<Order, Integer> {

}
