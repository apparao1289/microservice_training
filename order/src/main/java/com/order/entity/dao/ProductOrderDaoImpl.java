package com.order.entity.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.order.entity.ProductItem;
import com.order.entity.ProductOrder;
import com.order.entity.model.ProductItemDetails;
import com.order.entity.model.ProductOrderDetails;
import com.order.entity.repository.ProductItemRepository;
import com.order.entity.repository.ProductOrderRepository;

@Repository
public class ProductOrderDaoImpl implements ProductOrderDao {

	@Autowired
	private ProductOrderRepository productOrderRepository;

	@Autowired
	private ProductItemRepository productItemRepository;

	@Override
	public void createOrder(ProductOrderDetails productOrderDetails) {

		ProductOrder productOrder = new ProductOrder();
		productOrder.setCreated_on(new Date());
		productOrder.setCreatedBy("ADMIN");
		productOrder.setLastUpdatedBy("ADMIN");
		productOrder.setLastUpdatedOn(new Date());
		productOrder.setCustomerId(productOrderDetails.getCustomerId());
		productOrder.setTotalPrice(productOrderDetails.getTotalPrice());
		productOrder.setName(productOrderDetails.getName());

		ProductOrder pOrder = productOrderRepository.save(productOrder);

		if (!CollectionUtils.isEmpty(productOrderDetails.getProductItemDetails())) {
			ProductItem productItem = null;
			List<ProductItem> productItemList = new ArrayList<>();
			for (ProductItemDetails productItemDetails : productOrderDetails.getProductItemDetails()) {
				productItem = new ProductItem();
				productItem.setCreated_on(new Date());
				productItem.setCreatedBy("ADMIN");
				productItem.setLastUpdatedBy("ADMIN");
				productItem.setLastUpdatedOn(new Date());
				productItem.setName(productItemDetails.getName());
				productItem.setOrderId(pOrder.getId());
				productItem.setPrice(productItemDetails.getPrice());
				productItemList.add(productItem);
			}
			productItemRepository.saveAll(productItemList);
		}
	}

	@Override
	public ProductOrderDetails getOrderDetailsById(String id) {
		ProductOrderDetails productOrderDetails = new ProductOrderDetails();

		Optional<ProductOrder> productOrderEntity = productOrderRepository.findById(id);
		ProductOrder productOrder = productOrderEntity.get();

		BeanUtils.copyProperties(productOrder, productOrderDetails);

		if (null != productOrder) {
			List<ProductItem> pitemList = productItemRepository.findByOrderId(productOrder.getId());
			productOrderDetails.setProductItemDetails(getProductItemDetails(pitemList));
		}

		return productOrderDetails;
	}

	private List<ProductItemDetails> getProductItemDetails(List<ProductItem> pitemList) {

		ProductItemDetails productItemDetails = null;
		List<ProductItemDetails> productItemDetailsList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(pitemList)) {
			for (ProductItem productItem : pitemList) {
				productItemDetails = new ProductItemDetails();
				BeanUtils.copyProperties(productItem, productItemDetails);
				productItemDetailsList.add(productItemDetails);
			}
		}

		return productItemDetailsList;
	}

}
