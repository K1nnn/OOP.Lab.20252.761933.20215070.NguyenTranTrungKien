package hust.soict.hedspi.aims.exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PlayerException extends Exception {

	public PlayerException() {
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();		
	}

	public PlayerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
