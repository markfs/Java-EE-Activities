package com.example.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Author:          Mark
 * Time created:    3:18:21 PM
 */
public class DbUtil {
    private Connection connection = null;
    
    public Connection getConnection()
    {
        if(connection != null){
            return connection;
        }
        else
        {
            try{
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("./db.properties");
                prop.load(inputStream);
                
                /*String driver = "com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/db_user";*/
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("username");
                String pass = prop.getProperty("password");
                
                Class.forName(driver);
                
                //connection = DriverManager.getConnection(url, "root", "pwroot");
                connection = DriverManager.getConnection(url, user, pass);
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        }
    }
    
    public boolean disconnect(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
