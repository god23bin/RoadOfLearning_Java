package com.bin23.crud.test;

import com.bin23.crud.bean.Department;
import com.bin23.crud.bean.Employee;
import com.bin23.crud.mapper.DepartmentMapper;
import com.bin23.crud.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 功能测试类
 * Spring项目可以使用Spring的单元测试，可以初始化IOC容器，自动注入我们需要的bean
 * 1.添加SpringTest依赖
 * 2.使用@ContextConfiguration指定Spring配置文件位置
 * 3.直接@AutoWired
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class FunctionTest {

    @Autowired
    private static DepartmentMapper departmentMapper;

    public static void setDepartmentMapper(DepartmentMapper departmentMapper) {
        FunctionTest.departmentMapper = departmentMapper;
    }

    @Test
    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
    }

    @Test
    public void testOriginWay(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper deMapper = (DepartmentMapper)context.getBean("departmentMapper");
//        EmployeeMapper emMapper = (EmployeeMapper)context.getBean("employeeMapper");
//        System.out.println(deMapper);
//        System.out.println(emMapper);
        //插入部门
//        Department department1 = new Department(1,"开发部");
//        Department department2 = new Department(2,"测试部");
//        deMapper.insert(department1);
//        deMapper.insert(department2);
//        System.out.println("部门录入完成！");

        //插入员工
//        Employee e1 = new Employee(null,"勒布朗","M","KingJeams@twitter.com",1);
//        Employee e2 = new Employee(null,"德怀恩","M","DWade@twitter.com",1);
//        Employee e3 = new Employee(null,"克里斯","M","CP3@twitter.com",2);
//        Employee e4 = new Employee(null,"卡梅隆","M","Anthony15@twitter.com",2);
//        emMapper.insert(e1);
//        emMapper.insert(e2);
//        emMapper.insert(e3);
//        emMapper.insert(e4);
//        System.out.println("员工录入完成！");

        //进行批量插入
//        sqlSessionTemplate
        SqlSession sqlSession = (SqlSession)context.getBean("sqlSessionTemplate");
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0; i < 1000; i++){
            String uuidName = UUID.randomUUID().toString().substring(0, 5) + i;
            Employee e = new Employee(null,uuidName,"M",uuidName+"@twitter.com",1);
            mapper.insert(e);
        }
        System.out.println("批量插入1000条数据完成！");
    }

}
