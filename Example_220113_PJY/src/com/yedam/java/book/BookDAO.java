package com.yedam.java.book;

import java.util.List;

public interface BookDAO {
	//전체조회
	public List<Book> selectAll();
	//단건조회
	public Book selectOne(String book_name);
	//내용검색
	public List<Book> selectContent();
	//대여가능
	public void rentalTrue(Book book);
	//책 등록
	public void bookinsert(Book book);
	
		
}
