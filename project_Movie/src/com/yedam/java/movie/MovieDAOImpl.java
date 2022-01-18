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
			while (rs.next()) {
				Login login = new Login();
				login.setLoginId(rs.getString("loginid"));
				login.setLoginPw(rs.getString("loginpw"));
				login.setLoginName(rs.getString("loginid"));
				login.setLoginAuthority(rs.getString("loginauthority"));

				list.add(login);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieName(rs.getString("movieName"));
				movie.setMoviePrice(rs.getInt("moviePrice"));
				movie.setMovieDate(rs.getString("movieDate"));
				movie.setMovieSeat(rs.getInt("movieSeat"));
				movie.setMovieSales(rs.getInt("movieSales"));

				list.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void movieDelete(String moviename) {
		try {
			connect();
			String delete = "DELETE FROM MovieList WHERE moviename = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, moviename);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void movieSeat(String moviename) {

	}


	@Override
	public List<Movieseat> SeatAll() {
		List<Movieseat> list = new ArrayList<Movieseat>();
		try {
			connect();
			String select = ("SELECT * FROM MovieSeat");
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Movieseat Movieseat = new Movieseat();
				Movieseat.setMovieName(rs.getString("movieName"));
				Movieseat.setMovieSeatNum(rs.getInt("movieSeatNum"));
				Movieseat.setMovieLoginId(rs.getString("movieLoginId"));

				list.add(Movieseat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	@Override
	public void seatInsert(String movieName, int seatNum) {
		try {
			connect();
			String insert = "INSERT INTO MovieSeat (MovieName,MovieSeatNum)VALUES (?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, movieName);
			pstmt.setInt(2, seatNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void seatUpdate(String movieName,int seatNum, String loginId) {
		try {
			connect();
			String update = "UPDATE MovieSeat SET MovieLoginId = ? WHERE MovieSeatNum = ? AND MovieName = ? ";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, loginId);
			pstmt.setInt(2, seatNum);
			pstmt.setString(3, movieName);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void movieSales(String movieName, int movieSales) { // 영화를 예매하면 price를 리턴받고 Sales필드값에 저장
		try {
			connect();
			String update = "UPDATE MovieList SET MovieSales = ? WHERE MovieName = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, movieSales);
			pstmt.setString(2, movieName);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	@Override
	public void seatdelete(String moviename) {
		try {
			connect();
			String delete = "DELETE FROM MovieSeat WHERE moviename = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, moviename);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	@Override
	public List<Board> BoardAll(){
		List<Board> list = new ArrayList<Board>();
		try {
			connect();
			String select = ("SELECT * FROM Board");
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setSerialNum(rs.getInt("serialNum"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("contents"));
				board.setLoginId(rs.getString("loginId"));
				board.setLoginAuthority(rs.getString("loginAuthority"));
				board.setDate(rs.getString("date"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	@Override
	public void boardInsert(String title,String contents,String loginId, String loginAuthority) {
		try {
			connect();
			String insert = "INSERT INTO Board (title,contents,loginId,loginAuthority,date)VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			//pstmt.setInt(1, 0);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, loginId);
			pstmt.setString(4, loginAuthority);
			pstmt.setString(5, time);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void boardtitleUpdate(Board board, String title) {
		try {
			connect();
			String update = "UPDATE Board SET title = ? WHERE title = ? AND contents = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, title);
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContents());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	@Override
	public void boardtitleUpdateCheck(Board board, String title, String loginId) {
		try {
			connect();
			String update = "UPDATE Board SET title = ? WHERE title = ? AND contents = ? AND login_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, title);
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContents());
			pstmt.setString(4, board.getLoginId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	@Override
	public void boardcontentsUpdate(Board board, String Contents) {
		try {
			connect();
			String update = "UPDATE Board SET contents = ? WHERE title = ? AND contents = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, Contents);
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContents());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	@Override
	public void boardDelete(Board board) {
		try {
			connect();
			String delete = "DELETE FROM Board WHERE title = ? AND contents = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void boardSerialNum(int serialNum) {
		try {
			connect();
			String insert = "INSERT INTO Board (serialNum) VALUES (?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, serialNum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void loginEquals(String id,String pw, String name) {
		Login login = new Login();
		try {
			connect();
			String select = "SELECT * FROM movieLogin WHERE loginId = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복된 아이디입니다.");
			}else {
				System.out.println("회원가입 완료");
				login.setLoginId(id);
				login.setLoginPw(pw);
				login.setLoginName(name);
				loginCreate(login);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void loginSearch(String id, String pw) {
		
		try {
			connect();
			String select = "SELECT * FROM movieLogin WHERE loginId = ? AND loginPw = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("로그인 완료");
			}else {
				System.out.println("다시입력해주십시오.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	
}
