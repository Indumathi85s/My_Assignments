package week2.day1;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student ID : " +id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID : " +id);
		System.out.println("Student Name : " +name);
	}
	
	public void getStudentInfo(String email,long phone) {
		System.out.println("Student Phone Number : " +phone);
		System.out.println("Student Email Address : " +email);
	}

	public static void main(String[] args) {
		Students s = new Students();
		s.getStudentInfo(1234);
		s.getStudentInfo(1234,"Indumathi");
		s.getStudentInfo("indumathi85s@gmail.com",739592631);
		

	}

}
