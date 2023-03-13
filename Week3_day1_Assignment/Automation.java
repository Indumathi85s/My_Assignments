package week2.day1;

public class Automation extends MultipleLangauge {

	public static void main(String[] args) {
		Automation a = new Automation();
		a.java();
		a.python();
		a.ruby();
		a.Selenium();

	}

	public void java() {
		System.out.println("java() method belongs to class Language");
		
	}

	public void Selenium() {
		System.out.println("Selenium() method belongs to class TestTool");
		
	}

	@Override
	void ruby() {
		System.out.println("ruby() method belongs to class MultipleLangauge(Method override in this class Automation)");
		
	}

}
