package com.nam.bkfood.dao;

import java.util.List;

import com.nam.bkfood.entity.Product;
import com.nam.bkfood.model.SearchProductDTO;

public interface ProductDao {
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Product product);
	
	Product getProductById(Long product_id);
	
	List<Product> findProduct(SearchProductDTO searchProductDTO);
	
	Long countProduct(SearchProductDTO searchProductDTO);

	List<Product> getAllProductByTypeID(int id);
}
