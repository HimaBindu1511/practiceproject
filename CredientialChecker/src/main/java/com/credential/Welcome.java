package com.credential;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Welcome() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		//Sending Information through request object
			//	String uname=request.getParameter("txtuname");
		//	out.println("Welcome User"+uname);
			
			HttpSession session=request.getSession();
			out.println("Welcome user::"+(String)session.getAttribute("username"));
			out.println("<a href='Logout'>Logout</a>");
			
//			RequestDispatcher dispatch;
//			dispatch=request.getRequestDispatcher("Logout");
//			dispatch.forward(request,response);
		}
	}


