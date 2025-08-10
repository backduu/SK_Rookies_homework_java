package mylab.book.entity;

import java.text.SimpleDateFormat;
import java.util.*;

public class Publication {
	protected String title;
	protected String publishDate;
	protected Integer page;
	protected Integer price;
	
	public Publication() {
		
	}
	
	public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.page = page;
        this.price = price;
        this.publishDate = publishDate; 
	}
	
	public String getTitle() {
	    return title;
	}

	public void setTitle(String title) {
	    this.title = title;
	}

	public String getPublishDate() {
	    return publishDate;
	}

	public void setPublishDate(String publishDate) {
	    this.publishDate = publishDate;
	}

	public Integer getPage() {
	    return page;
	}

	public void setPage(Integer page) {
	    this.page = page;
	}

	public Integer getPrice() {
	    return price;
	}

	public void setPrice(Integer price) {
	    this.price = price;
	}
	
	public String toString() {
		return this.title;
	}
}
