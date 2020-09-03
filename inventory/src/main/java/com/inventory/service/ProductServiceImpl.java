package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.ProductDao;
import com.inventory.model.ProductDetails;
import com.inventory.model.Result;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public Result onboardProduct(ProductDetails productDetails) {

		productDao.onboardProduct(productDetails);

		Result result = new Result();
		result.setStatus("SUCCESS");
		result.setMessage("Product is onboarded successfully");

		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public ProductDetails getProductById(String id) {

		return productDao.getProductById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductDetails> getProductByName(String name) {

		return productDao.getProductByName(name);
	}

}
