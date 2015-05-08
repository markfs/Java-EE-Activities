/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.dao;

import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;

/**
 *
 * Author:          Mark
 * Time created:    3:28:14 PM
 */
public class UserDao extends HttpServlet{
    /* add other user function here*/
    
    public static boolean isValid(UserBean user)
    {
        //check if user is valid
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tbl_users WHERE username=? AND password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                result = true;
            }
            rs.close();
            
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static List<UserBean> getAllUsers()
    {
        List<UserBean> users = new ArrayList();
        
        return users;
    }
    
    /*public static void main(String[] args)
    {
        UserBean user = new UserBean();
        user.setUsername("mark");
        user.setPassword("saren");
        
        System.out.println(UserDao.isValid(user));
    }*/
}
