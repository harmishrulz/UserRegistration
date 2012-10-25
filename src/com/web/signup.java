package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Activation;
import com.model.Hash;
import com.model.DatabaseOperations;

/**
 * Servlet implementation class signup
 */

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DatabaseOperations dop = new DatabaseOperations();
		String plaintext = request.getParameter("txtFirstName") + request.getParameter("txtLastName") + request.getParameter("txtEmail");
		String hashedtext = Hash.toMd5(plaintext);
		//String mailmessage = "Dear" + request.getParameter("txtFirstName") + request.getParameter("txtLastName") + "\n\n<a href=\"http://localhost:8080/UserRegistration/VerifyActivation?code=" + hashedtext +"\">Click here to continue with registration process.</a>";
		String mailmessage = "Dear " + request.getParameter("txtFirstName") + " " + request.getParameter("txtLastName") + "\n\nPlease click on the following link to continue with the registration process.\n\nhttp://localhost:8080/UserRegistration/VerifyActivation?code=" + hashedtext;
		String insertquery = "insert into signup (firstname, lastname, email, password, activationlink) values ('" + request.getParameter("txtFirstName") + "','" + request.getParameter("txtLastName") + "','" + request.getParameter("txtEmail") + "','" + request.getParameter("txtPassword") + "','" + hashedtext + "')";
		boolean sent = Activation.sendActivationMail(request.getParameter("txtEmail"), mailmessage);
		if(sent && dop.executeNonQuery(insertquery)!=0) {
			response.sendRedirect("signupack.jsp");
		}
		else {
			
		}
	}
}
