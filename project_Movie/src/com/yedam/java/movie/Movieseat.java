package com.yedam.java.movie;

public class Movieseat {
	private String movieName;
	private int movieSeatNum;
	private String movieLoginId;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMovieSeatNum() {
		return movieSeatNum;
	}
	public void setMovieSeatNum(int movieSeatNum) {
		this.movieSeatNum = movieSeatNum;
	}
	public String getMovieLoginId() {
		return movieLoginId;
	}
	public void setMovieLoginId(String movieLoginId) {
		this.movieLoginId = movieLoginId;
	}
	@Override
	public String toString() {
		return "영화명 : " + movieName + " 좌석 번호 : " + movieSeatNum + " 좌석 여부 : " + movieLoginId + "";
	}
	
	
}
