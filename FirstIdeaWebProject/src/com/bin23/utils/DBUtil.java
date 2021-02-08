package com.bin23.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    private  final static String  DRIVER="com.mysql.jdbc.Driver";
    private  final static String  URL="jdbc:mysql://localhost:3306/blog";
    private  final static String  USERNAME="root";
    private  final static String  PASSWORD="123";
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;


    public static Connection getCon() {
        return con;
    }
    public static PreparedStatement getPstmt() {
        return pstmt;
    }
    //select *from student where id = ?
    public static ResultSet executeQuery(String sql,Object[] params) throws SQLException, ClassNotFoundException{
        pstmt = getPreparedStatement(sql, params);
        rs = pstmt.executeQuery();
        return rs;
    }

    public static PreparedStatement getPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        //将访问数据库的连接 指向“数据源”
        try {
            Context ctx = new InitialContext() ;//context.xml
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB") ;
            con = ds.getConnection();
            System.out.println("ok...");

        } catch (NamingException e) {
            e.printStackTrace();
        }

//    	con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        pstmt =  con.prepareStatement(sql);
        if(params !=null){
            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1, params[i]);
            }
        }
        return pstmt;
    }
    public static boolean executeUpdate(String sql,Object[] params) throws SQLException, ClassNotFoundException{
        boolean flag = false;
        pstmt =  getPreparedStatement(sql, params);
        int result  = pstmt.executeUpdate();
        if(result>0){
            flag = true;
        }
        closeAll(null, pstmt, con);
        return flag;
    }
    public static void closeAll(ResultSet rs, Statement stmt, Connection con) throws SQLException{
        if(rs!=null) rs.close();
        if(stmt!=null) stmt.close();
        if(con !=null) con.close();
    }
}
