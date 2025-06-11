package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.AdminMapper;
import org.example.pojo.Admin;
import org.example.pojo.LoginInfo;
import org.example.service.AdminService;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public LoginInfo login(Admin admin) {
        Admin a = adminMapper.selectByUsernameAndPassword(admin);

        if(a != null){
            log.info("管理员登录成功：{}",a);
            //生成JWT令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",a.getId());
            claims.put("username",a.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return new LoginInfo(a.getId(),a.getUsername(),a.getName(),jwt);
        }
        return null;
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }
}
