package mylab.book.entity;

import java.text.SimpleDateFormat;

public class Novel extends Publication {
	private String author;
	private String genre;
	
	public Novel(String title, String publishDate, int page, int price, String author, String genre) { 
        super(title, publishDate, page, price);  
        this.author = author;
        this.genre = genre;
	}
	
	public String getAuthor() {
	    return author;
	}

	public void setAuthor(String author) {
	    this.author = author;
	}

	public String getGenre() {
	    return genre;
	}

	public void setGenre(String genre) {
	    this.genre = genre;
	}
	
	@Override
	public String toString() {
		return String.format("%s [�Ҽ�] ����:%s, �帣:%s, %d��, %d��, ������:%s",
				title, author, genre, page, price, publishDate);
	}
}
