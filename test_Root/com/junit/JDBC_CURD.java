package com.junit;

import com.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_CURD {
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;

    @Test
    public void testQuery(){

        try {
            conn= JDBCUtil.getConnection();

            st = conn.createStatement();

            String sql="select * from t_user";

            rs = st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String uname=rs.getString("uname");
                String pwd=rs.getString("pwd");
                System.out.println("id:"+id+"----uname:"+uname+"----pwd:"+pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs,conn,st);
        }
    }

    @Test
    public void testInsert(){

        try {
            conn= JDBCUtil.getConnection();

            st = conn.createStatement();

            String sql="INSERT INTO t_user VALUES (NULL,'yechaoze',1234 )";
            int result = st.executeUpdate(sql);
            if (result>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,st);
        }
    }

    @Test
    public void testDelete(){

        try {
            conn=JDBCUtil.getConnection();

            st = conn.createStatement();

            String sql="DELETE FROM t_user WHERE id=3";

            int result=st.executeUpdate(sql);

            if (result>0){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,st);
        }
    }

    @Test
    public void testUpdate(){

        try {
            conn=JDBCUtil.getConnection();

            st=conn.createStatement();

            String sql="UPDATE t_user SET pwd=123456 WHERE id=2";

            int result=st.executeUpdate(sql);
            if (result>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,st);
        }

    }
}
