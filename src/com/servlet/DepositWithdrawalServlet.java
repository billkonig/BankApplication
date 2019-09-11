package com.servlet;

import java.io.IOException;
import java.time.LocalDate;

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
 * Servlet implementation class DepositWithdrawalServlet
 */
@WebServlet("/DepositWithdrawalServlet")
public class DepositWithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepositWithdrawalServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		Bank bank = null;
		try {
			bank = Bank.load();
		} catch (Exception e) {
			bank = new Bank();
			e.printStackTrace();
		}
		//Getting data that has been already been populated in the session by the user, which is available for the life of the session.
		//These can return any objects.
		Customer customer = (Customer) session.getAttribute("customer");

		//Getting data that will be input by the user, which is only available for the life of the request.  These can only return Strings.
		String accountId = request.getParameter("accountId");

		if (customer.getAccountById(accountId) != null)
		{
			String balance = customer.getAccountById(accountId).getBalance();
			String deposit1 = request.getParameter("deposit");
			double parsedBalance = Double.parseDouble(balance);
			double parsedDeposit = Double.parseDouble(deposit1);
			String withdrawal1 = request.getParameter("withdrawal");
			double parsedWithdrawal = Double.parseDouble(withdrawal1);
			
			if (parsedDeposit > 0 && parsedWithdrawal == 0) {
							
				double balance1 = parsedBalance + parsedDeposit;
				String balance2 = Double.toString(balance1);
				customer.getAccountById(accountId).setBalance(balance2);
				
				customer.getAccountById(accountId).addTransaction("Deposit, $" + deposit1 + ", " + LocalDate.now().toString());
				bank.updateCustomer(customer);
				
				try {
					bank.save();
				} catch (Exception e) {
					System.out.println("Did not save");
				}	
				session.setAttribute("customer", customer);
				RequestDispatcher rs = request.getRequestDispatcher("accounts.jsp");
				rs.forward(request, response);
			} 
			else if (parsedDeposit == 0 && parsedWithdrawal > 0) {
				
				double balance1 = parsedBalance - parsedWithdrawal;
				String balance2 = Double.toString(balance1);
				customer.getAccountById(accountId).setBalance(balance2);
						
				customer.getAccountById(accountId).addTransaction("Withdrawal, $" + withdrawal1 + ", " + LocalDate.now().toString());
				
				bank.updateCustomer(customer);
				
				try {
					bank.save();
				} catch (Exception e) {
					System.out.println("Did not save");
				}	
				session.setAttribute("customer", customer);	
				RequestDispatcher rs = request.getRequestDispatcher("accounts.jsp");
				rs.forward(request, response);
			} 
		} 
		else {
			RequestDispatcher rs = request.getRequestDispatcher("depositWithdrawal.jsp");
			rs.forward(request, response);
		}
	}
}
