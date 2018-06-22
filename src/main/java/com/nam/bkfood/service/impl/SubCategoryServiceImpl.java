package com.nam.bkfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam.bkfood.dao.SubCategoryDao;
import com.nam.bkfood.entity.Category;
import com.nam.bkfood.entity.SubCategory;
import com.nam.bkfood.model.SearchSubCategoryDTO;
import com.nam.bkfood.model.SubCategoryDTO;
import com.nam.bkfood.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	SubCategoryDao subCategoryDao;
	@Override
	public void addSubCategory(SubCategoryDTO subCategoryDTO) {
		SubCategory subCategory=new SubCategory();
		subCategory.setName(subCategoryDTO.getName());
		subCategory.setCategory(new Category(subCategoryDTO.getCategoryId()));
		subCategoryDao.addSubProductType(subCategory);
	}

	@Override
	public void updateSubCategory(SubCategoryDTO subCategoryDTO) {
		SubCategory subCategory=subCategoryDao.getSubCategoryById(subCategoryDTO.getId());
		if(subCategory!=null){
			subCategory.setName(subCategoryDTO.getName());
			subCategory.setCategory(new Category(subCategoryDTO.getCategoryId()));
			subCategoryDao.updateSubProductType(subCategory);
		}
		
	}

	@Override
	public void deleteSubCategory(SubCategoryDTO subCategoryDTO) {
		SubCategory subCategory=subCategoryDao.getSubCategoryById(subCategoryDTO.getId());
		if(subCategory!=null){
			subCategoryDao.deleteSubProductType(subCategory);
		}
		
	}

	@Override
	public SubCategoryDTO getSubCategoryById(Long subCategory_id) {
		SubCategory subCategory=subCategoryDao.getSubCategoryById(subCategory_id);
		SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
		if(subCategory!=null){
			subCategoryDTO.setName(subCategory.getName());
			subCategoryDTO.setCategoryId(subCategory.getCategory().getId());
			
		}
		return subCategoryDTO;
	}

	@Override
	public List<SubCategoryDTO> findSubCategory(SearchSubCategoryDTO searchSubCategoryDTO) {
//		int totalPage = (int) Math.ceil(subCategoryDao.countSubCategory(searchSubCategoryDTO) / (double) searchSubCategoryDTO.getPageSize());
//		searchSubCategoryDTO.setTotalPage(totalPage > 0 ? totalPage : 0);
		List<SubCategory> liSubCategories=subCategoryDao.findSubCategory(searchSubCategoryDTO);
		List<SubCategoryDTO> liCategoryDTOs=new ArrayList<SubCategoryDTO>();
		for(SubCategory subCategory:liSubCategories){
			SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
			subCategoryDTO.setId(subCategory.getId());
			subCategoryDTO.setName(subCategory.getName());
			subCategoryDTO.setCategoryId(subCategory.getCategory().getId());
			liCategoryDTOs.add(subCategoryDTO);
		}
		return liCategoryDTOs;
	}

	@Override
	public Long coutSubCategory(SearchSubCategoryDTO searchSubCategoryDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
