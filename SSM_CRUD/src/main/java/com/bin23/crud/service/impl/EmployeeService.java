package com.bin23.crud.service.impl;

import com.bin23.crud.bean.Employee;
import com.bin23.crud.mapper.EmployeeMapper;
import com.bin23.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeMapper.selectAll();
        return employeeList;
    }
}
