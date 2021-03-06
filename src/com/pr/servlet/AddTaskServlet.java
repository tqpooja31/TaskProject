package com.pr.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.pr.DAO.TaskDao;
import com.pr.pojo.task;
import com.pr.utility.UtilityJson;

/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
	String jsonobject = request.getReader().readLine();
	System.out.println(jsonobject);

	
	task tk = (task) UtilityJson.getObjectFromJSON(jsonobject, task.class);
	System.out.println(tk);

	try {
		Map<String, String> mp=TaskDao.createtask(tk);
		System.out.println(mp);
		
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();
	} catch (JSONException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		 
		e.printStackTrace();
	} catch (SQLException e) {
		 
		e.printStackTrace();
	}
}


}
