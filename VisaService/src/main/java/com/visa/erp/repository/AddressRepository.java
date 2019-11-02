package com.visa.erp.repository;

import com.visa.erp.DAO.AddressDao;
import com.visa.erp.DAO.StudentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends CrudRepository<AddressDao, Integer> {

    AddressDao findByStudentId(Long id);

    AddressDao save(AddressDao addressDao);
}