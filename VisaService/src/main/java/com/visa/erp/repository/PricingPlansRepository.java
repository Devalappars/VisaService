package com.visa.erp.repository;

import com.visa.erp.DAO.PricingPlanDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PricingPlansRepository extends CrudRepository<PricingPlanDAO, Integer>{
	                          PricingPlanDAO findById(int id);
}
