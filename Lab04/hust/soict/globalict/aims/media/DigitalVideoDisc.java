package Lab04.hust.soict.globalict.aims.media;



public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title){
        setTitle(title);
   }
   public DigitalVideoDisc(String category,String title,float cost){
        setCategory(category);
        setTitle(title);
        setCost(cost);
   }
   public DigitalVideoDisc(String director,String category,String title,float cost){
        
        setCategory(category);
        setTitle(title);
        setCost(cost);
   }
   public DigitalVideoDisc(String title,String category,String director,int length,float cost){
       super(length, director);
       setCategory(category);
       setTitle(title);
       setCost(cost);
   }
   public DigitalVideoDisc(String title,String category,String director,int length,float cost,int id){
     super(length, director);
      setCategory(category);
      setTitle(title);
      setCost(cost);
       setId(id);
 }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }


  
}
