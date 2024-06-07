package Lab05.hust.soict.globalict.aims.media;

import javax.swing.JOptionPane;

import Lab05.hust.soict.globalict.aims.exception.PlayerException;

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

    public void play() throws PlayerException {
       if(this.getLength() > 0){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
       }else{
         JOptionPane.showMessageDialog(null, "ERROR: DVD Length is non-positive", "Illegal DVD Length", JOptionPane.WARNING_MESSAGE);
        throw new PlayerException("Erorr: DVD's length is non-positive");
       }
    }


  
}
