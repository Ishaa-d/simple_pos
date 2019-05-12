package simple_pos;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class GUICashierController {
	@FXML
	private Button startSaleButton;
	
	@FXML
	public void initialize() {
		
	}
	
    @FXML
    private void EHStartSaleButton(ActionEvent event) {
    	
    	//https://code.makery.ch/blog/javafx-dialogs-official/
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("I have a great message for you!");

    	alert.showAndWait();
    	try {
			Main.grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("GUISale.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Main.setPane(2);
    }
}
