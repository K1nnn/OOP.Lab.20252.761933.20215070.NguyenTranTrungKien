package hust.soict.hedspi.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton pen;
    
    @FXML
    private RadioButton eraser;
    
    @FXML
    private ToggleGroup toolRadio;
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color color=Color.BLACK;
    	if (this.toolRadio.getSelectedToggle().equals(eraser))
    		color=Color.WHITE;
    	Circle newCircle=new Circle(event.getX(), event.getY(), 4, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}
