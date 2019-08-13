package com.zensar.business;

import java.util.List;

import com.zensar.entities.Product;

/*
 * Author:	Parul Singh
 * Creation Date: 26th Jul 2019 10.00AM
 * Modified Date: 26th Jul 2019 10.00AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Business Object Interface
 * It is used to access business logic of Product 
 */
public interface ProductService {
	
	void create(Product product);
	void edit(Product product);
	void remove(Product product);
	Product findProductById(int productId);
	List<Product> findAllProducts();
	int getProductCount();
	List<Product> findProductsByBrand(String brand);
	List<Product> findProductsByPriceRange(double minPrice,double maxprice);
	
	
}
