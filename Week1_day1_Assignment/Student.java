package week1.assignment;

public class Student {
	String studentName="Indumathi S";
	int rollNo=2365;
	String collegeName="Test Leaf";
	int markScored=61;
	float cgpa=82.3f;

	public static void main(String[] args) {
		Student s = new Student();
		System.out.println("Student Name : "+s.studentName);
		System.out.println("Roll Number : "+s.rollNo);
		System.out.println("College Name : "+s.collegeName);
		System.out.println("Mark Scored : "+s.markScored);
		System.out.println("cgpa : "+s.cgpa);

	}

}
