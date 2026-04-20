package hust.soict.hedspi.aims.exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LimitExceedMediaException extends Exception {

	public LimitExceedMediaException() {
		// TODO Auto-generated constructor stub
	}

	public LimitExceedMediaException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();	
	}

	public LimitExceedMediaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public LimitExceedMediaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LimitExceedMediaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
