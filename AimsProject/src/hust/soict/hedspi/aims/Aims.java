package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

public class Aims {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws LimitExceedMediaException,PlayerException, ExistedMediaException, LimitExceededException {
        Cart cart = new Cart();
        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Star War", "Movie", 20.00f);
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
        Book book = new Book("Data Structures and Algorithms", "Computer Science",
                100.0f, authors);
        store.addMedia(book);
        new StoreManagerScreen(store);
        menu(store, cart);

    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // main menu
    public static void menu(Store s, Cart c) throws LimitExceedMediaException,PlayerException, ExistedMediaException{
        showMenu();

        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 0:
                System.out.println("\nExit Menu");
                System.exit(0);
                return;
            case 1:
                // view store
                s.printStore();
                chooseStoreMenu(s, c);
                menu(s, c);
                break;
            case 2:
                // update store
                chooseUpdateStore(s, c);
                menu(s, c);
                break;
            case 3:
                // see current cart
                c.print();
                cartMenu();
                choosingCartMenu(s,c);
                break;
        }
    }

    public static void chooseStoreMenu(Store s, Cart c) throws LimitExceedMediaException,PlayerException, ExistedMediaException {
        storeMenu();

        int optionStoreMenu = sc.nextInt();
        sc.nextLine();
        switch (optionStoreMenu) {
            case 0:
                System.out.println("\n Returned to main menu.");
                menu(s, c);
                break;
            case 1:
                // see details of a media
                System.out.println("\n See details for item: ");
                Media m = validMediaStore(s);
                if (m!=null)
                chooseMediaDetailsMenu(s, c, m);
                break;
            case 2:
                // add a media to cart
                m = validMediaStore(s);
                if (m!=null)c.addMedia(m);
                break;
            case 3:
                // play a media
                m = validMediaStore(s);
                if (m!=null) playMedia(m);
                break;
            case 4:
                // see current cart
                c.print();
                cartMenu();
                choosingCartMenu(s,c);
                break;
        }
    }

    public static Media validMediaStore(Store s) {
        Media media = null;
        System.out.println("Enter 0 to turn back");
        while (media == null) {
            System.out.println("Enter title: ");
            String title = sc.nextLine();
            media = s.search(title);
            if (title.equals("0"))
                return null;
            if (media == null)
                System.out.println("Not existed in store");

        }
        return media;
    }

    public static Media validMediaCart(Cart c) {
        Media media = null;
        System.out.println("Enter 0 to turn back");
        while (media == null) {
            System.out.println("Enter title: ");
            String title = sc.nextLine();
            media = c.search(title);
            if (title.equals("0"))
                return null;
            if (media == null)
                System.out.println("Not existed in cart");

        }
        return media;
    }

    public static void chooseMediaDetailsMenu(Store s, Cart c, Media m) throws LimitExceedMediaException ,PlayerException, ExistedMediaException {
        mediaDetailsMenu();

        int optionMediaDetailsMenu = sc.nextInt();
        sc.nextLine();
        switch (optionMediaDetailsMenu) {
            case 0:
                System.out.println("\n Returned to Store Menu.");
                chooseStoreMenu(s, c);
                break;
            case 1: // add to cart
                c.addMedia(m);
                break;
            case 2: // play
                if (!playMedia(m)) {
                    chooseMediaDetailsMenu(s, c, m);
                }
                break;
        }
    }

    public static void chooseUpdateStore(Store s, Cart c)throws LimitExceedMediaException,PlayerException, ExistedMediaException {

        System.out.println("\n Choose an option to update store \n 1. Add a media \n 2. Remove a media");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                addMediaStore(s, c);
            case 2:
                removeMediaStore(s, c);
        }
    }

    // Cart Menu
    public static void choosingCartMenu(Store s, Cart c)throws LimitExceedMediaException,PlayerException, ExistedMediaException {
        cartMenu();

        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 0:
                menu(s, c);
                break;
            case 1:
                filterCart(c);
                break;
            case 2: // sort
                sort(c);
                break;
            case 3:
                // remove media from cart
                System.out.println("Enter title: ");
                String title = sc.nextLine();
                c.removeMedia(c.search(title));
                break;
            case 4: // Play media in cart
                System.out.println("Enter title: ");
                title = sc.nextLine();
                playMedia(c.search(title));
                break;
            case 5: // place order
                System.out.println("An order has been created");
                menu(s, null);
                break;
        }
    }

    // Play a media
    public static boolean playMedia(Media m) throws PlayerException {
        if (m instanceof Playable) {
            ((Playable) m).play();
            return true;
        }
        System.out.println("This media is not playable!");
        return false;

    }

    // add media to store
    public static void addMediaStore(Store s, Cart c) throws LimitExceedMediaException, PlayerException, ExistedMediaException {

        System.out.println("\n Choose type of Media to add \n 1. Book \n 2. DVD \n 3. CD");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the title: ");
        String title = sc.nextLine();
        System.out.println("Enter the category: ");
        String category = sc.nextLine();
        System.out.println("Enter the cost: ");
        float cost = sc.nextFloat();
        sc.nextLine();
        switch (option) {
            case 1:
                // add Book
                System.out.println("Enter the authors: ");
                ArrayList<String> authors = new ArrayList<String>();
                authors.add(sc.nextLine());
                s.addMedia(new Book(title, category, cost, authors));
                menu(s, c);
                break;
            case 2:
                // add DVD
                System.out.println("Enter the director: ");
                String director = sc.nextLine();
                System.out.println("Enter the length: ");
                int length = sc.nextInt();
                sc.nextLine();
                s.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                menu(s, c);
                break;
            case 3:
                // add Track
                System.out.println("Enter the director: ");
                director = sc.nextLine();
                System.out.println("Enter the length: ");
                length = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the artist: ");
                String artist = sc.nextLine();
                System.out.println("Enter the number of track(s): ");
                int n = sc.nextInt();
                sc.nextLine();
                ArrayList<Track> tracks = new ArrayList<Track>();
                for (int i = 1; i <= n; i++) {
                    System.out.println("Enter track-" + i + "'s name: ");
                    String trackTitle = sc.nextLine();
                    System.out.println("Enter track-" + i + "'s length: ");
                    int trackLength = sc.nextInt();
                    sc.nextLine();
                    tracks.add(new Track(trackTitle, trackLength));
                }

                s.addMedia(new CompactDisc(title, category, cost, director, length, artist, tracks));
                menu(s, c);
                break;
        }
    }

    // remove media from store
    public static void removeMediaStore(Store s, Cart c)throws LimitExceedMediaException,PlayerException, ExistedMediaException {
        Media m = validMediaStore(s);
        if (m!=null)
        	s.removeMedia(m);
        menu(s, c);
    }

    public static void filterCart(Cart c) {
        System.out.println(
                "\n Choose an option to filter media in cart \n 1. Filter by title \n 2. Filter by id");
        int subOpt = sc.nextInt();
        sc.nextLine();
        if (subOpt == 1) {
            System.out.println("Enter title: ");
            String title = sc.nextLine();
            c.searchByTitle(title);
            return;
        }
        if (subOpt == 2) {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            sc.nextLine();
            c.searchById(id);
            return;
        }
        return;
    }

    public static void sort(Cart c) {
        System.out.println(
                "\n Choose an option to sort media in cart \n 1. Sort by title \n 2. Sort by cost");
        int subOpt = sc.nextInt();
        sc.nextLine();
        ObservableList<Media> mediaCollection = FXCollections.observableArrayList();
        mediaCollection=c.getItemsOrdered();
        if (subOpt == 1)
            Collections.sort(mediaCollection, Media.COMPARE_BY_TITLE_COST);

        if (subOpt == 2)
            Collections.sort(mediaCollection, Media.COMPARE_BY_COST_TITLE);
        Cart newCart = new Cart(mediaCollection);
        newCart.toString();
        return;
    }
}
