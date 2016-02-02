package præsentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Kompetence;
import domain.KompetenceImpl;
import domain.Medarbejder;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logik.Medarbejderkartotek;

public class SøgMedarbejderkompetence {

	private Medarbejderkartotek mk = new Medarbejderkartotek();

	public SøgMedarbejderkompetence(Startside ss) {
		Stage myStage = new Stage();
		myStage.setTitle("Søg efter medarbejder via kompetence");

		GridPane design = new GridPane();
		design.setPadding(new Insets(15));
		design.setHgap(5);
		design.setVgap(5);
		design.setAlignment(Pos.CENTER);

		Scene myScene = new Scene(design, 600, 350);

		ColumnConstraints kolonne1 = new ColumnConstraints(200, 150, Double.MAX_VALUE);
		ColumnConstraints kolonne2 = new ColumnConstraints(50);
		ColumnConstraints kolonne3 = new ColumnConstraints(200, 150, Double.MAX_VALUE);
		kolonne1.setHgrow(Priority.ALWAYS);
		kolonne3.setHgrow(Priority.ALWAYS);
		design.getColumnConstraints().addAll(kolonne1, kolonne2, kolonne3);

		final Label overskrift = new Label("Søg efter medarbejder");
		overskrift.setFont(new Font("Arial", 20));
		design.add(overskrift, 0, 0);
		
		final Label overskrift2 = new Label("Søg efter max tre kompetencer ad gangen!");
		overskrift.setFont(new Font("Arial", 15));
		design.add(overskrift2, 0, 1);


		Label kompetenceliste = new Label("Kompetencer");
		GridPane.setHalignment(kompetenceliste, HPos.CENTER);
		design.add(kompetenceliste, 0, 5);

		Label valgtliste = new Label("Valgte kompetencer");
		design.add(valgtliste, 2, 5);
		GridPane.setHalignment(valgtliste, HPos.CENTER);

		final ObservableList<String> candidates = FXCollections.observableArrayList("Udvikling C#", "Udvikling JAVA",
				"Macroer VBA", "Fokusgrupper", "Dybdeinterview", "Regressions-analyse", "Statistik",
				"Rapport-skrivning");
		final ListView<String> candidatesListView = new ListView<>(candidates);
		design.add(candidatesListView, 0, 6);

		final ObservableList<String> selected = FXCollections.observableArrayList();
		final ListView<String> heroListView = new ListView<>(selected);
		design.add(heroListView, 2, 6);
		
		Button soeg = new Button("Find medarbejder");
		design.add(soeg, 0, 7);
		soeg.setOnAction(e -> new FundneMedarbejderViaKompetence(null, findMedarbejdere(selected)));
		
		
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

	// Liste (selected) der indeholder de valgte medarbejdere
	
	private List<Medarbejder> findMedarbejdere(ObservableList<String> selected) {
		List<String> list = selected.stream().collect(Collectors.toList());
		List<Kompetence> kompetencer = new ArrayList<Kompetence>();
		for(String kompetencenavn : list){
			kompetencer.add(new KompetenceImpl(kompetencenavn));
		}
		return mk .findMedarbejdere("", "", kompetencer);
	}
};