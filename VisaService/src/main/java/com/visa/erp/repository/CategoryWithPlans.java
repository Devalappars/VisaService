package com.visa.erp.repository;

import com.visa.erp.DAO.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoryWithPlans extends CrudRepository<ProductCategory, Integer> {
	
  ProductCategory findByPricingProductMappingsPricingProductProductTag(String productTag);	          
}
