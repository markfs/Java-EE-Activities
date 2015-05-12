/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mark
 */
@WebServlet(name = "UserControllerServlet", urlPatterns = {"/UserControllerServlet"})
public class UserControllerServlet extends HttpServlet {    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (action.equals("add")) {
            session.removeAttribute("user");
            RequestDispatcher view = request.getRequestDispatcher("user.jsp");
            view.forward(request, response);
        } else if (action.equals("edit")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            UserBean user = UserDao.getUserByID(userID);

            System.out.println(user.getUserID()+": "+user.getUsername() +": "+ user.getPassword());
            
            session.setAttribute("user", user);
            RequestDispatcher view = request.getRequestDispatcher("user.jsp");
            view.forward(request, response);
        } else if (action.equals("delete")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            UserDao.deleteUserByID(userID);
            
            session.setAttribute("users", UserDao.getAllOtherUsers(username));
            response.sendRedirect("home.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserBean user = (UserBean)session.getAttribute("user");
        
        if(user == null)
            UserDao.addUser(username, password);
        else
        {
            System.out.println("Updating user:");
            UserDao.updateUser(user.getUserID(), username, password);
        }
        
        session.setAttribute("users", UserDao.getAllOtherUsers((String)session.getAttribute("username")));
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}