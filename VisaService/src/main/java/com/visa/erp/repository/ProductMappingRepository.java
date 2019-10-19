package com.visa.erp.repository;

import com.visa.erp.DAO.PricingProductMapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMappingRepository extends CrudRepository<PricingProductMapping, Integer>{
	                       int countBypricingPlansId(int planId);
	  @Query("select count(PricingPlansId) from PricingProductMapping where PricingPlansId=:planId")
	  int plansAreWith(@Param("planId")int planId);
}
