/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.model;

/**
 *
 * Author:          Mark
 * Time created:    3:30:07 PM
 */
public class UserBean {
    private String username = "mark";
    private String password = "saren";
    
    public boolean isUserValid(String username, String password)
    {
        if(username.equals(this.username) && password.equals(this.password))
            return true;
        else
            return false;
    }
}
