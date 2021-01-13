package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from user where name = ?1",nativeQuery = true)
    UserEntity findByName(String name);

//    @Modifying
    @Query(value = "delete from user where name = ?1",nativeQuery = true)
    int deleteByName(String name);

    @Query(value = "select count(id) from user where name = ?1", nativeQuery = true)
    int countByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update user set telephone = ?1 where name = ?2", nativeQuery = true)
    void updateByName(String telephone,String name);

    @Query(value = "select telephone from user where name = ?1", nativeQuery = true)
    String findTelephoneByName(String name);
}
