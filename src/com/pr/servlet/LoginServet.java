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

import com.pr.DAO.SignupDao;
import com.pr.pojo.signup;
import com.pr.utility.UtilityJson;

/**
 * Servlet implementation class LoginServet
 */
@WebServlet("/LoginServet")
public class LoginServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

String jsonobject = request.getReader().readLine();
		
		System.out.println(jsonobject);
		

		signup sb = (signup) UtilityJson.getObjectFromJSON(jsonobject, signup.class);
		

		Map<String, String> mp = null;
		try {
			mp = SignupDao.chklogin(sb);
			System.out.println(mp);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		
		response.getWriter().write(jsonString);
		
		response.flushBuffer();

	}

}


