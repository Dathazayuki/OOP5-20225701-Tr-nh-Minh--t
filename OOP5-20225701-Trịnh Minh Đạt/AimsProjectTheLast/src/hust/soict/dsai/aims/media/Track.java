package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

	private String title;
	private float length;

	public Track(String title, float length) {
		this.title= title;
		this.length=length;	
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) { // Check if both references point to the same object
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Check if obj is null or a different class
            return false;
        }
        Track track = (Track) obj; // Cast obj to Track
        return length == track.length && title != null && title.equals(track.title); // Check equality of title and length
    }

    @Override
    public int hashCode() {
        float result;
        if (title != null) {
            result = title.hashCode(); // Lấy mã băm của title nếu không null
        } else {
            result = 0; // Nếu title là null, gán mã băm là 0
        }
        result = 31 *result + length; // Kết hợp thêm thuộc tính length
        return (int)(result); // Trả về kết quả mã băm dạng số nguyên
    }

   // Method to play a track
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length : " + length);
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	public static Track join(String string, ArrayList<Track> tracks) {
		// TODO Auto-generated method stub
		return null;
	}
	 public String toString() {
	        return "Track{" +
	               "title='" + title + '\'' +
	               ", length='" + length + '\'' +
	               '}';
	    }
}
