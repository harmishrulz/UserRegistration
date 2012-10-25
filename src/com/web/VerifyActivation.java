package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.DatabaseOperations;
import java.sql.ResultSet;
/**
 * Servlet implementation class VerifyActivation
 */
@WebServlet("/VerifyActivation")
public class VerifyActivation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		DatabaseOperations dop = new DatabaseOperations();
		//ResultSet rs = dop.executeQueryProcedure("{ call getSignupDetails(?) }", code);
		String selectquery = "select * from signup where activationlink = '" + code + "'";
		ResultSet rs = dop.executeQuery(selectquery);
		try {
			if(rs.next()) {
				request.setAttribute("signup", rs.getInt("signupid"));
				request.setAttribute("password", rs.getString("password"));
				request.setAttribute("firstname", rs.getString("firstname"));
				request.setAttribute("lastname", rs.getString("lastname"));
				request.setAttribute("email", rs.getString("email"));
				RequestDispatcher rd = request.getRequestDispatcher("PersonalDetails.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Activation process failed. Please try again.");
		}
		
	}

}
