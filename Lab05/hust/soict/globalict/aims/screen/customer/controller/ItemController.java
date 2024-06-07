package Lab05.hust.soict.globalict.aims.screen.customer.controller;

import Lab05.hust.soict.globalict.aims.cart.Cart;
import Lab05.hust.soict.globalict.aims.exception.PlayerException;
import Lab05.hust.soict.globalict.aims.media.CompactDisc;
import Lab05.hust.soict.globalict.aims.media.DigitalVideoDisc;
import Lab05.hust.soict.globalict.aims.media.Media;
import Lab05.hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
          this.cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
         if(media instanceof DigitalVideoDisc){
            ((DigitalVideoDisc)media).play();
         }
         if(media instanceof CompactDisc){
            ((CompactDisc)media).play();
         }
    }
    public ItemController(Cart cart){
        this.cart = cart;
    }
    public void setData(Media media){
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+" $");
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        }else{
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart,new Insets(0,0,0,60));
        }
    }

}
