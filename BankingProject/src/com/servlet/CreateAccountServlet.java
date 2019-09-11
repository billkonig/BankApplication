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

import com.user.Account;
import com.user.Bank;
import com.user.Customer;

/**
 * Servlet implementation class  CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		Bank bank = null;
		try {
			bank = Bank.load();
		} catch (Exception e) {
			bank = new Bank();
			e.printStackTrace();
		}
		Customer customer = (Customer)session.getAttribute("customer");		
		Account account = new Account();
		
		account.setAccountId(request.getParameter("accountId"));
		account.setCheckSave(request.getParameter("checkSave"));
		account.setOdp(request.getParameter("odp"));
		account.setBalance(request.getParameter("balance"));
		
		account.addTransaction("Deposit, $" + request.getParameter("balance") + ", " + LocalDate.now().toString());
		customer.addAccount(account);
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
