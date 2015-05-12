/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.jboss.weld.servlet.api.ServletListener;

/**
 *
 * Author:          Mark
 * Date created:    May 12, 2015
 * Time created:    3:05:50 PM
 */
public class AppEventsListener implements ServletContextListener, HttpSessionListener {
    ServletContext context;
    static public int num_sessions;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        num_sessions++;
        log("CREATE:", se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        num_sessions--;
        HttpSession session = hse.getSession();
        long start = session.getCreationTime();
        long end = session.getLastAccessedTime();
        String counter = (String)session.getAttribute("counter");
        log("DESTROY, Session Duration:"+(end-start)+" ms | Counter:"+counter, hse);
    }
    
    protected void log(String msg, HttpSessionEvent hse){
        String id = hse.getSession().getId();
        log("SessionID: "+id+" "+msg);
    }
    
    protected void log(String msg){
        System.out.println("["+getClass().getName()+"] "+msg);
    }

}
