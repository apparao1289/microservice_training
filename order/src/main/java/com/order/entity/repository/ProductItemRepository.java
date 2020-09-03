package com.order.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, String>{

	List<ProductItem> findByOrderId(String orderId);

}
