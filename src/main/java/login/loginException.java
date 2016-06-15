package login;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/*Custom exception showing alert box for incorrect username or password*/

public class loginException extends Exception {
	
	private static final long serialVersionUID = 1106456201060663154L;

	public loginException() {

		Alert alert = new Alert(AlertType.CONFIRMATION, "You entered an incorrect username or password!",
				ButtonType.OK);
		alert.showAndWait();

	}

}
