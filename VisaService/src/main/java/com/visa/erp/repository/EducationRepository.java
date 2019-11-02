package com.visa.erp.repository;

import com.visa.erp.DAO.AddressDao;
import com.visa.erp.DAO.EducationDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationRepository extends CrudRepository<EducationDao, Integer> {

    EducationDao findByStudentId(Long id);

    EducationDao save(EducationDao educationDao);
}