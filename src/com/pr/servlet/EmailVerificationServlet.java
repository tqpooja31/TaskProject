package com.pr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pr.pojo.SendingEmail;
import com.pr.utility.UtilityJson;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class EmailVerificationServlet
 */
@WebServlet("/EmailVerificationServlet")
public class EmailVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsonobject = req.getReader().readLine();

		System.out.println(jsonobject);

		int min = 50;
		int max = 100;

		
		System.out.println("Random value in int from " + min + " to " + max + ":");
		int random_int = (int) (Math.random() * (max - min + 1) + min);
		System.out.println(random_int);
		
		Map<String, Integer> mapres=new HashMap<String, Integer>();

		if(SendingEmail.MailSent(jsonobject,random_int))
		{
			mapres.put("msg",random_int);
		}
		else
		{
			mapres.put("msg",-1);
		}
		
		String jsonString = (String) UtilityJson.getJSONFromObject(mapres);

		resp.getWriter().write(jsonString);

		System.out.println(jsonString);

		resp.flushBuffer();

	}

}
