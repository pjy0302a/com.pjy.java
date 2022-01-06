package com.yedam.java.Quiz4;

public class Won2Dollar extends Converter{

	public Won2Dollar(double ratio) {
		super.ratio = ratio;
	}
	@Override
	protected double convert(double src) {
	
		return src / this.ratio ;
	}

	@Override
	protected String getSrcString() {
		return "원";
	}

	@Override
	protected String getDestString() {
		return "달러";
	}

}
