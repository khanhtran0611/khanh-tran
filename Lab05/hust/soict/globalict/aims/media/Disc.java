package Lab05.hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director; 
    public Disc(){}
    public Disc(int length,String director){
        super();
        this.length = length;
        this.director = director;
    }
     public int getLength(){
        return length;
     }
     public String getDirector(){
        return director;
     }
   
}
