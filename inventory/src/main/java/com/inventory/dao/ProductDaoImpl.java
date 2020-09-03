package com.inventory.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.inventory.entity.Product;
import com.inventory.model.ProductDetails;
import com.inventory.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void onboardProduct(ProductDetails productDetails) {

		Product product = new Product();

		BeanUtils.copyProperties(productDetails, product);
		product.setCreated_on(new Date());
		product.setCreatedBy("ADMIN");
		product.setLastUpdatedBy("ADMIN");
		product.setLastUpdatedOn(new Date());

		productRepository.save(product);
	}

	@Override
	public ProductDetails getProductById(String id) {

		ProductDetails productDetails = new ProductDetails();

		Optional<Product> productEntity = productRepository.findById(id);

		Product product = productEntity.get();

		BeanUtils.copyProperties(product, productDetails);

		return productDetails;
	}

	@Override
	public List<ProductDetails> getProductByName(String name) {

		ProductDetails productDetails = null;

		List<ProductDetails> productDetailsList = new ArrayList<>();

		List<Product> productList = productRepository.findByName(name);

		if (!CollectionUtils.isEmpty(productList)) {

			for (Product p : productList) {

				productDetails = new ProductDetails();

				BeanUtils.copyProperties(p, productDetails);

				productDetailsList.add(productDetails);
			}
		}

		return productDetailsList;
	}

}
