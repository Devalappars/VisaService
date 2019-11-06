package com.visa.erp.repository;

import com.visa.erp.DAO.EducationDao;
import com.visa.erp.DAO.SOFDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SOFRepository extends CrudRepository<SOFDao, Integer> {

    SOFDao findByStudentId(Long id);

    SOFDao save(SOFDao sofDao);
}