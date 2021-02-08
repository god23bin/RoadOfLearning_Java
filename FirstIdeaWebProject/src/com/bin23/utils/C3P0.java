package com.bin23.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0 {
    public static DataSource getDataSourceWithC3P0() throws Exception {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        c3p0.setDriverClass("com.mysql.jdbc.Driver");
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/blog");
        c3p0.setUser("root");
        c3p0.setPassword("123");
        return c3p0;
    }

    public static DataSource getDataSourceWithC3P0ByXml() throws Exception {
        //参数就是配置的xml里<named-config name="bin23">的name属性的值
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("bin23");
        return c3p0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getDataSourceWithC3P0().getConnection());
        System.out.println(getDataSourceWithC3P0ByXml().getConnection());
    }
}
