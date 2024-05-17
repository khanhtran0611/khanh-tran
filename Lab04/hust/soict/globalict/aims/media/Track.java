package Lab04.hust.soict.globalict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title,int length){
        this.title = title;
        this.length = length;
    }
    public String getTitle(){
         return title;
    }
    public int getLength(){
        return length;
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    public boolean equals(Object o){
        if (!(o instanceof Track)) return false;
        String objTitle = ((Track) o).getTitle();
        int objLength = ((Track) o).getLength();
        return objTitle.equals(this.title) && objLength == this.length;
    }
}