package com.example.demo.repository;

import com.example.demo.domain.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 15:49:46
 */
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {

    @Query(value = "select count(id) from admin where adminname = ?1", nativeQuery = true)
    int countByName(String adminName);

    @Query(value = "select * from admin where adminname = ?1", nativeQuery = true)
    AdminEntity findByName(String adminName);
}
