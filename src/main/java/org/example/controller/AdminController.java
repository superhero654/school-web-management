package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Admin;
import org.example.pojo.Result;

import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PutMapping("/admin/updataPassword")
    public Result update(@RequestBody Admin admin){
        log.info("修改管理员密码：{}",admin);
        adminService.update(admin);
        return Result.success();
    }
}
