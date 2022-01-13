package com.yedam.java.book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.book.Book;
import com.yedam.java.book.BookDAO;
import com.yedam.java.common.DAO;

public class BookDAOImpl extends DAO implements BookDAO {
	private static BookDAOImpl instance = new BookDAOImpl();
	private  BookDAOImpl() {}
	public static BookDAOImpl getInstance() {
		return instance;
	}
	@Override
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String select = "SELECT * FROM book";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBook_name(rs.getString("book_name"));
				book.setBook_writer(rs.getString("book_writer"));
				book.setContent(rs.getString("book_content"));
				book.setBook_rental(rs.getInt("book_rental"));
				list.add(book);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Book selectOne(String book_name) {
		Book book=null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_name = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, book_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setBook_name(rs.getString("book_name"));
				book.setBook_writer(rs.getString("book_writer"));
				book.setContent(rs.getString("book_content"));
				book.setBook_rental(rs.getInt("book_rental"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return book;
	}

	@Override
	public List<Book> selectContent() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String select = "SELECT * FROM book";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBook_name(rs.getString("book_name"));
				book.setBook_writer(rs.getString("book_writer"));
				book.setContent(rs.getString("book_content"));
				book.setBook_rental(rs.getInt("book_rental"));
				list.add(book);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	@Override
	public void rentalTrue(Book book) {
		try {
			connect();
			String update = "UPDATE book SET book_retal = ? WHERE book_name = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, book.getBook_rental());
			pstmt.setString(2, book.getBook_name());
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	@Override
	public void bookinsert(Book book) {
		try {
			connect();
			String insert = "INSERT INTO book VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getBook_name());
			pstmt.setString(2, book.getBook_writer());
			pstmt.setString(3, book.getContent());
			pstmt.setInt(4, book.getBook_rental());
				
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 입력완료!");
		}catch (Exception e) {
			
		}finally {
			disconnect();
		}
	}

}
