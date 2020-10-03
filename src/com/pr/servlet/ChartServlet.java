package com.pr.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pr.DAO.TaskDao;
import com.pr.constants.DBCon;
import com.pr.constants.constantdb;
import com.pr.pojo.signup;
import com.pr.pojo.task;
import com.pr.utility.UtilityJson;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in chart view...");
		try {

			Connection con = DBCon.getConnection();
			Statement stmt = null;
			Statement stmt1 = null;
			Statement stmt2 = null;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(constantdb.STR_USER_NEWUSER);
			rs.next();
			System.out.println(rs.getInt("total"));

			stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(constantdb.STR_USER_ACTIVATE);
			rs1.next();
			System.out.println(rs1.getInt("total"));

			stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(constantdb.STR_TASK_TOTAL);
			rs2.next();
			System.out.println(rs2.getInt("total"));

			Map<String, Integer> chartdata = new HashMap<String, Integer>();
			chartdata.put("newUser", rs.getInt("total"));
			chartdata.put("activeUser", rs1.getInt("total"));
			chartdata.put("totalTask", rs2.getInt("total"));

			System.out.println(chartdata);

			String jsonstr = (String) UtilityJson.getJSONFromObject(chartdata);
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
