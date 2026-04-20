package hust.soict.hedspi.aims.screen.customer.controller;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

public class ItemController {
	
	private Media media;
	private Cart cart;
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceedMediaException, ExistedMediaException {
    	cart.addMedia(media);
    }

	@FXML
	void btnPlayClicked(ActionEvent event) {
		if(media instanceof Playable) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Playing "+media.getTitle());
			alert.setHeaderText(null);
			alert.setContentText(media.toString());

			alert.showAndWait();
		}
	}
    
    public ItemController(Cart cart) {
    	this.cart=cart;
    }
    
    public void setData(Media media) {
    	this.media=media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost()+" $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
    	}
    	
    }

}
