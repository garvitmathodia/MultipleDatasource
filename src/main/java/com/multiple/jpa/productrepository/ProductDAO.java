package com.multiple.jpa.productrepository;

import org.springframework.data.repository.CrudRepository;

import com.multiple.jpa.productentity.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}
