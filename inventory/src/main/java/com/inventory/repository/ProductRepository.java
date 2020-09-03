package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	List<Product> findByName(String name);

}
