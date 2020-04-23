package com.hcl.domino.techassign1;

/**
 * This program illustrates the different ways of initializing the private
 * member variables
 */
public class Product {
	private String name;
	private int quantity;
	private int price;

	/**
	 * This is a default constructor
	 */
	Product() {

	}

	/**
	 * This is a parameterized constructor
	 * 
	 * @param n1
	 * @param q1
	 * @param p1
	 */
	Product(String n1, int q1, int p1) {
		this.name = n1;
		this.quantity = q1;
		this.price = p1;
	}

	/**
	 * This is a parameterized constructor
	 * 
	 * @param n2
	 * @param p2
	 */
	Product(String n2, int p2) {
		this.name = n2;
		this.price = p2;
		this.quantity = price / 10;
	}

	/**
	 * This is the display method which is used to display the values of
	 * name,quantity,price
	 * 
	 * @return null
	 */
	private void display() {
		System.out.println("Product Name :" + name);
		System.out.println("Product quantity is :" + quantity);
		System.out.println("Product price is:" + price);
	}

	public static void main(String[] args) {
		
			System.out.println(
					"Usage description of the program\nThe program is used for displaying the products\nNeed a input value to display\ne.g. java Product");
		
				Product product1; //creating object to class
				product1 = new Product("Cashew", 250, 50);
				product1.display(); //get the details from invoked object
				product1 = new Product("Badam", 150);
				product1.display();
			
	}
}