package com.interview.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeOrder {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Saurabh");
		Employee e2 = new Employee(1, "Saurabh");
		Employee e3 = new Employee(3, "Saurabh3");
		Employee e4 = new Employee(4, "Saurabh4");
		Employee e5 = new Employee(5, "Saurabh5");
		Employee e6 = new Employee(6, "Saurabh6");
		Employee e7 = new Employee(7, "Saurabh7");
		Employee e8 = new Employee(8, "Saurabh8");
		Employee e9 = new Employee(9, "Saurabh9");
		Employee e10 = new Employee(10, "Saurabh10");		
		
		System.out.println(e1.equals(e2));
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e8);
		empList.add(e9);
		empList.add(e10);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		empList.add(e7);
		
		System.out.println(empList);
		
		Comparator<Employee> empComparator = ( emp1,  emp2)-> {
			if(emp1.getEmplId() > emp2.getEmplId()) {
				return 1;
			}
			else if(emp1.getEmplId() == emp2.getEmplId()) {
				return 0;
			}
			else {
				return -1;
			}
		};

		TreeSet<Employee> set = new TreeSet<>(empComparator);
		set.addAll(empList);
		
		System.out.println(set);
	}
}

class Employee {
	private int emplId;
	private String empName;

	public Employee(int emplId, String empName) {
		this.emplId = emplId;
		this.empName = empName;
	}
	
	public int getEmplId() {
		return emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null || !(obj instanceof Employee)) {
			return false;
		}
		
		else {
			Employee emp = (Employee) obj;
			if((this.emplId == emp.getEmplId())&& this.empName.equals(emp.getEmpName())){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "("+emplId+","+empName+")";
	
	}
}
