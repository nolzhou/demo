package com.example.demo.service;

import com.example.demo.domain.AdminEntity;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 15:48:58
 */
@Service
public class AdminService {
    @Resource
    private AdminRepository adminRepository;


    public int countByName(String adminName) {
        return adminRepository.countByName(adminName);
    }

    public AdminEntity findByName(String adminName) {
        return adminRepository.findByName(adminName);
    }
}
