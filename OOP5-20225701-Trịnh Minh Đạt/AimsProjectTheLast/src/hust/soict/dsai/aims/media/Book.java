package hust.soict.dsai.aims.media;


import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<>();

	public Book( String title, String category, float cost , List<String> authors ) {
		
		// TODO Auto-generated constructor stub
		super( title, category, cost);
        this.authors = authors;
		
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) { // Check if the author is not already in the list
            authors.add(authorName); // Add the author if not present
            System.out.println(authorName + " has been added.");
        } else {
            System.out.println(authorName + " is already in the authors list.");
        }
    }

    // Method to remove an author from the authors list
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { // Check if the author is in the list
            authors.remove(authorName); // Remove the author
            System.out.println(authorName + " has been removed.");
        } else {
            System.out.println(authorName + " is not in the authors list.");
        }
    }

    // Utility method to display all authors (for testing purposes)
    public String getAuthorsAsString() {
        return String.join(", ", authors);
    }
    public String toString() {
        return "Book{" +
               "title='" + super.getTitle() + '\'' +
               ", category='" + super.getCategory() + '\'' +
               ", cost=" + super.getCost() +
               ", author='" + authors + '\'' +
               '}';
    }
}

