package hust.soict.hedspi.test.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args)throws LimitExceedMediaException, ExistedMediaException {
        Cart cart = new Cart();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd);
        Track track1 = new Track("The Lion King", 87);
        Track track2 = new Track("Battle", 32);

        // add cd
        List<Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd = new CompactDisc("The Lion King", "Animation", 19.95f, "Roger Allers", tracks);
        cart.addMedia(cd);

        // add book
        List<String> authors = new ArrayList<String>();
        authors.add("John Doe");
        authors.add("Jane De");
        Book book = new Book("Data Structures and Algorithms", "Computer Science", 100.0f, authors);
        cart.addMedia(book);

        cart.print();
        List<Media> mediaCollection = new ArrayList<>(cart.getItemsOrdered());
        // Sort by title then cost
        Collections.sort(mediaCollection, Media.COMPARE_BY_TITLE_COST);
        System.out.println(mediaCollection);
        // OR Sort by cost then title
        Collections.sort(mediaCollection, Media.COMPARE_BY_COST_TITLE);
        System.out.println(mediaCollection);
    }
}