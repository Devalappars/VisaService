package com.visa.erp.repository;

import com.visa.erp.DAO.ParentDetailsDao;
import com.visa.erp.DAO.StudentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentsRepository extends CrudRepository<ParentDetailsDao, Integer> {

    ParentDetailsDao findById(Long id);

    ParentDetailsDao findByStudentId(Long id);

    ParentDetailsDao save(ParentDetailsDao s);
}