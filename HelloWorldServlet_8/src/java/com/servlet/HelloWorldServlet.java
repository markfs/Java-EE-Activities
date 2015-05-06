/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Mark
 */
public class HelloWorldServlet extends HttpServlet {
    public void init() throws ServletException{
        
    }
    
    /* Handles Http GET Requests */
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        
        String type = request.getParameter("type");
        
        if(type.equals("user"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/user.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
        }
    }
    
    public void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        doGet(request, response);
    }
    
    public void destroy(){
        
    }
}


