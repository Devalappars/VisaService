package com.visa.erp.repository;

import com.visa.erp.DAO.PricingProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.String;

@Repository
public interface PricingProductRepository extends CrudRepository<PricingProduct, Integer> {

	        //PricingProduct findByProductTagAndPricingProductMappingTranstionType(String producttag, String transactionType);
	                  
	        PricingProduct findByProductTag(String productTag);
	        PricingProduct findByProductTagAndPricingProductMappingTransactionType(String producttag , String transactionType);
	        //PricingProduct findByProductTTAndPricingProductMappingTranstionType(String producttt, String transactionType);
	        PricingProduct findByProductTT(String productTT);
	        PricingProduct findByProductTTAndPricingProductMappingTransactionType(String producttt, String transactionType);
	        //PricingProduct findByFtNumberAndPricingProductMappingTranstionType(String ftnumber, String transactionType);
	        PricingProduct findByFtNumber(String ftnumber);
	        PricingProduct findByFtNumberAndPricingProductMappingTransactionType(String ftnumber, String transactionType);
	      
	        /*@Query("select a.id from PricingPlans a join PricingProductMapping b on  a.id=b.PricingPlansId join PricingProduct c on c.id= b.PricingProductId where c.ProductTag=:productTag")
	        int findPlanID(@Param("productTag") String productTag);*/
	        
	        /*@Query("update pricingPlans a SET a.IndividualFixedFee =:individualFixedFee, a.IndividualVariableFee=:individualVariableFee,a.StaffFixedFee=:staffFixedFee,a.StaffVariableFee=:staffVariableFee Inner Join pricingproductmapping b on a.id=b.PricingPlansId join pricingproduct c on c.Id=b.PricingProductId where c.ProductTag=:productTag")
	        void updateByTag(@Param("productTag")String productTag, @Param("individualVariableFee")String individualVariableFee,@Param("individualFixedFee")String individualFixedFee,@Param("staffVariableFee")String staffVariableFee,@Param("staffFixedFee")String staffFixedFee);
*/	        
	        
         
}
