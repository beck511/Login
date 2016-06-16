package login;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javafx.application.Application;
//import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.body.MainBodyStart;

/*Login page and launch of next class (MainBodyStart) is handled here. This class contains a main method as it is launched first.
 * Custom exceptions are thrown for incorrect password or too many tries.*/

public class Login extends Application {
	private int i = 0;
	static Logger log = Logger.getLogger(Login.class.getName());

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Security Check");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
		Scene scene = new Scene(grid, 500, 275);
		primaryStage.setScene(scene);
		Text sceneTitle = new Text("Welcome User");
		sceneTitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);

		javafx.scene.control.Label userName = new javafx.scene.control.Label("User Name : ");
		grid.add(userName, 0, 1);

		TextField userTField = new TextField();
		grid.add(userTField, 1, 1);

		javafx.scene.control.Label pw = new javafx.scene.control.Label("Password : ");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		Button btn = new Button("Log in");
		Button signBtn = new Button("Sign Up");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		HBox hbSignBtn = new HBox(10);
		hbSignBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbSignBtn.getChildren().add(signBtn);
		grid.add(hbSignBtn, 0, 4);

		btn.setOnAction(e -> {
			Strings strings = new Strings();
			try {

				if (userTField.getText().contentEquals(strings.getuName()) && pwBox.getText().contentEquals(strings.getpWord())) {
					log.info("User "+userTField.getText()+" logged in succesfully at "+ ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS));
					primaryStage.close();
					new MainBodyStart();

				} else {
					if (i <= 2) {
						log.info("User "+userTField.getText()+" Failed to login at "+ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS));
						i++;
						throw new loginException();
					} else {
						log.info("Maximum number of login attempts were made at "+ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS));
						throw new maxLoginException();
					}

				}
			} catch (Exception e1) {

			}

		});

		primaryStage.show();
		//Platform.setImplicitExit(false);
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		launch(args);
	}

}