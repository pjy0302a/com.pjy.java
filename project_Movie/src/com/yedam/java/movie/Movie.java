package com.yedam.java.movie;

public class Movie {
	private String movieName;
	private int moviePrice;
	private String movieDate;
	private int movieSeat;
	private int movieSales;
	
	public int getMovieSales() {
		return movieSales;
	}
	public void setMovieSales(int movieSales) {
		this.movieSales = movieSales;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public int getMovieSeat() {
		return movieSeat;
	}
	public void setMovieSeat(int movieSeat) {
		this.movieSeat = movieSeat;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", moviePrice=" + moviePrice + ", movieDate=" + movieDate
				+ ", movieSeat=" + movieSeat + "]";
	}
	
}
