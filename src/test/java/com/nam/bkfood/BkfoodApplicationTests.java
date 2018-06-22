package com.nam.bkfood;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nam.bkfood.dao.ProductDao;
import com.nam.bkfood.dao.SubCategoryDao;
import com.nam.bkfood.entity.Product;
import com.nam.bkfood.model.SearchProductDTO;
import com.nam.bkfood.model.SearchSubCategoryDTO;
import com.nam.bkfood.service.ProductService;
import com.nam.bkfood.service.SubCategoryService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class BkfoodApplicationTests {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
	@Autowired
	SubCategoryService subCategoryService;

	@Test
	public void contextLoads() {
		SearchSubCategoryDTO searchSubCategoryDTO=new SearchSubCategoryDTO();
		subCategoryService.findSubCategory(searchSubCategoryDTO);
		
	}

}
