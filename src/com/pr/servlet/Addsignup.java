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

@WebServlet("/Addsignup")
public class Addsignup extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		signup sg = (signup) UtilityJson.getObjectFromJSON(jsonobject, signup.class);
		System.out.println(sg);

		try {
			Map<String, String> mp = SignupDao.createuser(sg);
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
