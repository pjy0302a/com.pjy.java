package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.book.Book;
import com.yedam.java.book.BookDAO;
import com.yedam.java.book.BookDAOImpl;

public class BookFrame {
	private BookDAO bookDAO = BookDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);

	public BookFrame() {
		boolean run = true;
		while (run) {
			// 메뉴출력
			menuPrint();
			int menuNo = Integer.parseInt(scanner.nextLine());

			// 각메뉴별 기능실행
			if (menuNo == 1) {
				selectAll();
			} else if (menuNo == 2) {
				selectOne();
			} else if (menuNo == 3) {
				selectContent();
			} else if (menuNo == 4) {
				rentalPossible();
			} else if (menuNo == 5) {
				bookRental();
			} else if (menuNo == 6) {
				bookReturn();
			} else if (menuNo == 7) {
				bookInsert();
			} else if (menuNo == 9) {
				end();
				break;
			}
		}
	}

	private void end() {
		System.out.println("종료되었습니다");
	}

	private void bookInsert() {
		Book book = inputBookInfo();
		// 부서정보 등록
		bookDAO.bookinsert(book);
	}

	private Book inputBookInfo() {

		Book book = new Book();

		System.out.print("책제목>");
		book.setBook_name(scanner.nextLine());

		System.out.print("저자명>");
		book.setBook_writer(scanner.nextLine());

		System.out.print("내용>");
		book.setContent(scanner.nextLine());

		System.out.print("대여여부>");
		book.setBook_rental(Integer.parseInt(scanner.nextLine()));

		return book;
	}

	private void bookReturn() {
		
		
	}

	private void bookRental() {
	}

	private void rentalPossible() {
		List<Book> list = bookDAO.selectAll();

		for (Book book : list) {
			
			if(book.getContent().equals("대여가능")) {
				System.out.println(book);
			
			}else {
				System.out.println(book);
			}
		}
	}

	private void selectContent() {
		String str = null;
		System.out.print("검색내용>");
		str = scanner.nextLine();
		
		List<Book> list = bookDAO.selectAll();

		for (Book book : list) {
			
			if(book.getContent().contains(str)) {
				System.out.println(book);
			
			}
		}

	

	}


	private void selectOne() {
		String book_name = book_input();

		Book book = bookDAO.selectOne(book_name);

		if (book == null) {
			System.out.println("책이 존재하지 않습니다.");
		} else {
			System.out.println(book);
		}
	}

	private String book_input() {
		String book_name = null;
		System.out.print("책제목>");
		book_name = scanner.nextLine();
		return book_name;
	}

	private void selectAll() {
		List<Book> list = bookDAO.selectAll();

		for (Book book : list) {
			
			System.out.println(book);
		}

	}

	private void menuPrint() {
		System.out.println("================================================================");
		System.out.println("1.전체조회 2.단건조회 3.내용검색 4.대여가능 5.책 대여 6.책 반납 7.책 등록 9.종료");
		System.out.println("================================================================");
		System.out.print("메뉴선택>");
	}

}
