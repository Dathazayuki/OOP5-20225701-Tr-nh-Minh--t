package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> Tracks = new ArrayList<>();

	public CompactDisc(String title, String category,String director, int length,float cost, String artist) {
		super( title, category, director, length , cost);
		this.artist=artist;
		
		// TODO Auto-generated constructor stub
	}
	 // Method to play a track
    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD artist: " + artist);
            System.out.println("CD length: " + this.getLength());
            for (Track track: Tracks) {
                track.play();
            }
            Iterator<Track> iter = Tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                nextTrack.play();
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track Track) {
        if (!Tracks.contains(Track)) { // Check if the author is not already in the list
        	Tracks.add(Track); // Add the author if not present
            System.out.println(Track.getTitle() + " has been added.");
        } else {
            System.out.println(Track.getTitle()+ " is already in the Tracks list.");
        }
    }

    // Method to remove an author from the authors list
    public void removeTrack(Track Track) {
        if (Tracks.contains(Track)) { // Check if the author is in the list
        	Tracks.remove(Track); // Remove the author
            System.out.println( Track.getTitle()+ " has been removed.");
        } else {
            System.out.println(Track.getTitle() + " is not in the Tracks list.");
        }
    }

    // Utility method to display all authors (for testing purposes)
    public Track getTracksAsString() {
        return Track.join(", ", Tracks);
    }
    public boolean contains(Track track) {
        for (Track item : Tracks) {
            if (item.equals(track)) { // Sử dụng equals đã override trong Media
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "CompactDisc{" +
               "title='" + super.getTitle() + '\'' +
               ", category='" + super.getCategory() + '\'' +
               ", director='" + super.getDirector() + '\'' +
               ", length='" + super.getLength() + '\'' +
               ", cost=" + super.getCost() +
               ", artist='" + artist + '\'' +
               '}';
    }

}
