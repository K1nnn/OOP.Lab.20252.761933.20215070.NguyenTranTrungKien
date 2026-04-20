package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author " + authorName + " already exists!");
			return;
		}
		authors.add(authorName);
		System.out.println("Add author " + authorName + " successfully!");
	}

	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Author " + authorName + " does not exist!");
			return;
		}
		authors.remove(authorName);
		System.out.println("Remove author " + authorName + " successfully!");
	}

	@Override
	public String toString() {
		return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " $";
	}
}
