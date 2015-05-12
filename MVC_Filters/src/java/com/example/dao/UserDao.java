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
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tbl_users");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserID(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        
        return users;
    }
    
    public static List<UserBean> getAllOtherUsers(String username)
    {
        List<UserBean> users = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tbl_users WHERE username!=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserID(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        
        return users;
    }
    
    
    
    public static UserBean getUserByID(int userID)
    {
        UserBean user = new UserBean();
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tbl_users WHERE user_id=? LIMIT 1");
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                user.setUserID(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        
        return user;
    }
    
    public static int updateUser(int userID, String username, String password)
    {   
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE tbl_users SET "
                    + "username=? ,"
                    + "password=? "
                    + "WHERE user_id=? LIMIT 1");
            
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setInt(3, userID);
                stmt.executeUpdate();
                
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("Query wrong.");
            e.printStackTrace();
        }
        
        return 1;
    }
    
    public static int addUser(String username, String password)
    {
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO tbl_users (username, password) "
                    + "VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("Query wrong.");
            e.printStackTrace();
        }
        
        return 1;
    }
    
    public static void deleteUserByID(int userID)
    {
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tbl_users WHERE user_id=? LIMIT 1");
            stmt.setInt(1, userID);
            stmt.executeUpdate();
            
            stmt.close();
            db.disconnect();

        } catch (SQLException e) {
            System.out.println("Wrong query.");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        List<UserBean> users = new ArrayList();
        users = getAllOtherUsers("mark");
        
        for(UserBean user : users)
        {
            System.out.println(""+user.getUsername());
        }
    }
}

