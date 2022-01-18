package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.movie.Board;
import com.yedam.java.movie.Login;
import com.yedam.java.movie.Movie;
import com.yedam.java.movie.MovieDAO;
import com.yedam.java.movie.MovieDAOImpl;
import com.yedam.java.movie.Movieseat;

public class MovieFrame {
	private MovieDAO movieDAO = MovieDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);
	String user = "user";
	String admin = "admin";
	Login login = new Login();
	public MovieFrame() {

		while (true) {
			// 메뉴출력
			int menuNo = menuPrint();
			// 각메뉴별 기능실행
			if (menuNo == 1) {
				signIn();
			} else if (menuNo == 2) {
				signUp();
			} else if (menuNo == 3) {
				noSignIn(login);
			} else if (menuNo == 4) {
				end();
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
		}
	}

	private int menuPrint() {
		System.out.println("===================================");
		System.out.println("1.로그인 2.회원가입 3.비로그인 4.종료");
		System.out.println("===================================");
		System.out.print("메뉴선택>");
		int menuNo = Integer.parseInt(scanner.nextLine());
		return menuNo;
	}

	private void adminPrint() {
		System.out.println("==============================");
		System.out.println("1.상영관관리 2.게시판관리 3.종료 ");
		System.out.println("==============================");
		System.out.print("메뉴선택>");
	}

	private void userPrint() {
		System.out.println("=======================================");
		System.out.println("1.영화목록 2.예매확인 3.게시판이동 4.종료 ");
		System.out.println("=======================================");
		System.out.print("메뉴선택>");
	}

	private void MovieCheck() {
		System.out.println("===============================================");
		System.out.println("1.영화추가 2.영화제거 3.영화목록 4.영화매출 5.종료 ");
		System.out.println("===============================================");
		System.out.print("메뉴선택>");
	}

	private void BoardPrint() {
		System.out.println("========================================================");
		System.out.println("1.게시판조회 2.게시판입력 3.게시판수정 4.게시판 삭제 5.종료 ");
		System.out.println("========================================================");
		System.out.print("메뉴선택>");
	}

	private void noUserPrint() {
		System.out.println("==============================");
		System.out.println("1.영화목록 2.게시판 3.종료 ");
		System.out.println("==============================");
		System.out.print("메뉴선택>");
	}

	private void BoardSelect() {
		System.out.println("1.검색 2.종료");
	}

	private void BoardUpdatePrint() {
		System.out.println("1.제목수정 2.내용수정 3.뒤로가기");
	}

	private void end() {
		System.out.println("종료되었습니다.");
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
				System.out.println(" 영화명 : " + slist.get(i).getMovieName() + " 좌석 번호 : "
						+ slist.get(i).getMovieSeatNum() + " 좌석 여부 : "
						+ (slist.get(i).getMovieLoginId() != null ? slist.get(i).getMovieLoginId() : "비어있음"));
			}
		}

	}

	private void seatChange(String moviename, int ticket, String loginId) {

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

	private void CheckReservation(String loginId) {
		List<Movie> mlist = movieDAO.movieList();
		List<Movieseat> slist = movieDAO.SeatAll();
//		System.out.println(loginId);
		for (int i = 0; i < mlist.size(); i++) {
			String movieName = mlist.get(i).getMovieName();
			for (int s = 0; s < slist.size(); s++) {
				if (slist.get(s).getMovieLoginId() != null) {
					if (slist.get(s).getMovieLoginId().equals(loginId) && slist.get(s).getMovieName().equals(mlist.get(i).getMovieName())) {
						System.out.println("영화명>" + mlist.get(i).getMovieName() + " | 예약좌석> "+ slist.get(s).getMovieSeatNum());
					}
				}
			}

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

	private void signIn() {
		List<Login> list = movieDAO.loginAll();
		String user = "user";
		String admin = "admin";
		System.out.print("아이디 입력>");
		String id = scanner.nextLine();
		System.out.print("비밀번호 입력>");
		String pw = scanner.nextLine();
		movieDAO.loginSearch(id,pw);
		for (Login loginMain : list) {
			if (id.equals(loginMain.getLoginId()) && pw.equals(loginMain.getLoginPw())) {
				if (admin.equals(loginMain.getLoginAuthority())) {
					while (true) {
						adminPrint();
						int adminNo = Integer.parseInt(scanner.nextLine());
						if (adminNo == 1) {
							// 상영관관리
							theater();

						} else if (adminNo == 2) {
							// 게시판관리
							boardMove(loginMain.getLoginId(), loginMain.getLoginAuthority());

						} else if (adminNo == 3) {
							break;

						}
					}

				} else if (user.equals(loginMain.getLoginAuthority())) {
					usercheck(loginMain.getLoginId(), loginMain.getLoginAuthority());

				}
			}

		}
	}

	private void signUp() {
		System.out.print("아이디 입력>");
		String id = scanner.nextLine();
		System.out.print("비밀번호 입력>");
		String pw = scanner.nextLine();
		System.out.print("이름 입력>");
		String name = scanner.nextLine();
		movieDAO.loginEquals(id,pw,name);

		}
		



	private void Reservation(String loginId) {
		System.out.println("1.예매하기 2.나가기");
		int menuNo = Integer.parseInt(scanner.nextLine());
		while(true) {
			if(menuNo == 1) {
				System.out.print("예매 할 영화제목>");
				String mname = scanner.nextLine();
				SeatOne(mname, loginId);
				System.out.print("예매할 티켓수>");
				int ticket = Integer.parseInt(scanner.nextLine());
				seatChange(mname, ticket, loginId);
				break;
			}else if(menuNo ==2){
				break;
			}
			
		}
		

		

		
	}

	public void movieDelete() {
		System.out.print("영화제목>");
		String name = scanner.nextLine();
		movieDAO.movieDelete(name);
		seatedelete(name);
	}

	public void movieInsert() {
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
		Movie(name, seatnum);
	}

	public void boardAllInsert(String loginId, String loginAuthority) {

		System.out.print("1.게시글 입력하기 2.종료>>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			if (loginAuthority==null) {
				System.out.println("게시글 입력을 위해 로그인해주십시오.");
			}else if(loginAuthority.equals("user") || loginAuthority.equals("admin")) {
				Board board = new Board();
				System.out.print("게시판이름>");
				String title = scanner.nextLine();
				board.setTitle(title);

				System.out.print("게시판내용>");
				String contents = scanner.nextLine();
				board.setContents(contents);

				board.setLoginId(loginId);
				board.setLoginAuthority(loginAuthority);
				List<Board> blist = movieDAO.BoardAll();

				movieDAO.boardInsert(title, contents, loginId, loginAuthority);
			}
		}
	}

	private void BoardSeletAll() {
		List<Board> blist = movieDAO.BoardAll();

		int num = 1;
		for (Board number : blist) {
			number.setSerialNum(num);

			num++;
		}
		for (Board board : blist) {
			System.out.println(board);

		}

	}

	private void BoardSelet() {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;
		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}
		for (Board board : blist) {
			System.out.println("no." + board.getSerialNum() + " 제목: " + board.getTitle() + " 글쓴이 : "
					+ board.getLoginId() + " 게시일 : " + board.getDate());

		}

	}

	private void BoardChoice() {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;
		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}
		System.out.print("1.게시글보기 2.종료 >>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			System.out.print("게시글 번호>");
			int choice = Integer.parseInt(scanner.nextLine());
			for (Board board : blist) {

				if (choice == board.getSerialNum()) {
					System.out.println("제목 :" + board.getTitle() + "\n내용 : " + board.getContents() + "\n글쓴이 : "
							+ board.getLoginId() + "\n게시일 : " + board.getDate());
				}
			}
		} else {
			System.out.println("종료");
		}

	}

	public void choiceMenu() {

	}

	private void BoradVoDelete() {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;
		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}

		System.out.println("1.게시글삭제 2.종료 >>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			System.out.print("번호 입력>");
			int select = Integer.parseInt(scanner.nextLine());
			Board board = null;
			for (Board b : blist) {

				if (b.getSerialNum() == select) {
					board = b;
					movieDAO.boardDelete(board);
				}
			}
		} else {
			System.out.println("종료");
		}

	}

	private void BoradVoDeleteCheck(String loginId, String loginAuthority) {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;
		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}

		System.out.print("1.게시글삭제 2.종료 >>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			System.out.print("번호 입력>");
			int select = Integer.parseInt(scanner.nextLine());
			Board board = null;
			for (Board b : blist) {

				if (b.getLoginAuthority().equals("user")) {
					if ((b.getSerialNum() == select) && (b.getLoginId().equals(loginId))) {
						board = b;
						movieDAO.boardDelete(board);
					}
				} else if (b.getLoginAuthority().equals("admin")) {
					if (b.getSerialNum() == select) {
						board = b;
						movieDAO.boardDelete(board);
					}

				}
			}
			if (board == null) {
				System.out.println("삭제할수없습니다.");
			}
		} else {
			System.out.println("종료");
		}

	}

	private void BoradVoUpdate() {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;

		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}

		System.out.println("1.게시글수정 2.종료>>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			System.out.print("수정할 게시판 입력>");
			int select = Integer.parseInt(scanner.nextLine());
			Board board = null;
			for (Board b : blist) {

				if (b.getSerialNum() == select) {
					board = b;
					BoardUpdatePrint();
					int boardNo = Integer.parseInt(scanner.nextLine());
					if (boardNo == 1) {
						System.out.println("수정할 제목을 입력하세요");
						String title = scanner.nextLine();
						movieDAO.boardtitleUpdate(board, title);
					} else if (boardNo == 2) {
						System.out.println("수정할 내용을 입력하세요");
						String contents = scanner.nextLine();
						movieDAO.boardcontentsUpdate(board, contents);
					} else if (boardNo == 3) {
						break;
					}
				} else {
					System.out.println("수정 할 수 없습니다.");
				}
			}
		} else {
			System.out.println("종료");

		}
	}

	private void BoradVoUpdateCheck(String loginId, String loginAuthority) {
		List<Board> blist = movieDAO.BoardAll();
		int num = 1;

		for (Board number : blist) {
			number.setSerialNum(num);
			num++;
		}

		System.out.print("1.게시글수정 2.종료>>>");
		int choiceNo = Integer.parseInt(scanner.nextLine());
		if (choiceNo == 1) {
			System.out.print("수정할 게시판 입력>");
			int select = Integer.parseInt(scanner.nextLine());
			Board board = null;

			for (Board b : blist) {

				if (b.getLoginAuthority().equals("user")) {
					if ((b.getSerialNum() == select) && (b.getLoginId().equals(loginId))) {

						board = b;
						BoardUpdatePrint();
						int boardNo = Integer.parseInt(scanner.nextLine());
						if (boardNo == 1) {
							System.out.println("수정할 제목을 입력하세요");
							String title = scanner.nextLine();
							movieDAO.boardtitleUpdate(board, title);
						} else if (boardNo == 2) {
							System.out.println("수정할 내용을 입력하세요");
							String contents = scanner.nextLine();
							movieDAO.boardcontentsUpdate(board, contents);
						} else if (boardNo == 3) {
							break;
						}

					}
				} else if (b.getLoginAuthority().equals("admin")) {
					board = b;
					BoardUpdatePrint();
					int boardNo = Integer.parseInt(scanner.nextLine());
					if (boardNo == 1) {
						System.out.println("수정할 제목을 입력하세요");
						String title = scanner.nextLine();
						movieDAO.boardtitleUpdate(board, title);
					} else if (boardNo == 2) {
						System.out.println("수정할 내용을 입력하세요");
						String contents = scanner.nextLine();
						movieDAO.boardcontentsUpdate(board, contents);
					} else if (boardNo == 3) {
						break;
					}

				} else {
					System.out.println("종료");
				}
			}
			if (board == null) {
				System.out.println("수정할수없습니다.");
			}
		}

	}

	public int boardMove(String loginId, String loginAuthority) {

		while (true) {
			BoardPrint();
			int boardNo = Integer.parseInt(scanner.nextLine());
			// 1.게시판조회 2.게시판입력 3.게시판수정 4.게시판 삭제 5.종료
			if (boardNo == 1) {
				// 1.게시판조회
				BoardSelet();
				BoardChoice();
			} else if (boardNo == 2) {
				// 2.게시판입력
				BoardSeletAll();
				boardAllInsert(loginId, loginAuthority);

			} else if (boardNo == 3) {
				// 3.게시판수정
				BoardSeletAll();
				BoradVoUpdateCheck(loginId, loginAuthority);
//				BoradVo();
			} else if (boardNo == 4) {
				// 4.게시판삭제
				BoardSeletAll();
				BoradVoDeleteCheck(loginId, loginAuthority);

			} else if (boardNo == 5) {
//				end();
				return 1;

				// continue FIRSTMENU;

			}
		}
	}

	public void theater() {
		while (true) {
			MovieCheck();
			int mNo = Integer.parseInt(scanner.nextLine());
			if (mNo == 1) {
				// 영화추가
				movieInsert();

			} else if (mNo == 2) {
				// 영화제거
				movieDelete();

			} else if (mNo == 3) {
				// 영화목록

				MovieAll();

			} else if (mNo == 4) {
				// 영화매출
				moviePrice();
				movieAllSales();
			} else if (mNo == 5) {

				end();
				break;
			}

		}
	}

	public void noSignIn(Login login) {
		List<Login> list = movieDAO.loginAll();
		while (true) {
			noUserPrint();
			int mNo = Integer.parseInt(scanner.nextLine());
			if (mNo == 1) {
				// 영화목록
				MovieAll();
				
			} else if (mNo == 2) {
				// 게시판관리
				boardMove(login.getLoginId(), login.getLoginAuthority());
			} else if (mNo == 3) {
				break;
			} 
		}
	}

	public void usercheck(String loginId, String loginAuthority) {
		while (true) {
			userPrint();
			int userNo = Integer.parseInt(scanner.nextLine());
			if (userNo == 1) {
				MovieAll();

				Reservation(loginId);
			} else if (userNo == 2) {
				// 예매확인
				CheckReservation(loginId);
				CancelReservation(loginId);
			} else if (userNo == 3) {
				// 게시판이동
				boardMove(loginId, loginAuthority);

			} else if (userNo == 4) {
				break;
			}
		}
	}

	private void CancelReservation(String loginId) {
		List<Movieseat> slist = movieDAO.SeatAll();
		while (true) {
			System.out.print("1.예매취소 2.종료 >>>>> ");
			int userNo = Integer.parseInt(scanner.nextLine());
			if (userNo == 1) {
				System.out.print("취소할 영화제목>");
				String moviename = scanner.nextLine(); 
				System.out.print("취소할 좌석번호>");
				int seat = Integer.parseInt(scanner.nextLine());
				for(int i=0; i<slist.size(); i++) {
					if(moviename.equals(slist.get(i).getMovieName()))
					if(seat == slist.get(i).getMovieSeatNum()) {
						if(loginId.equals(slist.get(i).getMovieLoginId())){
//							slist.get(i).setMovieLoginId(null);
							movieDAO.seatUpdate(moviename,seat,null);
						}
					}
				}
				
			} else if (userNo == 2) {
				break;
			
		}

	}
	}

}
