package Lab04.hust.soict.globalict.aims.media;


import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();
    public Book(int id,String title,String category,float cost){
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public void addAuthor(String authorName){
          for(String e : authors){
             if(e.equals(authorName)){
                 System.out.println("THis author's name has existed in the list");
                 return;
             }
          }
          authors.add(authorName);
    }
    public void removeAuthor(String authorName){
          for(String e : authors){
             if(e.equals(authorName)){
                authors.remove(authorName);
                return;
             }
          }
          System.out.println("This author 's name does not exist in the list");
    }
}
