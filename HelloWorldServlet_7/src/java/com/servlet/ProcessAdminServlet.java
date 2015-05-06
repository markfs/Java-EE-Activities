/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Author:          Mark
 * Time created:    2:31:33 PM
 */
public class ProcessAdminServlet extends HttpServlet {
    
    public void init() throws ServletException{
        
    }
    
    /* Handles Http GET Requests */
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String[] languages = request.getParameterValues("languages");
        String fighter = request.getParameter("boxer");
        
        PrintWriter out = response.getWriter();
        out.println("Type: Admin<br/>");
        out.println("<h1> Hello Admin "+ name +"!</h1>");
        out.println("<h3> You are from '"+ course +"' right?</h3>");
        out.println("You need to pass this subjects: <br/>");
        for(String lang : languages)
            out.print(lang+"<br/>");
        
        if("pacman".equals(fighter))
            out.println("<hr/>People's Champ!");
        else if(fighter.equals("mayweather"))
            out.println("<hr/>Did you mean Gayweather?");
    }
    
    public void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        doGet(request, response);
    }
    
    public void processRequest()
    {
    
    }
    
    
    public void destroy(){
        
    }
}
