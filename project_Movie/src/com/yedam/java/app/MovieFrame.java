package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.movie.Login;
import com.yedam.java.movie.Movie;
import com.yedam.java.movie.MovieDAO;
import com.yedam.java.movie.MovieDAOImpl;
import com.yedam.java.movie.Movieseat;

public class MovieFrame {
	private MovieDAO movieDAO = MovieDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);
	Login loginMain = new Login();
	List<Login> list = movieDAO.loginAll();
	List<Movie> mlist = movieDAO.movieList();
	List<Movieseat> slist = movieDAO.SeatAll();

	public MovieFrame() {
		boolean run = true;
		String user = "user";
		String admin = "admin";
		FIRSTMENU: while (run) {
			// 메뉴출력
			menuPrint();
			int menuNo = Integer.parseInt(scanner.nextLine());

			// 각메뉴별 기능실행
			if (menuNo == 1) {

				System.out.print("아이디 입력>");
				String id = scanner.nextLine();
				System.out.print("비밀번호 입력>");
				String pw = scanner.nextLine();

				for (Login loginMain : list) {
					if (id.equals(loginMain.getLoginId()) && pw.equals(loginMain.getLoginPw())) {
						if (admin.equals(loginMain.getLoginAuthority())) {
							while (run) {
								adminPrint();
								int adminNo = Integer.parseInt(scanner.nextLine());
								if (adminNo == 1) {
									// 상영관관리
									while (run) {
										MovieCheck();
										int mNo = Integer.parseInt(scanner.nextLine());
										if (mNo == 1) {
											// 영화추가
											Movie newMovie = new Movie();
											System.out.print("영화제목>");
											String name = scanner.nextLine();
											newMovie.setMovieName(name);
											System.out.print("영화가격>");
											int price = Integer.parseInt(scanner.nextLine());
											newMovie.setMoviePrice(price);
											System.out.print("영화좌석>");
											int seatnum = Integer.parseInt(scanner.nextLine());
											newMovie.setMovieSeat(seatnum);

											// Movieseat[] seatNum1 = new Movieseat[seatnum];
											movieDAO.movieInsert(newMovie);
											Movie(name, seatnum);

										} else if (mNo == 2) {
											// 영화제거
											System.out.print("영화제목>");
											String name = scanner.nextLine();
											movieDAO.movieDelete(name);
											seatedelete(name);
										} else if (mNo == 3) {
											// 영화목록

											MovieAll();

										} else if (mNo == 4) {
											// 영화매출
											moviePrice();
											movieAllSales();
										} else if (mNo == 5) {

											end();
											continue FIRSTMENU;
										}
									}
								} else if (adminNo == 2) {

								} else if (adminNo == 3) {
									end();
									continue FIRSTMENU;
								}
							}

						} else if (user.equals(loginMain.getLoginAuthority())) {
							while (run) {
								userPrint();
								int userNo = Integer.parseInt(scanner.nextLine());
								if (userNo == 1) {
									MovieAll();
									System.out.print("예매 할 영화제목>");
									String mname = scanner.nextLine();

									System.out.print("예매할 티켓수>");
									int ticket = Integer.parseInt(scanner.nextLine());
									String loginid = loginMain.getLoginId();

									SeatOne(mname, loginid);

									seatChange(mname, ticket, loginid);

								} else if (userNo == 2) {

								} else if (userNo == 3) {

								} else if (userNo == 4) {
									end();
									continue FIRSTMENU;
								}
							}
						}
					}
//					System.out.println(login);
				}

			} else if (menuNo == 2) {
				loginMain = new Login();

				System.out.print("아이디 입력>");
				String id = scanner.nextLine();
				System.out.print("비밀번호 입력>");
				String pw = scanner.nextLine();
				System.out.print("이름 입력");
				String name = scanner.nextLine();

				for (Login logintf : list) {
					if (id.equals(logintf.getLoginId())) {
						System.out.println("이미있는 아이디입니다.");
						continue FIRSTMENU;
					}

				}
				loginMain.setLoginId(id);
				loginMain.setLoginPw(pw);
				loginMain.setLoginName(name);
				movieDAO.loginCreate(loginMain);
			} else if (menuNo == 3) {

			} else if (menuNo == 4) {
				end();
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
		}
	}

	private void menuPrint() {
		System.out.println("===============================");
		System.out.println("1.로그인 2.회원가입 3.비로그인 4.종료");
		System.out.println("===============================");
		System.out.print("메뉴선택>");
	}

	private void adminPrint() {
		System.out.println("===============================");
		System.out.println("1.상영관관리 2.게시판관리 3.종료 ");
		System.out.println("===============================");
		System.out.print("메뉴선택>");
	}

	private void userPrint() {
		System.out.println("=================================");
		System.out.println("1.영화목록 2.금액충전 3.게시판이동 4.종료 ");
		System.out.println("=================================");
		System.out.print("메뉴선택>");
	}

	private void MovieCheck() {
		System.out.println("======================================");
		System.out.println("1.영화추가 2.영화제거 3.영화목록 4.영화매출 5.종료 ");
		System.out.println("======================================");
		System.out.print("메뉴선택>");
	}

	private void end() {
		System.out.println("종료되었습니다.");
	}

	private void userCheck() {

	}

	private void MovieAll() {
		List<Movie> mlist = movieDAO.movieList();

		for (Movie Movie : mlist) {
			System.out.println(Movie);
		}
	}

	private void SeatOne(String moviename, String loginId) {
		List<Movieseat> slist = movieDAO.SeatAll();
		for (int i = 0; i < slist.size(); i++) {
			if (slist.get(i).getMovieName().equals(moviename)) {
				System.out
						.println(" 영화명 : " + slist.get(i).getMovieName() + " 좌석 번호 : " + slist.get(i).getMovieSeatNum()
								+ " 좌석 여부 : " + (slist.get(i).getMovieLoginId() != null ? loginId : "비어있음"));
			}
		}

	}

	private void seatChange(String moviename, int ticket, String loginId) {
//		SeatOne(moviename,loginId);
		List<Movieseat> slist = movieDAO.SeatAll();
		
		if (ticket > 0) {
			TIKET: for (int x = 1; x <= ticket; x++) {
				System.out.print("좌석번호 입력>");
				int seatnum = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < slist.size(); i++) {
					if (slist.get(i).getMovieName().equals(moviename)) {
						if (slist.get(i).getMovieSeatNum() == seatnum) {
							if (slist.get(i).getMovieLoginId() == null) {
								System.out.println(" 영화명 : " + slist.get(i).getMovieName() + " 좌석 번호 : "
										+ slist.get(i).getMovieSeatNum() + " 예매한 ID : "
										+ (slist.get(i).getMovieLoginId() != null ? loginId : "비어있음"));
								movieDAO.seatUpdate(moviename, seatnum, loginId);

							} else {
								System.out.println("이미 좌석이 차있습니다");
								x -= 1;
								continue TIKET;
							}
						}
					}
				}

			}
		}

	}

	private void moviePrice() {
		List<Movie> mlist = movieDAO.movieList();
		List<Movieseat> slist = movieDAO.SeatAll();
		for (int i = 0; i < mlist.size(); i++) {
			int cnt = 0;
			String movieName = mlist.get(i).getMovieName();
			for (int s = 0; s < slist.size(); s++) {
				if (movieName.equals(slist.get(s).getMovieName()) && (slist.get(s).getMovieLoginId() != null)) {
					cnt++;
				}
			}
			int result = mlist.get(i).getMoviePrice() * cnt;

			
			movieDAO.movieSales(movieName, result);
		}
	}

	private void movieAllSales() {
		List<Movie> mlist = movieDAO.movieList();
		for (int i = 0; i < mlist.size(); i++) {
			System.out.println("영화명 >" + mlist.get(i).getMovieName() + "\n" + "영화매출>" + mlist.get(i).getMovieSales());
		}
	}

	private void seatedelete(String name) {
		List<Movieseat> slist = movieDAO.SeatAll();
		for (int i = 0; i < slist.size(); i++) {
			if (name.equals(slist.get(i).getMovieName())) {
				movieDAO.seatdelete(name);
			}
		}
	}

	private void Movie(String movieName, int seatNum) {
		for (int i = 1; i <= seatNum; i++) {
			movieDAO.seatInsert(movieName, i);
		}
	}

}
