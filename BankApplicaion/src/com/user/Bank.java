package com.user;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.user.Customer;

public class Bank implements java.io.Serializable {

	private String name;
	private static String fileName = "C:\\Users\\wkoni\\Desktop\\Bank\\bank.txt";
	
	private Customer[] customers = new Customer[0];
	
	public Bank () {
		name = "RoboBank & Trust";
	}
	
	public static Bank load() throws IOException, ClassNotFoundException {
		
	    FileInputStream file = new FileInputStream(fileName); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        Bank b = (Bank)in.readObject(); 
          
        in.close();
        file.close();
        
		return b;
	}
	public void save() throws IOException {
		 FileOutputStream file = new FileOutputStream(fileName); 
         ObjectOutputStream out = new ObjectOutputStream(file); 
   
         out.writeObject(this); 
           
         out.close(); 
         file.close(); 
		  
	}
	
	public void addCustomer(Customer cstmr) {
		Customer[] newCustomer = new Customer[customers.length + 1];
		System.arraycopy(customers, 0, newCustomer, 0, customers.length);
		newCustomer[newCustomer.length - 1] = cstmr;
		customers = newCustomer;
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteCustomer(String email) {
		Customer[] tempArray = new Customer[customers.length - 1];
		for (int i=0; i<customers.length; i++) {
			if (email != customers[i].getEmail()) {
				tempArray[i] = customers[i];
			}
		}
		customers = tempArray;
	}
		
	
	public Customer getCustomer(String email, String password) {
		for (int i = 0; i < customers.length; i++) {
			if (email.equalsIgnoreCase(customers[i].getEmail())) {
				if (password.contentEquals(customers[i].getPassword())) {
					return customers[i];
				}
			}
		}
		return null;
	}
	
	public void updateCustomer(Customer c) {
		for (int i = 0; i < customers.length; i++) {
			if (c.getEmail().equalsIgnoreCase(customers[i].getEmail())) {
				customers[i] = c;
			}
		}
	}
	
	public Customer getRealCustomer(Customer customer) {
		for (int i = 0; i < customers.length; i++) {
			if (customer.getEmail().equalsIgnoreCase(customers[i].getEmail())) {
				return customers[i];
			}
		}
		return null;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Bank.fileName = fileName;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
		
}