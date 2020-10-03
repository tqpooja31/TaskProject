package com.pr.constants;

public class constantdb {
	
	public static String STR_USER_INSERT = "insert into signup(firstname, lastname, gender, email, DOB, password,status,date) values(?,?,?,?,?,?,?,?);";
	public static String STR_USER_GETALL = "select * from signup";
	
	
	public static String STR_TASK_INSERT = "insert into task(tname,task_desc,status,email,Tdate) values(?,?,?,?,?)";
	public static String STR_TASK_GETALL = "select * from task";
	public static String STR_TASK_DELETE = "delete from task where tid=?";
	public static String STR_TASK_UPDATE = "update task set tname=?,task_desc=?,status=? where tid=?";
	public static String STR_TASK_updateStatus="update task set status='Completed' where tid=?";
	
	public static String STR_USER_updateStatus="update signup set status=? where sid=?";
	
	public static String STR_USER_NEWUSER ="select count(sid) as total from signup where date > now() - interval 7 day;";
	public static  String STR_USER_ACTIVATE ="select count(sid) as total from signup where date > now() - interval 7 day AND status='Activate';";
	
	public static String STR_TASK_TOTAL ="select  count(tid) as total from task where Tdate > now() - interval 7 day; ";

}
