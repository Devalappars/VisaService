package com.visa.erp.repository;

import com.visa.erp.DAO.StudentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentsRepository extends CrudRepository<StudentDao, Integer> {

    StudentDao findById(Long id);

    StudentDao save(StudentDao s);
}
