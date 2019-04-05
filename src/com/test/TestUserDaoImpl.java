package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import org.junit.Test;

public class TestUserDaoImpl {
        UserDao userDao=null;
    @Test
    public void testFindAll(){
        userDao=new UserDaoImpl();
        userDao.findAll();
    }

    @Test
    public void testLogin(){
        userDao=new UserDaoImpl();
        userDao.login("yeyeye","1029102110");
    }

    @Test
    public  void testInsert(){
        userDao=new UserDaoImpl();
        userDao.insert("ye","1234567");
    }

    @Test
    public void testDelete(){
        userDao=new UserDaoImpl();
        userDao.delete(7);
    }

    @Test
    public void testUpdate(){
        userDao=new UserDaoImpl();
        userDao.update("lisi","123456",2);
    }

}
