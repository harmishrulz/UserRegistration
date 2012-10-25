package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.DatabaseOperations;
/**
 * Servlet implementation class SaveUserInterests
 */
@WebServlet("/SaveUserInterests")
public class SaveUserInterests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserInterests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reached");
		String interestids [] = request.getParameterValues("interests");
		int i = 0;
		DatabaseOperations dop = new DatabaseOperations();
		while(i < interestids.length) {
			dop.executeQuery("insert into userinterest values (" + Integer.parseInt(request.getParameter("userid")) + "," + Integer.parseInt(interestids[i]) + ")");
		}
		PrintWriter out = response.getWriter();
		out.println("Insertion Successfull");
	}

}
