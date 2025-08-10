package mylab.book.entity;

import java.text.SimpleDateFormat;

public class ReferenceBook extends Publication {
	private String field;
	
	public ReferenceBook(String title, String publishDate, int page, int price, String field) { 
        super(title, publishDate, page, price);  
        this.field = field; 
	}
	
	public String getField() {
	    return field;
	}

	public void setField(String field) {
	    this.field = field;
	}

	@Override
	public String toString() {
		return String.format("%s [����] �о�:%s, %d��, %d��, ������:%s",
				title, field, page, price, publishDate);
	}
}
