package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private int length;
    private String title;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public void play() throws PlayerException {
    	if (this.getLength()<=0) 
    		throw new PlayerException("ERROR: Length must be positive integer");
    	else{
    		System.out.println("Playing Track: " + this.getTitle());
    		System.out.println("Track length: " + this.getLength());
    	}	
    }
    @Override
    public boolean equals(Object obj) {
        Track t = (Track) obj;
        if (this.getTitle() == t.getTitle()
                && this.getLength() == t.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Track: " + this.getTitle() + " - " + this.getLength();
    }
}
