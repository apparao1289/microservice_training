package com.order.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.dao.ProductOrderDao;
import com.order.entity.model.ProductOrderDetails;
import com.order.entity.model.Result;
import com.order.util.CustomerServiceUtil;
import com.order.util.InventoryServiceUtil;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderDao productOrderDao;
	
	@Autowired
	private CustomerServiceUtil customerServiceUtil;
	
	@Autowired
	private InventoryServiceUtil inventoryServiceUtil;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Result createOrder(ProductOrderDetails productOrderDetails) {
		Result result = new Result();
		// step1: check the inventory.
		boolean productAvailable = inventoryServiceUtil.checkInventory(productOrderDetails.getProductItemDetails());
		
		if(productAvailable) {
			// step2: Customer credit validation.
			boolean creditAvailable = customerServiceUtil.checkCustomerCredit(productOrderDetails.getCustomerId(),
					productOrderDetails.getTotalPrice());
			
			if(creditAvailable) {
				// step3: insert the records to product_order table.
				productOrderDao.createOrder(productOrderDetails);
				
				// step4: Invoke the shipping service.
			} else {
				result.setStatus("FAIL");
				result.setMessage("Insufficient Customer credit.");
			}
		
		} else  {
			result.setStatus("FAIL");
			result.setMessage("Product are not available.");
		}
				
		result.setStatus("SUCCESS");
		result.setMessage("Product are not available.");
		return result;
	}

	@Transactional(readOnly = true)
	public ProductOrderDetails getOrderDetailsById(String id) {

		return productOrderDao.getOrderDetailsById(id);
	}

}
