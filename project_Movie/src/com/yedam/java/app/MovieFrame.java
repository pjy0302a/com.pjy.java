package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.movie.Login;
import com.yedam.java.movie.Movie;
import com.yedam.java.movie.MovieDAO;
import com.yedam.java.movie.MovieDAOImpl;

public class MovieFrame {
	private MovieDAO movieDAO = MovieDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);

	public MovieFrame() {
		boolean run = true;
		String user = "user";
		String admin = "admin";
		main: while (run) {
			// 메뉴출력
			menuPrint();
			int menuNo = Integer.parseInt(scanner.nextLine());

			// 각메뉴별 기능실행
			if (menuNo == 1) {

				System.out.print("아이디 입력>");
				String id = scanner.nextLine();
				System.out.print("비밀번호 입력>");
				String pw = scanner.nextLine();

				List<Login> list = movieDAO.loginAll();

				for (Login login : list) {
					if (id.equals(login.getLoginId()) && pw.equals(login.getLoginPw())) {
						if (admin.equals(login.getLoginAuthority())) {
							while (run) {
								adminPrint();
								int adminNo = Integer.parseInt(scanner.nextLine());
								if (adminNo == 1) {
									// 상영관관리
									while (run) {
										MovieCheck();
										int mNo = Integer.parseInt(scanner.nextLine());
										if (mNo == 1) {
											//영화추가
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
											
											movieDAO.movieInsert(newMovie);
										} else if (mNo == 2) {
											//영화제거
											System.out.print("영화제목>");
											String name = scanner.nextLine();
											movieDAO.movieDelete(name);
										} else if (mNo == 3) {
											//영화매출
											
										} else if (mNo == 4) {
											//좌석목록	(배열이용)
											
//											int[] seat = new int[];
										} else if (mNo == 5) {
											end();
											continue main;
										}
									}
								} else if (adminNo == 2) {

								} else if (adminNo == 3) {
									end();
									continue main;
								}
							}

						} else if (user.equals(login.getLoginAuthority())) {
							while (run) {
								userPrint();
								int userNo = Integer.parseInt(scanner.nextLine());
								if (userNo == 1) {

								} else if (userNo == 2) {

								} else if (userNo == 3) {

								} else if (userNo == 4) {
									end();
									continue main;
								}
							}
						}
					}
//					System.out.println(login);
				}

			} else if (menuNo == 2) {
				Login login = new Login();
				System.out.print("아이디 입력>");
				login.setLoginId(scanner.nextLine());
				System.out.print("비밀번호 입력>");
				login.setLoginPw(scanner.nextLine());
				;
				System.out.print("이름 입력");
				login.setLoginName(scanner.nextLine());
				movieDAO.loginCreate(login);

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
		System.out.println("1.영화추가 2.영화제거 3.매출 4.좌석목록 5.종료 ");
		System.out.println("======================================");
		System.out.print("메뉴선택>");
	}

	private void end() {
		System.out.println("종료되었습니다.");
	}

	private void userCheck() {

	}
}
