package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super( title, category, director, length , cost);   
	}
	public DigitalVideoDisc(String title) {
		super( title);
	}

	 public void play() {
	        // Triển khai phương thức play() cho DigitalVideoDisc
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength() + " minutes");
	    }

	public boolean isMatch(String title2) {
		// TODO Auto-generated method stub
		return false;
	}
	 @Override
	    public String toString() {
	        return "DigitalVideoDisc{" +
	               "title='" + super.getTitle() + '\'' +
	               ", category='" + super.getCategory() + '\'' +
	               ", director='" + super.getDirector() + '\'' +
	               ", cost=" + super.getCost() +
	               ", length=" + super.getLength() +
	               '}';
	    }
	
}
