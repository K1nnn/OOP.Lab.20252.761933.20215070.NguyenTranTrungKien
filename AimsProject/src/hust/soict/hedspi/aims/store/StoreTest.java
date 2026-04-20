package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;

public class StoreTest {
    public static void main(String[] args)throws LimitExceedMediaException, ExistedMediaException {
        Store store = new Store();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);
        Track track1 = new Track("The Lion King", 87);
        Track track2 = new Track("Battle", 32);

        // add cd
        List<Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd = new CompactDisc("The Lion King", "Animation", 19.95f, "Roger Allers", tracks);
        store.addMedia(cd);

        // add book
        List<String> authors = new ArrayList<String>();
        authors.add("John Doe");
        authors.add("Jane De");
        Book book = new Book("Data Structures and Algorithms", "Computer Science", 100.0f, authors);
        store.addMedia(book);

        store.printStore();
    }

}
