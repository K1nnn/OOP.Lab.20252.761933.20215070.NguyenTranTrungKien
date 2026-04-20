package hust.soict.hedspi.aims.store;

import java.util.ArrayList;


import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media)throws LimitExceedMediaException, ExistedMediaException {
    	  if (itemsInStore.size() >= MAX_NUMBERS_ORDERED) {
              throw new LimitExceedMediaException("ERROR: The number of media has reached its limit");
          }
          if (itemsInStore.contains(media)) {
              throw new ExistedMediaException("ERROR: Media already existed.");
          }
          media.setId(itemsInStore.size()+1);
          itemsInStore.add(media);
          System.out.println("The media " + media.getTitle() + " has been added");
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("Media " + media.getTitle() + " does not exist!");
            return;
        }
        itemsInStore.remove(media);
        System.out.println("Remove media " + media.getTitle() + " successfully!");
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                System.out.println("Found media " + title + " in store!");
                return media;
            }
        }
        System.out.println("Media " + title + " does not exist!");
        return null;
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Store:");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }
}