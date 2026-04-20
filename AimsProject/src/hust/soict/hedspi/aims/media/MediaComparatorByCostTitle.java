package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // Compare by cost first
        Float cost1 = media1.getCost();
        Float cost2 = media2.getCost();
        int compare = cost1.compareTo(cost2);
        if (compare == 0) {
            compare = media1.getTitle().compareTo(media2.getTitle());
        }
        return compare;
    }
}
