package com.bin23.crud.mapper;

import com.bin23.crud.bean.Employee;

import java.util.List;

public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee emp);

    int updateByPrimaryKey(Employee emp);

    Employee selectByPrimaryKey(Integer empId);

    List<Employee> selectAll();
}
