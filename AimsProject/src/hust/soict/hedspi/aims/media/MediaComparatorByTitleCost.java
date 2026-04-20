package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // Compare by title first
        String title1 = media1.getTitle();
        String title2 = media2.getTitle();
        int compare = title1.compareTo(title2);
        if (compare == 0) {
            // Compare by cost
            Float cost1 = media1.getCost();
            Float cost2 = media2.getCost();
            compare = cost1.compareTo(cost2);
        }
        return compare;
    }
}
