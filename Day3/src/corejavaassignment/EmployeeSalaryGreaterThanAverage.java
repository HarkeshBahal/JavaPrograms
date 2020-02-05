package corejavaassignment;

import java.util.Scanner;

public class EmployeeSalaryGreaterThanAverage {
	public static void main(String[] arg) {
		Employee[] emp = new Employee[4];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<emp.length; i++) {
			System.out.println("Enter Employee name:");
			String name = scan.next();
			System.out.println("Enter Employee salary:");
			int salary = scan.nextInt();
			emp[i] = new Employee(name, salary);
		}
		int averageSalary = 0;
		int totalSalaryAllEmployee = 0;
		for(Employee employee : emp) {
			totalSalaryAllEmployee += employee.returnEmployeeSalary();
		}
		averageSalary = totalSalaryAllEmployee/emp.length;
		for(Employee employee : emp) {
			if (employee.returnEmployeeSalary() >= averageSalary) {
				System.out.println("Employee name: " +employee.returnEmployeeName() +" whose salary: "+employee.returnEmployeeSalary()+ " greater than average salary: " +averageSalary +" of all employee");
			}
		}
	}

}

/*Output
 * 	Enter Employee name:
		Harkesh
	Enter Employee salary:
		34500
	Enter Employee name:
		Neha
	Enter Employee salary:
		34250
	Enter Employee name:
		Harsh
	Enter Employee salary:
		23450
	Enter Employee name:
		Harry
	Enter Employee salary:
		21400
	Employee name: Harkesh whose salary: 34500 greater than average salary: 28400 of all employee
	Employee name: Neha whose salary: 34250 greater than average salary: 28400 of all employee
 */
