package com.yedam.java.Quiz4;

public class MainExample {

	public static void main(String[] args) {
		NamedCircle w = new NamedCircle(5, "Waffle");
		w.show();
		
		Adder add = new Adder();
		add.run();
		new Subtracter().run();
		
		Won2Dollar toDollar = new Won2Dollar(1200); //1달러는 1200원
		toDollar.run();
	}

}
