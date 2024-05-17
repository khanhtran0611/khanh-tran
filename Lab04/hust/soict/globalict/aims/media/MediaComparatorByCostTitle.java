package Lab04.hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        float cost1 = o1.getCost();
        float cost2 = o2.getCost();
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int comparison =  Double.compare(cost1, cost2);
        if(comparison == 0){
            return title1.compareTo(title2);
        }else{
            return comparison;
        }
    }

}
