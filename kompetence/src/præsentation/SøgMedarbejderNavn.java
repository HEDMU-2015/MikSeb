package præsentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SøgMedarbejderNavn {

	public SøgMedarbejderNavn(Startside ss) {
		Stage myStage = new Stage();
		myStage.setTitle("Søg medarbejdernavn");

		GridPane design = new GridPane();
		design.setPadding(new Insets(15));
		design.setHgap(5);
		design.setVgap(5);
		design.setAlignment(Pos.CENTER);

		Scene myScene = new Scene(design, 550, 200);

		final Label overskrift = new Label("Søg medarbejder via navn eller email");
		overskrift.setFont(new Font("Arial", 20));
		design.add(overskrift, 1, 0);

		Label navn = new Label("Navn:");
		design.add(navn, 0, 2);

		TextField userTextField1 = new TextField();
		design.add(userTextField1, 1, 2);

		Label email = new Label("E-mail");
		design.add(email, 0, 3);

		TextField userTextField2 = new TextField();
		design.add(userTextField2, 1, 3);
		
		Button btn6 = new Button("Søg efter medarbejder");
		design.add(btn6, 0, 5);
		
		btn6.setOnAction(e -> new FundneMedarbejderViaNavn(null, null));

		myStage.setScene(myScene);
		myStage.show();
	}

};