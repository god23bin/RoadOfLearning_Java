package com.bin23.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtil {
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
}
