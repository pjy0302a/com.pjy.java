package com.yedam.java.movie;

import java.util.List;

public interface MovieDAO {
	//로그인
	public List<Login> loginAll();
	//회원가입
	public void loginCreate(Login login);
	//영화등록
	public void movieInsert(Movie movie);
	//영화목록	
	public List<Movie> movieList();
	//영화삭제
	public void movieDelete(String moviename);
	
	//좌석목록
	public void movieSeat(String moviename);
	
	//영화매출
	public void movieSales(String movieName, int movieSales);
	
	//영화좌석
	public List<Movieseat> SeatAll();
	
	public void seatInsert(String movieName, int seatnum);
	
	public void seatUpdate(String movieName,int seatNum, String loginId);
	
	public void seatdelete(String moviename);
}
