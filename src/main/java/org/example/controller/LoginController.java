package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.*;
import org.example.service.AdminService;
import org.example.service.EmpService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//登录请求
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/student/login")
    public Result login(@RequestBody Student student) {
        log.info("登录请求：{}",student);
        LoginInfo loginInfo = studentService.login(student);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }


    @Autowired
    private AdminService adminService;
    @PostMapping("/admin/login")
    public Result login(@RequestBody Admin admin) {
        log.info("登录请求：{}",admin);
        LoginInfo loginInfo = adminService.login(admin);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }
}
