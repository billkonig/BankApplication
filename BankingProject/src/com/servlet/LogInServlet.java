package com.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Bank;
import com.user.Customer;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Bank bank = null;
		
		try {
			bank = Bank.load();			
		} catch (Exception e) {
			bank = new Bank();
		}
		Customer customer = bank.getCustomer(email, password);
		String redirect = "";
		if (customer != null) {
			session.setAttribute("customer", customer);
			redirect = "home.jsp";
		}else {
			redirect = "logIn.jsp";
		}
		RequestDispatcher rs= request.getRequestDispatcher(redirect);
		rs.forward(request, response);		
	}
}
