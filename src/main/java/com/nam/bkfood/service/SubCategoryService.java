package com.nam.bkfood.service;

import java.util.List;

import com.nam.bkfood.model.SearchSubCategoryDTO;
import com.nam.bkfood.model.SubCategoryDTO;



public interface SubCategoryService {
	void addSubCategory(SubCategoryDTO subCategoryDTO);
	
	void updateSubCategory(SubCategoryDTO subCategoryDTO);
	
	void deleteSubCategory(SubCategoryDTO subCategoryDTO);
	
	SubCategoryDTO getSubCategoryById(Long subCategory_id);
	
	List<SubCategoryDTO> findSubCategory(SearchSubCategoryDTO searchSubCategoryDTO);
	
	
	
	Long coutSubCategory(SearchSubCategoryDTO searchSubCategoryDTO);
}
