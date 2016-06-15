package login;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/*Custom exception showing alert box for incorrect username or password entered too many times*/

public class maxLoginException extends Exception {

	private static final long serialVersionUID = 872212115108067263L;

	public maxLoginException() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "You entered an incorrect username or password too many times!",
				ButtonType.OK);
		alert.showAndWait();
		System.exit(1);
	}
}
