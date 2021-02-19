package com.bin23.crud.controller;

import com.bin23.crud.bean.Employee;
import com.bin23.crud.service.impl.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {

    @Autowired
    @Qualifier(value = "employeeService")
    EmployeeService employeeService;



    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //引入pageHelper分页插件
        //查询之前进行调用，传入当前页面以及每页显示的数据条数
        PageHelper.startPage(pn,10);
        //这个普通查询就变成分页查询了
        List<Employee> employeeList = employeeService.getAll();
        //用PageInfo包装分页查询后的结果
        //PageInfo封装了详细的分页信息，包括查询出来的数据
        //navigatePages代表连虚显示的页数，比如当前在第4页，就2，3，4，5，6
        PageInfo pageInfo = new PageInfo(employeeList,5);

        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
