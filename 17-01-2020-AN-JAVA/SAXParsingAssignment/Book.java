import java.time.LocalDateTime;
import java.util.Date;

public class Book {
	private String book_id;
	private String title;
	private String author;
	private String genre;
	private float price;
	private LocalDateTime publish_date;
	private String description;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDateTime getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDateTime publish_date) {
		this.publish_date = publish_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	@Override
	public String toString() {
		return "ID="+getBook_id()+"\tAuthor="+getAuthor()+"\tTitle="+getTitle()+"\tGenre="+getGenre()
		+"\tPrice="+getPrice()+"\tYear="+getPublish_date().getDayOfYear()+"\tDesc="+getDescription();

	}
}
