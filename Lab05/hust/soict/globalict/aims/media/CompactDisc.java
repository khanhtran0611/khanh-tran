package Lab05.hust.soict.globalict.aims.media;

import java.util.List;

import Lab05.hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc(int id,String title,String category,float cost,String artist){
        setCategory(category);
        setTitle(title);
        setCost(cost);
         setId(id);
        this.artist = artist;
    }
    public CompactDisc(int id,int length,String title,String category,float cost,String artist,String director){
        super(length,director);
        setCategory(category);
        setTitle(title);
        setCost(cost);
        setId(id);
        this.artist = artist;
    }
    public String getArtist(){
          return artist;
    }
    public void addTrack(Track e){
         for(int i = 0;i < tracks.size() ;i++){
             if(tracks.get(i) == e) {
                 System.out.println("This track has already existed in the list of tracks");
                 return;
             }
         }
         this.tracks.add(e);
    }
    public void removeTrack(Track e){
         for(int i = 0;i < tracks.size() ;i++){
             if(tracks.get(i) == e){
                tracks.remove(i);
                return ;
             }
         }
         System.out.println("The track does not exist in the list of tracks");
    }
    public int getTrackLength(){
        int cost = 0;
        for(int i = 0;i < tracks.size() ;i++){
            Track temp = tracks.get(i);
               cost += temp.getLength();
        }
        return cost;
    }
    @Override
    public void play() throws PlayerException  {
        if(this.getLength() > 0){
             java.util.Iterator iter = tracks.iterator();
             Track nextTrack;
             while(iter.hasNext()){
                nextTrack = (Track)iter.next();
                try{
                     nextTrack.play();
                }catch(PlayerException e){
                   throw e;
                }
             }
        }else{
            throw new PlayerException("ERORR: CD length is non-positive");
        }
    }
    


}