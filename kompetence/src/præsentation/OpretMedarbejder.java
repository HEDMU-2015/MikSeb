package præsentation;

import præsentation.Startside;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OpretMedarbejder {

	public OpretMedarbejder(Startside ss) {
		Stage myStage = new Stage();
		myStage.setTitle("Opret medarbejder");

		GridPane design = new GridPane();
		design.setPadding(new Insets(15));
		design.setHgap(5);
		design.setVgap(5);
		design.setAlignment(Pos.CENTER);

		Scene myScene = new Scene(design, 500, 400);

		ColumnConstraints kolonne1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints kolonne2 = new ColumnConstraints(50);
		ColumnConstraints kolonne3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		kolonne1.setHgrow(Priority.ALWAYS);
		kolonne3.setHgrow(Priority.ALWAYS);
		design.getColumnConstraints().addAll(kolonne1, kolonne2, kolonne3);

		final Label overskrift = new Label("Opret medarbejder");
		overskrift.setFont(new Font("Arial", 20));
		design.add(overskrift, 0, 0);

		Label navn = new Label("Navn:");
		design.add(navn, 0, 2);

		TextField userTextField1 = new TextField();
		design.add(userTextField1, 2, 2);

		Label email = new Label("E-mail");
		design.add(email, 0, 3);

		TextField userTextField2 = new TextField();
		design.add(userTextField2, 2, 3);

		Label afdeling = new Label("Afdeling");
		design.add(afdeling, 0, 4);

		TextField tekstfelt = new TextField();
		design.add(tekstfelt, 2, 4);

		Label kompetence = new Label("Kompetencer");
		GridPane.setHalignment(kompetence, HPos.CENTER);
		design.add(kompetence, 0, 5);

		Label valgtliste = new Label("Valgte kompetencer");
		design.add(valgtliste, 2, 5);
		GridPane.setHalignment(valgtliste, HPos.CENTER);

		Button gemknap = new Button("Gem medarbejder");
		design.add(gemknap, 0, 7);

		final ObservableList<String> candidates = FXCollections.observableArrayList("Udvikling C#", "Udvikling JAVA",
				"Macroer VBA", "Fokusgrupper", "Dybdeinterview", "Regressions-analyse", "Statistik",
				"Rapport-skrivning");
		final ListView<String> candidatesListView = new ListView<>(candidates);
		design.add(candidatesListView, 0, 6);

		final ObservableList<String> selected = FXCollections.observableArrayList();
		final ListView<String> heroListView = new ListView<>(selected);
		design.add(heroListView, 2, 6);

		Button sendtilhøjre = new Button(" -> ");
		sendtilhøjre.setOnAction((ActionEvent event) -> {
			String potential = candidatesListView.getSelectionModel().getSelectedItem();
			if (potential != null) {
				candidatesListView.getSelectionModel().clearSelection();
				candidates.remove(potential);
				selected.add(potential);
			}
		});

		Button sendtilvenstre = new Button(" <- ");
		sendtilvenstre.setOnAction((ActionEvent event) -> {
			String s = heroListView.getSelectionModel().getSelectedItem();
			if (s != null) {
				heroListView.getSelectionModel().clearSelection();
				selected.remove(s);
				candidates.add(s);
			}
		});
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(sendtilhøjre, sendtilvenstre);

		design.add(vbox, 1, 6);

		myStage.setScene(myScene);
		myStage.show();
	}

};
