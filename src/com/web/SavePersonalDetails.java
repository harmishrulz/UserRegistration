package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DatabaseOperations;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@WebServlet("/SavePersonalDetails")
public class SavePersonalDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SavePersonalDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private boolean verifyCaptcha(HttpServletRequest request) {
    	String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LdpJNgSAAAAACVXRbfQR1kb-LMx0tiuZbu337jG");
		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
		return reCaptchaResponse.isValid();
	}
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Saved Personal Details");
    	if(verifyCaptcha(request)) {
    		
    		String username = request.getParameter("txtUserName");
    		String password = request.getParameter("password");
    		String email = request.getParameter("txtEmail");
    		String firstname = request.getParameter("txtFirstName");
    		String lastname = request.getParameter("txtLastName");
    		String dob = request.getParameter("txtDob");
    		String city = request.getParameter("City");
    		String state = request.getParameter("State");
    		String country = request.getParameter("Country");
    		int signupid = Integer.parseInt(request.getParameter("signupid"));
    		
    		DatabaseOperations dop = new DatabaseOperations();
    		System.out.println("DB Object created.");
    		try {
    			boolean done = false;
    			done = dop.registerUser(signupid, username, password, email, firstname, lastname, dob, state, city, country);
    			System.out.println("Done = " + done);
				if(done) {
					int userid = dop.getUserID(email);
					response.sendRedirect("interests.jsp?userid=" + userid);
					
				}
				else {
					System.out.println("Error in if. I am in catch right now.");
				}
			} catch (SQLException e) {
				// ODO Auto-generated catch block
				PrintWriter out = response.getWriter();
				out.println("Error in creating user account.");
				
			}
    		
    		
    	}
    	else {
    		PrintWriter out = response.getWriter();
			out.println("Incorrect Captcha.");
    	}
	}

}
