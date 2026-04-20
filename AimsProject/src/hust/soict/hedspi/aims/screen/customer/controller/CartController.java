package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

	private Cart cart;
	private Store store;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Label costLabel;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;
	
	@FXML
	private Button btnPlaceOrder;
	
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Place Order");
		alert.setHeaderText("Successful");
		alert.setContentText("You have created a place order");

		alert.showAndWait();
    }
    
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media =tblMedia.getSelectionModel().getSelectedItem();
		if(media instanceof Playable) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Playing "+media.getTitle());
			alert.setHeaderText(null);
			alert.setContentText(media.toString());

			alert.showAndWait();
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media =tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
        	final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        	fxmlLoader.setController(new ViewStoreController(store,cart));
        	Parent root = fxmlLoader.load();
        	Stage stage= (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Store");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
	
	public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}

	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemsOrdered()!=null){
			tblMedia.setItems(cart.getItemsOrdered());
		}
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		costLabel.setText(Float.toString(cart.totalCost()));
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});

	}
	
	void updateButtonBar(Media media) {
		if (media==null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			}
			else {
				btnPlay.setVisible(false);
			}
		}
	}

}
