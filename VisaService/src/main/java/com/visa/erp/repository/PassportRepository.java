package com.visa.erp.repository;

import com.visa.erp.DAO.AddressDao;
import com.visa.erp.DAO.PassportDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassportRepository extends CrudRepository<PassportDao, Integer> {

    PassportDao findByStudentId(Long id);

    PassportDao save(PassportDao passportDao);
}