package com.pr.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pr.DAO.TaskDao;
import com.pr.pojo.task;
import com.pr.utility.UtilityJson;

/**
 * Servlet implementation class updateStatusServlet
 */
@WebServlet("/updateStatusServlet")
public class updateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("update");
		int id = Integer.parseInt(request.getReader().readLine());
		System.out.println(id);



	 Map<String,String>mp=TaskDao.updateStatus(id);
		 
		   String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

	}
}
