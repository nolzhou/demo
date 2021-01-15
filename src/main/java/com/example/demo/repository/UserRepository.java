package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from user where name = ?1",nativeQuery = true)
    UserEntity findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "delete from user where id = ?1",nativeQuery = true)
    void deleteById(int userId);

    @Query(value = "select count(id) from user where name = ?1", nativeQuery = true)
    int countByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update user set telephone = ?1 where name = ?2", nativeQuery = true)
    void updateByName(String telephone,String name);

    @Query(value = "select telephone from user where name = ?1", nativeQuery = true)
    String findTelephoneByName(String name);

    UserEntity save(UserEntity userEntity);
}
