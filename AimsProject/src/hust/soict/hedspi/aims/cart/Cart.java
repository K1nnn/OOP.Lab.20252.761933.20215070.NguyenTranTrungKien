package hust.soict.hedspi.aims.cart;


import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Cart() {
    }

    public Cart(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceedMediaException, ExistedMediaException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceedMediaException("ERROR: The number of media has reached its limit");
        }
        if (itemsOrdered.contains(media)) {
            throw new ExistedMediaException("ERROR: Media already existed.");
        }
        media.setId(itemsOrdered.size()+1);
        itemsOrdered.add(media);
        System.out.println("The media " + media.getTitle() + " has been added");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed");
            return;
        }
        System.out.println("The media " + media.getTitle() + " does not exist");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public void searchById(int id) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found DVD with ID " + id + ":");
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("No DVD with ID " + id + " founded");
    }

    public boolean searchByTitle(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                System.out.println("Found DVD with title " + title + ":");
                System.out.println(itemsOrdered.get(i).toString());
                return true;
            }
        }
        System.out.println("No DVD with title " + title + " founded");
        return false;
    }

    public Media search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                System.out.println("Found media " + title + " in cart!");
                return media;
            }
        }
        System.out.println("Media " + title + " does not exist!");
        return null;
    }

    // new print cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(i + 1 + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}
