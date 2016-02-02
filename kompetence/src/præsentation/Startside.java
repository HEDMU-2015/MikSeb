package præsentation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Startside extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Kompetenceprogram");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text titel = new Text("Vælg funktion");
		titel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(titel, 0, 0, 2, 1);

		Button btn = new Button("Opret medarbejder");
		btn.setOnAction(e -> new OpretMedarbejder(null));

		Button btn1 = new Button("Tilføj overemne");

		Button btn2 = new Button("Tilføj kompetence");

		Button btn3 = new Button("Tilføj afdeling");

		Button btn4 = new Button("Søg efter medarbejder via kompetence");
		btn4.setOnAction(e -> new SøgMedarbejderkompetence(null));
		
		Button btn5 = new Button("Søg efter medarbejder via navn");
		btn5.setOnAction(e -> new SøgMedarbejderNavn(null));
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(btn, btn1, btn2, btn3, btn4, btn5);

		grid.add(vbox, 1, 2);

		Scene scene = new Scene(grid, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}