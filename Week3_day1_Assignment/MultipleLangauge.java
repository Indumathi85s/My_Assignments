package week2.day1;

public abstract class MultipleLangauge implements Language,TestTool {
	public void python() {
		System.out.println("Python() method belongs to class MultipleLangauge");
	}
	abstract void ruby();
}
