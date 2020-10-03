package com.pr.servlet;

import java.io.IOException;
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
 * Servlet implementation class UpdateTaskServlet
 */
@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("update");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		task tk = (task) UtilityJson.getObjectFromJSON(jsonobject, task.class);
		System.out.println(tk);

		 Map<String,String>mp=TaskDao.updateTask(tk);
		 
		   String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

	}

}
