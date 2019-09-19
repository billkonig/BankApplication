package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Account;
import com.user.Customer;

/**
 * Servlet implementation class ViewBalanceServlet
 */
@WebServlet("/ViewBalanceServlet")
public class ViewBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalanceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());()
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("customer");
		
		String accountId = request.getParameter("accountId");
		
		Account account = customer.getAccountById(accountId);
		
		String balance = "";
		
		if (account != null) {
			
			balance = account.getBalance();
			request.setAttribute("account", account);
			
			RequestDispatcher rs = request.getRequestDispatcher("viewBalance2.jsp");
			rs.forward(request,response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("viewBalance1.jsp");
			rs.forward(request,response);
		}	
	}

}
