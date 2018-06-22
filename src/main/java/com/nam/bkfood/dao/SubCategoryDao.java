package com.nam.bkfood.dao;

import java.util.List;


import com.nam.bkfood.entity.SubCategory;
import com.nam.bkfood.model.SearchSubCategoryDTO;

public interface SubCategoryDao {
	void addSubProductType(SubCategory subCategory);
	
	void updateSubProductType(SubCategory subCategory);
	
	void deleteSubProductType(SubCategory subCategory);
	
	SubCategory getSubCategoryById(Long subCategory_id);
	
	List<SubCategory> findSubCategory(SearchSubCategoryDTO searchSubCategoryDTO);
	
	Long countSubCategory(SearchSubCategoryDTO searchSubCategoryDTO);

	

}
