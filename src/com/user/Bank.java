package com.user;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.user.Customer;

//The Bank class will implement java.io.Serializable in order to be able to serialize the objects 
//so they can be in a serializable file. This means that the file will not be human-readable, but
//it is "dumbed down" for the compiler to understand more readily. This is an easy way to write to 
//a file because the compiler is able to simply pick out the objects you intend on using. 
public class Bank implements java.io.Serializable {

	private String name;
	
	//The name above is pointless, disregard. Below, fileName is the file path in which the 
    //file is saved. We put bank.txt on the end so the compiler will search for that file and,
    //if it does not exist, it will create that file. 
	private static String fileName = "C:\\Users\\wkoni\\Desktop\\Bank\\bank.txt";
	
	//Below, the Bank class has multiple customers. Therefore, we create an array of Customers called customers and 
    //initialize it at 0 so we can modify and work with it later on in the code.
	private Customer[] customers = new Customer[0];
	
	public Bank () {
		name = "RoboBank & Trust";
	}
	
	//The load method is the method to read a file. Using FileInputStream and ObjectInputStream, we are
    //able to read the file that we serialized. By putting the method in the Bank class, we are able to
    //use and reuse the method later on in our code. Therefore, we don't have to mess with the whole
    //process of FileInputStream, etc., but rather, we can just call the load function, saving 
    //time and code. 
	public static Bank load() throws IOException, ClassNotFoundException {
		
	    FileInputStream file = new FileInputStream(fileName); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        Bank b = (Bank)in.readObject(); 
          
        in.close();
        file.close();
        
		return b;
	}
	
	//The save method, similar to the load method, simply rewrites the file. We use this method in the same
    //fashion as the other method - to save on code and to be able to reuse the code.
	public void save() throws IOException {
		 FileOutputStream file = new FileOutputStream(fileName); 
         ObjectOutputStream out = new ObjectOutputStream(file); 
   
         out.writeObject(this); 
           
         out.close(); 
         file.close(); 
		  
	}
	
	//This addCustomer method has a few advantages: reusability, but also, it allows the customer to save
    //or write themselves to the file. Therefore, we wouldn't have to access the Bank class when 
    //calling this method. Allowing for a new customer to save themselves is good practice because
    //then we can be assured that whenever we input info about a customer, it will be saved. 
	public void addCustomer(Customer cstmr) {
		//Steps:
        //Create a new array with a length of plus 1 because we are going to want to increase the size
        //of the new array in order to make room for the new customer.
		Customer[] newCustomer = new Customer[customers.length + 1];
		//Using arraycopy, we can put in all of the values of the old array of customers into the new array.
		System.arraycopy(customers, 0, newCustomer, 0, customers.length);
		//Then, in the last index of the array (length-1), I can input the original cstmr.
		newCustomer[newCustomer.length - 1] = cstmr;
		//Here, the newCustomer is given a new value in order to begin the process again.
		customers = newCustomer;
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//deleteCustomer works in a similar manner. 
	public void deleteCustomer(String email) {
		//1. Create new array but with one space less.
		Customer[] tempArray = new Customer[customers.length - 1];
		//2. Loop over the array in order to pull out the customer you want to delete (differentiated by email)
		for (int i=0; i<customers.length; i++) {
			if (email != customers[i].getEmail()) {
				//3. Set the tempArray at the index to the customers Array at the same index
				tempArray[i] = customers[i];
			}
		}
		//4. Reset the customers and the tempArray in order to begin the process again
		customers = tempArray;
	}
		
	//This getCustomer method is to get the customer using email AND password-- our dummy authentication 
    //for the login
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
	
	//This getRealCustomer method finds the customer by email (assuming they are already logged in)
    //and returns that customer so we can manipulate its data
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