package com.yedam.java.movie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.common.DAO;

public class MovieDAOImpl extends DAO implements MovieDAO {
	private static MovieDAOImpl instance = new MovieDAOImpl();
	private Scanner scanner = new Scanner(System.in);
	private MovieDAOImpl() {
		 	}
	public static MovieDAOImpl getInstance() {
		return instance;
	}
	String time = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());

	@Override
	public List<Login> loginAll() {
		List<Login> list = new ArrayList<Login>();
		try {
			connect();
			String select = "SELECT * FROM MovieLogin";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Login login = new Login();
				login.setLoginId(rs.getString("loginid"));
				login.setLoginPw(rs.getString("loginpw"));
				login.setLoginName(rs.getString("loginid"));
				login.setLoginAuthority(rs.getString("loginauthority"));
				
				list.add(login);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
		
		
		

	@Override
	public void loginCreate(Login login) {
		try {
			connect();
			String insert = "INSERT INTO MovieLogin VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, login.getLoginId());
			pstmt.setString(2, login.getLoginPw());
			pstmt.setString(3, login.getLoginName());
			pstmt.setString(4, "user");
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
	}

	@Override
	public void movieInsert(Movie movie) {
		try {
			connect();
			String insert = "INSERT INTO Movielist (moviename, movieprice,moviedate,movieseat)VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, movie.getMovieName());
			pstmt.setInt(2, movie.getMoviePrice());
			pstmt.setString(3, time);
			pstmt.setInt(4, movie.getMovieSeat());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	@Override
	public List<Movie> movieList() {
		List<Movie> list = new ArrayList<Movie>();
		try {
			connect();
			String select = ("SELECT * FROM MovieList");
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	@Override
	public void movieDelete(String moviename) {
		try {
			connect();
			String delete = "DELETE FROM MovieList WHERE moviename = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, moviename);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	@Override
	public void movieSeat() {
	}

	@Override
	public int movieSales() {	//영화를 예매하면 price를 리턴받고 Sales필드값에 저장
		return 0;
	}

}
