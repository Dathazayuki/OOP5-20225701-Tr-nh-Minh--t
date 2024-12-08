package hust.soict.dsai.aims.media;

import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> Tracks = new ArrayList<>();

	public CompactDisc(String title, String category,String director, int length,float cost, String artist) {
		super( title, category, director, length , cost);
		this.artist=artist;
		
		// TODO Auto-generated constructor stub
	}
	public void play() {
        if (Tracks.isEmpty()) {
            System.out.println("No tracks to play on the Compact Disc: " + getTitle());
        } else {
            System.out.println("Playing Compact Disc: " + getTitle());
            for (Track track : Tracks) {
                track.play(); // Call play() on each Track
            }
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
