package com.bin23.crud.mapper;

import com.bin23.crud.bean.Department;

public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department dept);

    int updateByPrimaryKey(Department dept);

    Department selectByPrimaryKey(Integer deptId);

    Department selectAll();
}
