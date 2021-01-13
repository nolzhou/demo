package com.example.demo.controller;

import com.example.demo.domain.AdminEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.service.AdminService;
import com.example.demo.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.GroupSequence;
import java.util.List;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 12:38:05
 */
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private MainService mainService;

    @GetMapping(path="/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @PostMapping(path="/adminLogin")
    public String processAdminLogin(@RequestParam(value = "adminName")String adminName,
                                    @RequestParam(value = "password")String password){
        if(adminService.countByName(adminName)!=1){
            return "redirect:/adminLogin";
        }
        AdminEntity adminEntity=adminService.findByName(adminName);
        if(!adminEntity.getPassword().equals(password)){
            return "redirect:/adminLogin";
        }else{
            return "redirect:/home";
        }
    }

    @GetMapping(path = "/home")
    public String showHome(){
        return "home";
    }

    @GetMapping(path = "/userList")
    public String showUserList(Model model){
        List<UserEntity> userList=mainService.getAllUsers();
        model.addAttribute("userList",userList);
        return "userList";
    }

    @GetMapping(path = "/delete/{userId}")
    public String deleteUser(@PathVariable("userId")int userId){
        mainService.deleteById(userId);
        return "redirect:/userList";
    }

    @GetMapping(path = "/addNewUser")
    public String showAddNewUserForm(){
        return "addNewUser";
    }

    @PostMapping(path = "/addNewUser")
    public String processAddNewUser(@RequestParam(value = "name")String name,
                                    @RequestParam(value = "password")String password,
                                    @RequestParam(value = "telephone", defaultValue = "")String telephone){
        if(mainService.countByName(name)!=0){
            return "redirect:/addNewUser";
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        if(telephone.isEmpty()||telephone==null){
            mainService.save(userEntity);
            return "redirect:/userList";
        }else{
            userEntity.setTelephone(telephone);
            mainService.save(userEntity);
            return "redirect:/userList";
        }
    }
}
