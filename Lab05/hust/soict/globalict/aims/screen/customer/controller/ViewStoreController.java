package Lab05.hust.soict.globalict.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

import Lab05.hust.soict.globalict.aims.cart.Cart;
import Lab05.hust.soict.globalict.aims.media.Media;
import Lab05.hust.soict.globalict.aims.screen.customer.controller.*;
import Lab05.hust.soict.globalict.aims.store.Store;

public class ViewStoreController {
    private Store store;
    private Cart cart;
 
    @FXML
    private GridPane gridPane;
   
    @FXML
    void btnViewCartPressed(ActionEvent event) {
       try{
            final String CART_FXML_FILE_PATH = "/Lab03/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader  fxmlloader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH)) ;
            fxmlloader.setController(new CartController(store,cart));
            Parent root = fxmlloader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
       } catch (IOException e){
          e.printStackTrace();
       }
    }
    public ViewStoreController(Store store,Cart cart){
        this.store = store;
        this.cart = cart;
    }
    public void initialize(){
        final String ITEM_FXML_FILE_PATH = "/Lab03/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int rows  = 1;
        for(int i = 0;i < store.getItemsInStore().size() ;i++){
          try{

            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
            ItemController itemController = new ItemController(cart);
            fxmlloader.setController(itemController);
            AnchorPane anchorPane = new AnchorPane();
            anchorPane = fxmlloader.load();
            itemController.setData((Media) store.getItemsInStore().get(i));
            if (column == 3){
                column = 0;
                rows += 1;
               }
               gridPane.add(anchorPane,column++,rows);
               
               GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
            } catch (IOException e){
                 e.printStackTrace();
            }
        }
    }

}
