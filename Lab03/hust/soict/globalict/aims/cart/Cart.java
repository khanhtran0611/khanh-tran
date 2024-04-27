package Lab03.hust.soict.globalict.aims.cart;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Lab03.hust.soict.globalict.aims.media.Media;

public class Cart {
    private List<Media> cart = new ArrayList<>();

    public void display(){
        int cur = 1;
        for(Media e : cart){
            System.out.println(cur + ".\nTitle: "+ e.getTitle() +"\nCategory: "+ e.getCategory() +"\nCost: "+ e.getCost() +"$");
            cur += 1;
        }
    }
    public void search_by_title(String s){
        for(int i = 0;i < cart.size() ; i++){
           if(cart.get(i).getTitle().equals(s)){
               System.out.println("Title: "+ cart.get(i).getTitle() +"\nCategory: "+ cart.get(i).getCategory() +"\nCost: "+ cart.get(i).getCost() +"$");
               return;
           } 
        }
        System.out.println("Item is not found in your cart");
    }


    public void search_by_id(int id){
        for(Media i : cart){
            if(i.getId() == id){
                i.toString();
            }
        }
        System.out.println("The media with the id "+ id + " does not exist in the cart");
    }

    public void search_by_category(String category){
         for(Media i : cart){
             if((i.getCategory()).equals(category)){
                i.toString();
             }
         }
         System.out.println("All the media with the category" + category + " do not exist in the cart");
    }

    public void addMedia(Media e){
          for(int i = 0;i < cart.size() ;i++){
            if((cart.get(i)).equals(e)) {
                System.out.println("This item has been selected");
                return;
              }
          }
          cart.add(e);
    }
  
    public void removeMedia(String e){
          for(int i = 0; i < cart.size() ;i++ ){
              if((cart.get(i).getTitle()).equals(e)){
                 cart.remove(i);
                 return;
              }
          }
          System.out.println("This item does not exist in the cart");
    }
    public void list_of_ordered_items(){
      float totalCost = 0;
      System.out.println("***********************CART***********************");
      System.out.println("Ordered Items: ");
         for(int i = 0;i < cart.size() ; i++){
             System.out.println((i + 1) + ".DVD - "+ cart.get(i).getTitle() +" - "+ cart.get(i).getCategory() +": "+ cart.get(i).getCost() +"$");
             totalCost = totalCost + cart.get(i).getCost();
         }
      System.out.println("Total cost: "+totalCost);
      System.out.println("***************************************************");
    }
        public void sortByTitle() {
        Collections.sort((List<Media>)cart, Media.COMPARATOR_BY_TITLE_COST);
        this.list_of_ordered_items();
    }
    public void sortByCost(){
        Collections.sort((List<Media>)cart, Media.COMPARATOR_BY_COST_TITLE);
        this.list_of_ordered_items();
    }
    public float totalCost(){
        float sum = 0;
         for(int i = 0;i < cart.size() ; i++){
            sum = sum + cart.get(i).getCost();
         }
         return sum ;
    }
    public void freeCart(){
        cart.clear();
    }
}
