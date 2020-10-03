package com.pr.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.pr.constants.DBCon;
import com.pr.constants.constantdb;
import com.pr.pojo.signup;


public class SignupDao {
	
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> createuser(signup sg) throws JSONException, ClassNotFoundException, SQLException {

		Map<String, String> mp = new HashMap<>();

		int result;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_INSERT);
        
		String firstname = sg.getFirstname();
		String lastname = sg.getLastname();
		String gender = sg.getGender();
		String email = sg.getEmail();
		String dob = sg.getDob();
		String password = sg.getPassword();

		String status="Activate";
		
		Date temp = sg.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(temp);

		Object[] parameter = {firstname, lastname, gender,email, dob, password,status,date};

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

	
	public static Map<String, String> chklogin(signup sb) throws SQLException, ClassNotFoundException {

		Map<String, String> mapobject = new HashMap<String, String>();


		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_GETALL);

		ResultSet rs = ps.executeQuery();
	
		while (rs.next()) 
		{
			if (rs.getString(5).equals(sb.getEmail()) && rs.getString(7).equals(sb.getPassword()) && rs.getString(8).equals("Activate")) 
			{
				mapobject.put("result", "successfully");
				break;
			}
			else if ("admin@gmail.com".equals(sb.getEmail()) && "admin123".equals(sb.getPassword()))
			{
				mapobject.put("result", "admin");
				break;
			} 
			else 
			{
				mapobject.put("result", "Error");
			}
		}
		
		 try {rs.close(); } catch (Exception e) { /* ignored */ }
			try { ps.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		    
		return mapobject;

	}
	
	public static ArrayList<signup> getLoginData() throws SQLException, ClassNotFoundException {
		
		ArrayList<signup> list = new ArrayList<>();
		
		Connection con = DBCon.getConnection();
		
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_USER_GETALL);
		

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			signup u = new signup();
			u.setSid(resultSet.getInt(1));
			u.setFirstname(resultSet.getString(2));
			u.setLastname(resultSet.getString(3));	
			u.setStatus(resultSet.getString(8));
	
			list.add(u);
		}
		
	    try {resultSet.close(); } catch (Exception e) { /* ignored */ }
		try { ps1.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
	    
		return list;
		
	}
	
	public static Map<String, String> updateLoginStatus(int id) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int result = 0;
		try {
			Connection con = DBCon.getConnection();
			
			PreparedStatement ps1 = con.prepareStatement("select status from signup where sid="+id);
			ResultSet rs=ps1.executeQuery();
			rs.next();
			System.out.println(rs.getString("status"));
			
			PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_updateStatus);
			ps.setInt(2,id); 
			if(rs.getString("status").equals("Activate"))
			{
				ps.setString(1, "Deactivate");
				System.out.println("i m in deactive");
			}
			else
			{
				ps.setString(1, "Activate");
				System.out.println("i m in Active");
			}	

			result = ps.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement("select * from signup where sid="+id);
			
			ResultSet rs1=ps2.executeQuery();
			
			rs1.next();
			
			System.out.println(rs1.getString("status"));
			
			if (result == 1) {

			 mapobject.put("result", "updated successfully");
			 return mapobject;
			} else {

				mapobject.put("result", "Error");
				return mapobject; 
			}
			

//			try { ps.close(); } catch (Exception e) { /* ignored */ }
//		    try { con.close(); } catch (Exception e) { /* ignored */ }
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapobject; 

		
	}
}
