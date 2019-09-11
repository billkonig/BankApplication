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
 * Servlet implementation class TransferFundsServlet
 */
@WebServlet("/TransferFundsServlet")
public class TransferFundsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferFundsServlet() {
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

		Customer customer = (Customer) session.getAttribute("customer");

		String accountId1 = request.getParameter("accountId1");
		String accountId2 = request.getParameter("accountId2");
		String amount = request.getParameter("amount");
		
		Bank bank = null;
		try {
			bank = Bank.load();
		} catch (Exception e) {
			bank = new Bank();
			e.printStackTrace();
		}

		if (customer.getAccountById(accountId1) != null) {
			String balance = customer.getAccountById(accountId1).getBalance();
			String amount1 = request.getParameter("amount");
			double parsedBalance = Double.parseDouble(balance);
			double parsedAmount = Double.parseDouble(amount1);

			if (parsedAmount > 0) {
				double balance1 = parsedBalance - parsedAmount;
				String balance2 = Double.toString(balance1);
				customer.getAccountById(accountId1).setBalance(balance2);
				customer.getAccountById(accountId1).addTransaction("Transfer, -$" + amount + ", " + LocalDate.now().toString());
				bank.updateCustomer(customer);
				
				try {
					bank.save();
				} catch (Exception e) {
					System.out.println("Did not save");
				}	
				session.setAttribute("customer", customer);
			}
		}
		if (customer.getAccountById(accountId2) != null) {
			String balance = customer.getAccountById(accountId2).getBalance();
			String amount1 = request.getParameter("amount");
			double parsedBalance = Double.parseDouble(balance);
			double parsedAmount = Double.parseDouble(amount1);

			if (parsedAmount > 0) {
				double balance1 = parsedBalance + parsedAmount;
				String balance2 = Double.toString(balance1);
				customer.getAccountById(accountId2).setBalance(balance2);
				customer.getAccountById(accountId2).addTransaction("Transfer, +$" + amount + ", " + LocalDate.now().toString());
				bank.updateCustomer(customer);
				
				try {
					bank.save();
				} catch (Exception e) {
					System.out.println("Did not save");
				}	
				session.setAttribute("customer", customer);
			}
			RequestDispatcher rs = request.getRequestDispatcher("accounts.jsp");
			rs.forward(request, response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("transferFunds.jsp");
			rs.forward(request, response);
		}
	}
}
