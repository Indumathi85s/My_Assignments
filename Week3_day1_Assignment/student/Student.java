package org.student;

import org.department.Department;

public class Student extends Department {


	public void studentName() {
		System.out.println("studentName() method is created in the class Student");
	}

	public void studentDept() {
		System.out.println("studentDept() method is created in the class Student");
	}

	public void studentId() {
		System.out.println("studentId() method is created in the class Student");
	}

	public static void main(String[] args) {
		Student s=new Student();
		s.collegeCode();
		s.collegeName();
		s.collegeRank();
		s.deptName();
		s.studentDept();
		s.studentId();
		s.studentName();

	}

}
