package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public Disc(String title, String category,String director, int length,float cost) {
		super( title, category, cost);
        this.director = director;
        this.length = length;
	}
	public Disc(String title) {
		super( title);
        this.director = "";
        this.length = 0;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
}
