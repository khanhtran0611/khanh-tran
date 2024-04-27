package Lab03.hust.soict.globalict.aims.media;


import java.util.Comparator;

public abstract class Media  {
    public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();
     private int id;
     private String title;
     private String category;
     private float cost;

     public int getId(){
        return id;
     }
     public String getTitle(){
        return title;
     }
     public String getCategory(){
        return category;
     }
     public float getCost(){
        return cost;
     }
     public void setId(int id){
         this.id = id;
     }
     public void setTitle(String title){
        this.title = title;
     }
     public void setCategory(String category){
        this.category = category;
     }
     public void setCost(float cost){
        this.cost = cost;
     }
     public String toString(){
         return "\nId: "+ id + "\nTitle: " + title + "\nCategory: " + category + "\nCost: " +cost; 
     }
     public boolean equals(Object o){
            if(!(o instanceof Media)){
               return false;
            }else{
               String title = ((Media)o).getTitle();
               return title.equals(this.title);
            }
     }
     public boolean isMatch(String Title){
      return this.getTitle().equals(Title);
  }

}
