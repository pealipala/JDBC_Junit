package com.dao;
    /**
     * 定义操作数据库的方法
     */
public interface UserDao {
     /**
     * 查询所有
     */
    void findAll();
    void login(String uname,String pwd);
    void insert(String uname,String pwd);
    void delete(int id);
    void update(String uname,String pwd,int id);
}
