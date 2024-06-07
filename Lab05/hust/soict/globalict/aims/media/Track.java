package Lab05.hust.soict.globalict.aims.media;

import javax.swing.JOptionPane;

import Lab05.hust.soict.globalict.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.getLength() > 0){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: Track's Length is non-positive", "Illegal Track's Length", JOptionPane.WARNING_MESSAGE);
            throw new PlayerException("Erorr: Track's length is non-positive");
        }
    }
    public boolean equals(Object o){
        if (!(o instanceof Track)) return false;
        String objTitle = ((Track) o).getTitle();
        int objLength = ((Track) o).getLength();
        return objTitle.equals(this.title) && objLength == this.length;
    }
}