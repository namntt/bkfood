package com.nam.bkfood.service;

import java.util.List;

import com.nam.bkfood.entity.Product;
import com.nam.bkfood.model.ProductDTO;
import com.nam.bkfood.model.SearchProductDTO;

public interface ProductService {
	void addProduct(ProductDTO productDTO);
	
	void updateProduct(ProductDTO productDTO);
	
	void deleteProduct(ProductDTO productDTO);
	
	ProductDTO getProductById(Long product_id);
	
	List<ProductDTO> findProduct(SearchProductDTO searchProductDTO);
	
	List<ProductDTO> getAllProductBySubProductId(Long subProduct_id);
	
	Long coutProduct(SearchProductDTO searchProductDTO);
}
