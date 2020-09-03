package com.order.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, String>{

}
