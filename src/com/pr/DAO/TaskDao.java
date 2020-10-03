package com.pr.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;


import com.pr.constants.DBCon;
import com.pr.constants.constantdb;
import com.pr.pojo.task;

public class TaskDao {
	
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> createtask(task tk) throws JSONException, ClassNotFoundException, SQLException {

		Map<String, String> mp = new HashMap<>();

		
		int result;
		Connection con = DBCon.getConnection();
		
		
		PreparedStatement ps = con.prepareStatement(constantdb.STR_TASK_INSERT);
        
		String tname = tk.getTname();
		String task_desc = tk.getDesc();
		String email=tk.getEmail();
		
		String status="New";
		
		Date temp = tk.getTdate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Tdate = sdf.format(temp);
		
		Object[] parameter = {tname,task_desc,status,email,Tdate};

		setValues(ps, parameter);

		result = ps.executeUpdate();
		
		if (result == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		
		    try { ps.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
	

		return mp;
	}

	public static ArrayList<task> getTaskListFromDb() throws SQLException, ClassNotFoundException {
		ArrayList<task> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_TASK_GETALL);
		System.out.println("in view dao"); 

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			task u = new task();
			u.setTid(resultSet.getInt(1));
			u.setTname(resultSet.getString(2));
			u.setDesc(resultSet.getString(3));
			u.setStatus(resultSet.getString(4));
			u.setEmail(resultSet.getString(5));
			
			list.add(u);
		}
		
	    try {resultSet.close(); } catch (Exception e) { /* ignored */ }
		try { ps1.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
	    
		return list;
		
	}
	
	public static Map<String, String> deleteTask(task tk) throws ClassNotFoundException, SQLException {

		System.out.println("in  delete method ");

		

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_TASK_DELETE);

		ps.setObject(1, tk.getTid());

		status = ps.executeUpdate();
		
		Map<String, String> mp = new HashMap<>();
		

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}
		

		try { ps.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }

		return mp;
	}

	public static Map<String, String> updateTask(task tk) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int result = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_TASK_UPDATE);

			ps.setInt(4,tk.getTid());
			ps.setString(1, tk.getTname());
			ps.setString(2, tk.getDesc());
			ps.setString(3, tk.getStatus());

			result = ps.executeUpdate();
			if (result == 1) {

				mapobject.put("result", "updated successfully");
			} else {

				mapobject.put("result", "Error");
			}
			

			try { ps.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;
	}
	
	public static Map<String, String> updateStatus(int id) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int result = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_TASK_updateStatus);

			ps.setInt(1,id);
			

			result = ps.executeUpdate();
			if (result == 1) {

				mapobject.put("result", "updated successfully");
			} else {

				mapobject.put("result", "Error");
			}
			

			try { ps.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;
	}
}
