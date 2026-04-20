package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, int length, String artist,
            List<Track> tracks) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " already exists!");
            return;
        }
        tracks.add(track);
        System.out.println("Add track " + track.getTitle() + " successfully!");
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " does not exist!");
            return;
        }
        tracks.remove(track);
        System.out.println("Remove track " + track.getTitle() + " successfully!");
    }

    public void play() throws PlayerException {
    	 System.out.println("Playing CompactDisc: " + this.getTitle());
         System.out.println("CD length: " + this.getLength());

        if(this.getLength()>0) {
        	for (Track track : tracks) {
        		try{
        			track.play();
        		}catch (PlayerException e) {
        			throw e;
        		}
        		
        	}
        }
        else {
        	throw new PlayerException("ERROR: Some track have length equal or less than 0.");
        }
    }
    
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - "
                + this.getLength() + " : " + this.getCost() + "$";
    }
}
