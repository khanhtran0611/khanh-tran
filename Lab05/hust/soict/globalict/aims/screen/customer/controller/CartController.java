package Lab05.hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import Lab05.hust.soict.globalict.aims.cart.Cart;
import Lab05.hust.soict.globalict.aims.exception.PlayerException;
import Lab05.hust.soict.globalict.aims.media.CompactDisc;
import Lab05.hust.soict.globalict.aims.media.DigitalVideoDisc;
import Lab05.hust.soict.globalict.aims.media.Media;
import Lab05.hust.soict.globalict.aims.media.Playable;
import Lab05.hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CartController {
    private Store store;
    private Cart cart;
    private Media media;
    public CartController(Store store,Cart cart){
        this.cart = cart;
        this.store = store;
    }
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn <Media, String>colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaID;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

        @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;


    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView< Media > tblMedia;
        @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {
         if(media instanceof DigitalVideoDisc){
            try {
                ((DigitalVideoDisc)media).play();
            } catch (PlayerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
         if(media instanceof CompactDisc){
            try {
                ((CompactDisc)media).play();
            } catch (PlayerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnVIewStorePressed(ActionEvent event) {
        try{
            final String STORE_FXML_FILE_PATH = "/Lab03/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader  fxmlloader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH)) ;
            fxmlloader.setController(new ViewStoreController(store,cart));
            Parent root = fxmlloader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
       } catch (IOException e){
          e.printStackTrace();
       }
    }
    public void initialize(){
        colMediaID.setCellValueFactory(new PropertyValueFactory<Media,Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
        if(cart.getCart().size() != 0){
            tblMedia.setItems(cart.getCart());
        }
        float cost = cart.totalCost();
        String cost_string = String.valueOf(cost);
        costLabel.setText(cost_string+" $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
          
        tblMedia.getSelectionModel().selectedItemProperty().addListener (new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue,Media newValue){
                updateButtonBar(newValue);
                media = (newValue);
                float cost = cart.totalCost();
                String cost_string = String.valueOf(cost);
                costLabel.setText(cost_string+" $");
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldStr, String newStr) {
                showFilteredMedia(newStr);
            }
        });
    }

    void updateButtonBar(Media media){
         if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
         }else{
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else{
                btnPlay.setVisible(false);
            }
         }
    }
    @FXML
    void playOrderButton(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        if (cart.getCart().isEmpty()){
            dialogPane.setContentText("Your cart is empty");
        }
        else {
            dialogPane.setContentText("An order has been created\n" + "You just spent " + costLabel.getText());
            cart.freeCart();;
            costLabel.setText(" 0 $");
        }
        dialogPane.setHeaderText("Placing Order");
        dialog.setDialogPane(dialogPane);
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }
    public void showFilteredMedia(String value){
        FilteredList<Media> filteredData = new FilteredList<>(cart.getCart(), b -> true);

        if (value == null || value.isEmpty()) {
            filteredData.setPredicate(media -> true);
        } else {
            if (radioBtnFilterId.isSelected()) {
                filteredData.setPredicate(media -> String.valueOf(media.getId()).contains(value));
            } else if (radioBtnFilterTitle.isSelected()) {
                filteredData.setPredicate(media -> media.getTitle().toLowerCase().contains(value.toLowerCase()));
            }
        }

        tblMedia.setItems(filteredData);
    }

}
