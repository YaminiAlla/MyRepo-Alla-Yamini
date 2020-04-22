package com.hcl.domino.techassign1;

/**
 * This class defines the usage of variable scope,access modifiers,storage
 * classes
 * 
 * @author AllaYamini
 * @version 1.8
 */
public class Vendor {
	// class variable is visible for any child class.
	public String name;

	// class variable visible in this class only.
	private double salary;

	// class variable visible to any sub class within or from other package
	protected int age;

	// default:A variable declared without any access control modifier is available
	// to any other class in the same package.
	String profession;

	/**
	 * This is a setter method which is used to set the value of Name
	 * 
	 * @param vendorName
	 * @return null
	 */
	public void setName(String vendorName) {
		name = vendorName;
	}

	/**
	 * This is a setter method which is used to set the value of salary
	 * 
	 * @param vendorSal
	 * @return null
	 */
	public void setSalary(double vendorSal) {
		salary = vendorSal;
	}

	/**
	 * This is a setter method which is used to set the value of Age
	 * 
	 * @param vendorAge
	 * @return null
	 */
	public void setAge(int vendorAge) {
		age = vendorAge;
	}

	/**
	 * This is a setter method which is used to set the value of Profession
	 * 
	 * @param vendorProfession
	 * @return null
	 */
	public void setProfession(String vendorProfession) {
		profession = vendorProfession;
	}

	/**
	 * This method is used to print the details of the vendor. It also explains the
	 * usage of local variable.
	 * 
	 * @return null
	 */
	public void printDetails() {
		// local variable can be used within the method
		String vendorid = "51848427";
		System.out.println("Name : " + name + "\nvendorid : " + vendorid + "\nSalary : " + salary + "\nAge : " + age
				+ "\nProfession:" + profession);
	}

	public static void main(String args[]) {
		// Displaying the program to the user
		if (args.length == 0) {
			System.out.println(
					"The description of the program is:\nThe program is used for displaying the vendordetails using variable scope and accessmodifiers\nNeed a input value to display the details\ne.g. java Vendor Yamini 20000 35 SoftSkills\n i.e, java Vendor <String> <double> <int>");
		} else {
			try {
				VendorDetails v = new VendorDetails();
				v.setName(args[0]);
				v.setSalary(Double.parseDouble(args[1]));
				v.setAge(Integer.parseInt(args[2]));
				v.setProfession(args[3]);
				v.printDetails();
				v.print();
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
}

/**
 * This is sub class which extends the super class Vendor
 */
class VendorDetails extends Vendor {
	// class variable
	public String role = "Trainer";

	/**
	 * This method is used to display the vendor Work details. It also shows the
	 * access of public and protected variables name,age from the super class
	 * 
	 * @return null
	 */
	public void print() {
		System.out.println("Working details\nName : " + name + "\nRole : " + role + "\nProfession :" + profession
				+ "\nAge :" + age);
	}
}