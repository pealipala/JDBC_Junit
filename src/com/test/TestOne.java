package com.test;


import com.util.JDBCUtil;

import java.sql.*;

public class TestOne {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {

            conn= JDBCUtil.getConnection();
            //3:创建statement，跟数据库打交道必须要这个
            statement= conn.createStatement();
            //4:编写sql语句,并执行得到结果集
            String sql="SELECT * FROM   t_user";
            resultSet= statement.executeQuery(sql);
            //5:遍历查询结果
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String uname=resultSet.getString("uname");
                String pwd=resultSet.getString("pwd");
                System.out.println("id:"+id+"-----uname:"+uname+"-----pwd:"+pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,conn,statement);
        }
    }
}
