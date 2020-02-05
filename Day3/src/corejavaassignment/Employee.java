package corejavaassignment;


public class Employee {
	String employee_Name;
	int employee_Salary;
	
	Employee(String name, int salary){
		employee_Name = name;
		employee_Salary = salary;
	}
	
	public String returnEmployeeName() {
		return employee_Name;
	}
	public int returnEmployeeSalary() {
		return employee_Salary;
	}

}
