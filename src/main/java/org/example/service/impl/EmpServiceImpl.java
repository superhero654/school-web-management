package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.EmpExprMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.*;
import org.example.service.EmpLogService;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1.设置配置参数
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());

        //2.执行查询
        List<Emp> empList = empMapper.page(empQueryParam);

        //3.解析查询结果，并封装
        Page<Emp> empPage = (Page<Emp>) empList;
        return new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})//事务管理的注解-默认出现运行时异常时回滚
    @Override
    public void save(Emp emp) {
        try {
            //1.保存职工的基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            //2.仅保存职工的经历信息
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                //遍历集合，为empId赋值
                exprList.forEach(empExpr-> empExpr.setEmpId(empId));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增职工："+emp);
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除职工基本信息
        empMapper.deleteByIds(ids);

        //2.批量删除职工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        //1.根据id修改职工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //2.根据id修改职工工作经历信息
        //2.1先根据id删除原有的工作经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //2.2再添加这个职工新的工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //遍历集合，为empId赋值
            exprList.forEach(empExpr-> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }
}
