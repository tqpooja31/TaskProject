package com.pr.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pr.utility.UtilityJson;
import com.pr.DAO.TaskDao;
import com.pr.pojo.task;

/**
 * Servlet implementation class DeleteTaskServlet
 */
@WebServlet("/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in delete");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		task tk = (task) UtilityJson.getObjectFromJSON(jsonobject, task.class);
		

		Map<String, String> mp = null;
		try 
		{
			mp = TaskDao.deleteTask(tk);
		}
		catch (ClassNotFoundException e) 
		{
          e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);

		response.getWriter().write(jsonString);

		System.out.println(jsonString);

		response.flushBuffer();

	}
}
