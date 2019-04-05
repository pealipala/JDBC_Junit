package com.dao.impl;


import com.dao.UserDao;
import com.util.JDBCUtil;

import java.sql.*;

public class UserDaoImpl   implements UserDao{


    PreparedStatement ps=null;
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    @Override
    public void findAll() {



        try {
            conn = JDBCUtil.getConnection();

            st=conn.createStatement();

            String sql="SELECT * FROM t_user";

            rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String uname=rs.getString("uname");
                String pwd=rs.getString("pwd");
                System.out.println("id:"+id+"----uname:"+uname+"----pwd:"+pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs,conn,st);
        }

    }

    @Override
    public void login(String uname, String pwd) {


        try {
            //1. 获取连接对象
            conn = JDBCUtil.getConnection();
            //2. 创建statement对象
            String sql="SELECT  * FROM  t_user WHERE uname=? AND  pwd=?";
            // 预先对sql语句执行语法的校验，?对应的内容，后面不管传递什么内容进来都把它看成字符串
            ps = conn.prepareStatement(sql);
            //?问号对应的索引从1开始
            ps.setString(1,uname);
            ps.setString(2,pwd);

            rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,conn,ps);
        }

    }

    @Override
    public void insert(String uname, String pwd) {
        try {
            conn=JDBCUtil.getConnection();
            String sql="INSERT into t_user VALUES (NULL ,?,?)";
            ps= conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);
            int result=ps.executeUpdate();
            if (result>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps);
        }
    }

    @Override
    public void delete(int id) {
        try {
            conn=JDBCUtil.getConnection();
            String sql="DELETE FROM t_user WHERE id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps);
        }

    }

    @Override
    public void update(String uname, String pwd,int id) {

        try {
            conn=JDBCUtil.getConnection();
            String sql="UPDATE t_user SET uname=? , pwd=? WHERE id=? ";
            ps= conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);
            ps.setInt(3,id);
            int result=ps.executeUpdate();
            if (result>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps);
        }

    }
}
