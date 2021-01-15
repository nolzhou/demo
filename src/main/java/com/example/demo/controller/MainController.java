package com.example.demo.controller;

import com.example.demo.domain.UserEntity;
import com.example.demo.domain.dto.BindUserBody;
import com.example.demo.domain.dto.RegisterUserBody;
import com.example.demo.domain.dto.UserBody;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.MyResponseEntity;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

    @Resource
    private MainService mainService;

    @PostMapping(path = "/register")
    public MyResponseEntity register(@RequestBody UserBody body){
        System.out.println("成功接收注册请求");
        if(mainService.countByName(body.getName())!=0){
            System.out.println("注册失败");
            return new MyResponseEntity(-1,"register failed",null);
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setName(body.getName());
        userEntity.setPassword(body.getPassword());
        mainService.save(userEntity);
        System.out.println("注册成功");
        return new MyResponseEntity(1,"register successfully",null);
    }

    @PostMapping(path = "/login")
    public MyResponseEntity login(@RequestBody UserBody body){
        System.out.println("成功接收登录请求");
        if(mainService.countByName(body.getName())!=1){
            System.out.println("登录失败");
            return new MyResponseEntity(-1,"login failed",null);
        }
        UserEntity currentUser=mainService.findByName(body.getName());
        if(currentUser.getPassword().equals(body.getPassword())){
            System.out.println("登录成功");
            return new MyResponseEntity(1,"login successfully",null);
        }else {
            System.out.println("登录失败");
            return new MyResponseEntity(-1,"login failed",null);
        }
    }

    @PostMapping(path = "/bind")
    public MyResponseEntity bind(@RequestBody BindUserBody body){
        System.out.println("成功接收绑定手机号请求");
        mainService.updateByName(body.getTelephone(),body.getName());
        String telephone=mainService.findTelephoneByName(body.getName());
        if(telephone==null||telephone.isEmpty()){
            System.out.println("绑定失败");
            return new MyResponseEntity(-1,"bind failed",null);
        }else {
            System.out.println("绑定成功");
            return new MyResponseEntity(1,"bind successfully",null);
        }
    }
}
