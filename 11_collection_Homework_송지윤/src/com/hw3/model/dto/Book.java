package com.hw3.model.dto;

public class Book {
	private int bookNum; // 도서번호
	private String title; // 도서제목
	private String author; // 저자
	private int price; // 가격
	private String publisher; // 출판사
	
	public Book() {}

	public Book(int bookNum, String title, String author, int price, String publisher) {
		this.bookNum = bookNum;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "\n" + bookNum + "번 도서 : [도서제목 : " + title + " / 도서저자 : " + author + " / 도서가격 : " + price
				+ "원 / 출판사 : " + publisher + "]\n";
	}
	
}
