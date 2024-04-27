package Lab03.hust.soict.globalict.aims.store;


import Lab03.hust.soict.globalict.aims.media.Media;
import java.util.List;
import java.util.ArrayList;

public class Store {
      private List<Media> itemsInStores = new ArrayList<>();
      public void addMedia(Media e){
        for(int i = 0;i < itemsInStores.size() ;i++){
          if(itemsInStores.get(i) == e) {
              System.out.println("This item has been selected");
              return;
            }
        }
        itemsInStores.add(e);
  }

  public void removeMedia(Media e){
        for(int i = 0; i < itemsInStores.size() ;i++ ){
            if(itemsInStores.get(i).equals(e)){
               itemsInStores.remove(i);
               return;
            }
        }
        System.out.println("This item does not exist in the cart");
  }
  public Media searchByTitle(String title){
    for (Media media : itemsInStores){
        if ((media.getTitle()).equals(title)){
            return media;
        }
    }
    return null;
}
   public void printMedia(Media e){
       e.toString();
   }
}
