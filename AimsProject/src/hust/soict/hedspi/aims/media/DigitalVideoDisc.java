package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title);

    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public boolean isMatch(String title) {
        String[] words = title.split(" ");
        for (String word : words) {
            if (this.getTitle().toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void play() throws PlayerException {
    	if (this.getLength()<=0) 
    		throw new PlayerException("ERROR: Length must be positive integer");
    	else{
    		System.out.println("Playing DVD: " + this.getTitle());
    		System.out.println("DVD length: " + this.getLength());
    	}	
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
                + this.getLength() + ": " + this.getCost() + "$";
    }

}
