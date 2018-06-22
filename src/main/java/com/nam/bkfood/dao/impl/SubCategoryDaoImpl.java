package com.nam.bkfood.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nam.bkfood.dao.SubCategoryDao;
import com.nam.bkfood.entity.Category;
import com.nam.bkfood.entity.Product;
import com.nam.bkfood.entity.SubCategory;
import com.nam.bkfood.model.SearchSubCategoryDTO;

@Repository
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao{
	@Autowired
	EntityManager entityManager;
	@Override
	public void addSubProductType(SubCategory subCategory) {
		entityManager.persist(subCategory);
		
	}

	@Override
	public void updateSubProductType(SubCategory subCategory) {
		entityManager.merge(subCategory);
		
	}

	@Override
	public void deleteSubProductType(SubCategory subCategory) {
		entityManager.remove(subCategory);
		
	}

	@Override
	public SubCategory getSubCategoryById(Long subCategory_id) {
		return entityManager.find(SubCategory.class, subCategory_id);
	}

	@Override
	public List<SubCategory> findSubCategory(SearchSubCategoryDTO searchSubCategoryDTO) {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<SubCategory> criteriaQuery=criteriaBuilder.createQuery(SubCategory.class);
		Root<SubCategory> root=criteriaQuery.from(SubCategory.class);
		Join<SubCategory, Category> join=root.join("category");
		
		if(StringUtils.isNotBlank(searchSubCategoryDTO.getName())){
			criteriaQuery.where(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+ searchSubCategoryDTO.getName()));
		}
		if(searchSubCategoryDTO.getCategoryId()!=null){
			criteriaQuery.where(criteriaBuilder.equal(join.get("id"), searchSubCategoryDTO.getName()));
		}
		TypedQuery<SubCategory> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		return typedQuery.getResultList();
	}

	@Override
	public Long countSubCategory(SearchSubCategoryDTO searchSubCategoryDTO) {
//		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
//		CriteriaQuery<SubCategory> criteriaQuery=criteriaBuilder.createQuery(SubCategory.class);
//		Root<SubCategory> root=criteriaQuery.from(SubCategory.class);
//		Join<SubCategory, Category> join=root.join("category");
//		
//		if(StringUtils.isNotBlank(searchSubCategoryDTO.getName())){
//			criteriaQuery.where(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+ searchSubCategoryDTO.getName()));
//		}
//		if(searchSubCategoryDTO.getCategoryId()!=null){
//			criteriaQuery.where(criteriaBuilder.equal(join.get("id"), searchSubCategoryDTO.getName()));
//		}
		
		return null;
	}

}
