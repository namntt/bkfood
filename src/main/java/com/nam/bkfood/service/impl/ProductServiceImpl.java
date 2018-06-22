package com.nam.bkfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam.bkfood.dao.ProductDao;
import com.nam.bkfood.entity.Product;
import com.nam.bkfood.entity.SubCategory;
import com.nam.bkfood.model.ProductDTO;
import com.nam.bkfood.model.SearchProductDTO;
import com.nam.bkfood.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product=new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setPrice(productDTO.getPrice());
		product.setSubProductType(new SubCategory(productDTO.getTypeId()));
		productDao.addProduct(product);
		
		
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product=productDao.getProductById(productDTO.getId());
		if(product!=null){
			product.setId(productDTO.getId());
			product.setName(productDTO.getName());
			product.setDescription(productDTO.getDescription());
			product.setImage(productDTO.getImage());
			product.setPrice(productDTO.getPrice());
			product.setSubProductType(new SubCategory(productDTO.getTypeId()));
			productDao.updateProduct(product);
		}
		
	}

	@Override
	public void deleteProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product product=productDao.getProductById(productDTO.getId());
		if(product!=null){
			
			productDao.deleteProduct(product);
		}
	}

	@Override
	public ProductDTO getProductById(Long product_id) {
		Product product=productDao.getProductById(product_id);
		if(product!=null){
			ProductDTO productDTO=new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setPrice(product.getPrice());
			productDTO.setTypeId(product.getSubProductType().getId());
			return productDTO;
		}
		return null;
	}

	@Override
	public List<ProductDTO> findProduct(SearchProductDTO searchProductDTO) {
		int totalPage = (int) Math.ceil(productDao.countProduct(searchProductDTO) / (double) searchProductDTO.getPageSize());
		searchProductDTO.setTotalPage(totalPage > 0 ? totalPage : 0);
		List<Product> listProduct=productDao.findProduct(searchProductDTO);
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		for(Product product:listProduct){
			ProductDTO productDTO=new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setPrice(product.getPrice());
			productDTO.setTypeId(product.getSubProductType().getId());
			listProductDTO.add(productDTO);
		}
		return listProductDTO;
	}

	@Override
	public Long coutProduct(SearchProductDTO searchProductDTO) {
		
		return productDao.countProduct(searchProductDTO);
	}

	@Override
	public List<ProductDTO> getAllProductBySubProductId(Long subProduct_id) {
		
		List<Product> listProduct=productDao.findProduct(new SearchProductDTO());
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		
		for(Product product:listProduct){
			if(product.getSubProductType().getId()==subProduct_id){
				ProductDTO productDTO=new ProductDTO();
				productDTO.setName(product.getName());
				productDTO.setDescription(product.getDescription());
				productDTO.setImage(product.getImage());
				productDTO.setPrice(product.getPrice());
				productDTO.setTypeId(product.getSubProductType().getId());
				listProductDTO.add(productDTO);
			}
		}
		return listProductDTO;
	}

}
