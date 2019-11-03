package com.visa.erp.repository;

import com.visa.erp.DAO.IdDetailsDao;
import com.visa.erp.DAO.StudentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IdDetailsRepository extends CrudRepository<IdDetailsDao, Integer> {

    List<IdDetailsDao> findAllByStudentId(Long id);

    List<IdDetailsDao> findByStudentId(Long id);

    List<IdDetailsDao> save(List<IdDetailsDao> idDetailsDaos);
}