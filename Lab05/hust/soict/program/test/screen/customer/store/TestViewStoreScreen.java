package Lab05.hust.soict.program.test.screen.customer.store;

import Lab05.hust.soict.globalict.aims.cart.Cart;
import Lab05.hust.soict.globalict.aims.media.Book;
import Lab05.hust.soict.globalict.aims.media.CompactDisc;
import Lab05.hust.soict.globalict.aims.media.DigitalVideoDisc;
import Lab05.hust.soict.globalict.aims.media.Media;
import Lab05.hust.soict.globalict.aims.media.Track;
import Lab05.hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import Lab05.hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


// Lab03\hust\soict\program\test\screen\customer\store\TestViewStoreScreen.java
public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String ITEM_FXML_FILE_PATH = "/Lab03/hust/soict/globalict/aims/screen/customer/view/Store.fxml";   
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(ITEM_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store,cart);
            fxmlloader.setController(viewStoreController);
            Parent root = fxmlloader.load();

            primaryStage.setTitle("Store");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
    }
    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        Book book = new Book(001,"The Valley of Fear", "Detective", 20.00f);
        book.addAuthor("Arthur Conan Doyle");
        Book book1 = new Book(002,"A Living Remedy: A Memoir", "Biography", 202.00f);
        book1.addAuthor("Nicole Chung");
        Book book2 = new Book(003,"On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        book2.addAuthor("Thomas Hertog");
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);
        CompactDisc cd1 = new CompactDisc(004,"30", "Music", 1500.98f,"Adele");
        Track track1CD1 = new Track("All Night Parking (interlude)", 161);
        Track track2CD1 = new Track("To Be Loved", 403);
        Track track3CD1 = new Track("Woman Like Me", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);
        CompactDisc cd2 = new CompactDisc(005,"The Gods We Can Touch", "Music", 2000.22f,"Aurora");
        Track track1CD2 = new Track("Everything Matters", 180+34);
        Track track2CD2 = new Track("Blood in the Wine", 180+30);
        Track track3CD2 = new Track("Artemis", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);
        CompactDisc cd3 = new CompactDisc(006,"Purpose", "Music", 1000.98f,"Justin Bieber");
        Track track1CD3 = new Track("The Feeling", 4*60+5);
        Track track2CD3 = new Track("No Sense", 4*60+35);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        cart.addMedia(cd3);
        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(dvd1);
        launch(args);
        
    }
}
