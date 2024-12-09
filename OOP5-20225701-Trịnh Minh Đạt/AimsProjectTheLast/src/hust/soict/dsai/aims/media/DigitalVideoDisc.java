package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super( title, category, director, length , cost);   
	}
	public DigitalVideoDisc(String title) {
		super( title);
		
	}

	 @Override
	    public void play() throws PlayerException {
	        if (this.getLength() > 0) {
	            System.out.println("Playing DVD: " + this.getTitle());
	            System.out.println("DVD length: " + this.getLength());
	        } else {
	            throw new PlayerException("ERROR: DVD length is non-positive!");
	        }
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
