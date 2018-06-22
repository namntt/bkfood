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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nam.bkfood.dao.ProductDao;
import com.nam.bkfood.entity.Product;
import com.nam.bkfood.entity.SubCategory;
import com.nam.bkfood.model.SearchProductDTO;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	EntityManager entityManager;
	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		entityManager.remove(product);
		
	}

	@Override
	public Product getProductById(Long product_id) {
		// TODO Auto-generated method stub
		return entityManager.find(Product.class, product_id);
	}

	@Override
	public List<Product> findProduct(SearchProductDTO searchProductDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		Join<Product, SubCategory> typeJoin = root.join("subProductType");

		if (StringUtils.isNotBlank(searchProductDTO.getName())) {
			criteriaQuery.where(builder.like(builder.lower(root.get("name")), "%" + searchProductDTO.getName() + "%"));
		}
		/*if (searchProductDTO.getTypeId() != null) {
			criteriaQuery.where(builder.equal(root.get("name"), searchProductDTO.getName()));
		}*/

		if (searchProductDTO.getTypeId() != null) {
			criteriaQuery.where(builder.equal(typeJoin.get("id"), searchProductDTO.getTypeId()));
		}

		// set max result / page
		TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchProductDTO.getPage() != null && searchProductDTO.getPageSize() != null) {
			typedQuery.setFirstResult((searchProductDTO.getPage() - 1) * searchProductDTO.getPageSize());
			typedQuery.setMaxResults(searchProductDTO.getPageSize());
		}
		// sort by id 
		criteriaQuery.orderBy(builder.asc(root.get("id")));

		return typedQuery.getResultList();
	}

	@Override
	public Long countProduct(SearchProductDTO searchProductDTO) {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery=criteriaBuilder.createQuery(Long.class);
		Root<Product> root=criteriaQuery.from(Product.class);
		Join<Product, SubCategory> typejoin=root.join("subProductType");
		if (StringUtils.isNotBlank(searchProductDTO.getName())) {
			criteriaQuery.where(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchProductDTO.getName() + "%"));
		}
		if(searchProductDTO.getTypeId()!=null){
			criteriaQuery.where(criteriaBuilder.equal(typejoin.get("id"), searchProductDTO.getTypeId()));
		}
		
		return entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root))).getSingleResult();
	}

	@Override
	public List<Product> getAllProductByTypeID(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
