package app.exceptions;

import app.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MyExceptions extends Exception {
	
/**
 * create and show an error dialog when the exception is thrown
 * @param msg
 * @param main
 */
	public MyExceptions(String msg,Main main) {
		
		Alert alert =  new Alert(AlertType.ERROR);
		
		alert.initOwner(main.getPrimaryStage());
        alert.setTitle("Erreur!!");
        alert.setHeaderText("Erreur dans l'insertion des données");
        alert.setContentText(msg);

        alert.showAndWait();
		
	}

}
