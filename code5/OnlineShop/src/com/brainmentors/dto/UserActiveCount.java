package com.brainmentors.dto;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserActiveCount
 *
 */
@WebListener
public class UserActiveCount implements HttpSessionListener {
	private static int userCount = 0;
	public static int getUserCount(){
		return userCount;
	}
    /**
     * Default constructor. 
     */
    public UserActiveCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session Created "+userCount);
    		userCount++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	userCount--;
    }
	
}
