import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandleXMLData extends DefaultHandler {

	private ArrayList<Book> list;
	private Book b=null;
	boolean book_id=false;
	boolean title=false;
	boolean author=false;
	boolean genre=false;
	boolean price=false;
	boolean publish_date=false;
	boolean description=false; 
	private StringBuilder data;
	
	public ArrayList<Book> getList() {
		return list;
	}

	public Book getB() {
		return b;
	}


	public boolean isBook_id() {
		return book_id;
	}


	public boolean isTitle() {
		return title;
	}


	public boolean isAuthor() {
		return author;
	}


	public boolean isGenre() {
		return genre;
	}


	public boolean isPrice() {
		return price;
	}


	public boolean isPublish_date() {
		return publish_date;
	}


	public boolean isDescription() {
		return description;
	}


	public StringBuilder getData() {
		return data;
	}


	@Override
	public void characters(char[] arr, int st, int end) throws SAXException {	
		
		data.append(new String(arr,st,end));
		//System.out.println(data);
	}

	
	@Override
	public void startElement(String uri, String ln, String qn, Attributes attr) throws SAXException {
		if(qn.equals("book")) {
			b=new Book();
			book_id=true;
			if(list==null)
				list=new ArrayList<Book>();
			b.setBook_id(attr.getValue("id"));
		}
		else if(qn.equals("author")) {
			author=true;
		}
		else if(qn.equals("title")) {
			title=true;
		}
		else if(qn.equals("genre")) {
			genre=true;
		}
		else if(qn.equals("price")) {
			price=true;
		}
		else if(qn.equals("publish_date")) {
			publish_date=true;
		}
		else if(qn.equals("description")) {
			description=true;
		}
		data=new StringBuilder();
	}
	
	@Override
	public void endElement(String uri, String ln, String qn) throws SAXException {
		
		if(author) {
			author=false;
			b.setAuthor(data.toString());
		}
		else if(title) {
			title=false;
			b.setTitle(data.toString());
		}
		else if(genre) {
			genre=false;
			b.setGenre(data.toString());
		}
		else if(price) {
			price=false;
			b.setPrice(Float.parseFloat(data.toString()));
		}
		else if(publish_date) {
			publish_date=false;
			b.setPublish_date(LocalDateTime.now());
		}
		else if(description) {
			description=false;
			b.setDescription(data.toString());
		}
		
		if(qn.equals("book")) {
			list.add(b);
			b=null;
		}
	}


}
