package com.Aditya.EmployeeApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Aditya.Employee.CollectionsEmployeeOperationsImpl;
import com.Aditya.Employee.Employee;
import com.Aditya.Employee.EmployeeArrayOperationsImpl;
import com.Aditya.Employee.EmployeeUtil;
import com.Aditya.Employee.InvalidSalaryException;

public class CollectionsEmployeeApp {

	public static void main(String[] args) throws InvalidSalaryException, Exception {

		EmployeeArrayOperationsImpl eaoi = new EmployeeArrayOperationsImpl();
		CollectionsEmployeeOperationsImpl ceo = new CollectionsEmployeeOperationsImpl();
		Scanner input = new Scanner(System.in);

		File inputFile = new File("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");

		List<Employee> list = new ArrayList<Employee>();
		ceo.readCSV(inputFile);

		for (Employee e : list) {
			System.out.println("Aditya");
			if (e != null) {
				ceo.createEmployee(e);
			}
		}

		while (true) {
			eaoi.displayMenu();
			String choice = input.next();

			switch (choice) {
			case "a":
				System.out.println("Enter the following employee details");
				ceo.createEmployee(EmployeeUtil.getValueFromUser());
				break;

			case "b":
				System.out.println("Enter the employee Id: ");
				int empid = input.nextInt();
				ceo.findEmployee(empid);
				break;

			case "c":
				System.out.println("Enter employee name: ");
				String name = input.next();
				ceo.findEmployee(name);
				break;

			case "d":
				System.out.println("Enter the id of the employee you want to delete: ");
				int Id = input.nextInt();
				ceo.deleteEmployee(Id);
				System.out.println("Employee deleted!");
				break;

			case "e":
				System.out.println("Enter the following details:");
				ceo.updateEmployee(EmployeeUtil.getValueFromUser());
				break;

			case "f":
				System.out.println("Enter the employee id to calculate gross salary: ");
				int empsal = input.nextInt();
				ceo.calculateGrossSal(empsal);
				break;

			case "g":
				ceo.display();
				break;

			case "h":
				EmployeeUtil.regexCounter(inputFile);
				break;

			case "i":
				EmployeeUtil.sortData(ceo.emplist);
				break;

			case "j":
				ceo.getUniqueNames(ceo.emplist);
				break;

			case "k":
				ceo.getEmployeeCount(ceo.emplist);
				break;

			case "l":
				ceo.writeCSV();
				System.out.println("File overwritten succefully!");
				System.exit(0);
				break;
			}
		}

	}

}
