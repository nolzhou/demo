package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainService {

    @Resource
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }

    public UserEntity findByName(String name)
    {
        return userRepository.findByName(name);
//        return null;
    }

    public boolean add(String name)
    {
        UserEntity user = new UserEntity();
        user.setName(name);
        userRepository.save(user);
        return true;
    }

    public boolean modify(Integer id,String name)
    {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public int countByName(String name){
        return userRepository.countByName(name);
    }

    public void updateByName(String telephone, String name){
        userRepository.updateByName(telephone, name);
    }

    public String findTelephoneByName(String name){
        return userRepository.findTelephoneByName(name);
    }
}
