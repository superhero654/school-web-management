package org.example.service;

import org.example.pojo.Admin;
import org.example.pojo.LoginInfo;

public interface AdminService {
    //登录
    LoginInfo login(Admin admin);
}
