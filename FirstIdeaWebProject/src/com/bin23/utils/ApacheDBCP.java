package com.bin23.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class ApacheDBCP {
    public static DataSource getDataSourceWithDBCP(){
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setDriverClassName("com.mysql.jdbc.Driver");
        dbcp.setUrl("jdbc:mysql://localhost:3306/blog");
        dbcp.setUsername("root");
        dbcp.setPassword("123");
        dbcp.setInitialSize(10);
        return dbcp;
    }

    public static DataSource getDataSourceByProperties() throws Exception {
        BasicDataSource dbcp = null;
        InputStream in = new ApacheDBCP().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        Properties properties = new Properties();
        properties.load(in);
        dbcp = BasicDataSourceFactory.createDataSource(properties);
        return dbcp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getDataSourceWithDBCP().getConnection());
        System.out.println(getDataSourceByProperties().getConnection());
    }
}
