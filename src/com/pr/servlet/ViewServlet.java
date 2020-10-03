package com.pr.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pr.utility.UtilityJson;
import com.pr.DAO.TaskDao;
import com.pr.pojo.task;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in view...");
		try {
			ArrayList<task> list=TaskDao.getTaskListFromDb();
			
			System.out.println(list);
			
		    String jsonstr=(String) UtilityJson.getJSONFromObject(list);
		    System.out.println(jsonstr);
		    
		    response.getWriter().write(jsonstr);
            response.flushBuffer();		    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
   }
}
