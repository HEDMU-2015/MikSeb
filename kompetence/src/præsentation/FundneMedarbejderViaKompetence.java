package præsentation;

// Indeholder innerclass med Wrapper

import præsentation.SøgMedarbejderkompetence;

import java.util.List;

import domain.Medarbejder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FundneMedarbejderViaKompetence {

	public TableView<MedarbejderWrapper> table = new TableView<MedarbejderWrapper>();
	public final ObservableList<MedarbejderWrapper> data = FXCollections
			.observableArrayList();
	final HBox hb = new HBox();

	public FundneMedarbejderViaKompetence(SøgMedarbejderkompetence sb, List<Medarbejder> medarbejdere) {
		Stage stage = new Stage();
		
		for(Medarbejder m : medarbejdere) {
			MedarbejderWrapper mw = new MedarbejderWrapper(m.getNavn(), m.getEmail());
			data.add(mw);
		}

		Scene scene = new Scene(new Group());
		stage.setTitle("Fundne medarbejdere");
		stage.setWidth(400);
		stage.setHeight(550);

		final Label label = new Label("Fundne medarbejdere");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn lastNameCol = new TableColumn("Navn");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("navn"));

		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(200);
		emailCol.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("email"));

		table.setItems(data);
		table.getColumns().addAll(lastNameCol, emailCol);

		hb.setSpacing(3);
		
		final Label info = new Label("Hvis en medarbejder optræder flere gange i tabellen,");
		info.setFont(new Font("Arial", 12));
		
		final Label info2 = new Label(" har vedkommende samtlige/flere af de valgte kompetencer!");
		info.setFont(new Font("Arial", 12));
		
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, hb, info, info2);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

	public static class MedarbejderWrapper {

		private final SimpleStringProperty navn;
		private final SimpleStringProperty email;

		MedarbejderWrapper(String navn, String email) {

			this.navn = new SimpleStringProperty(navn);
			this.email = new SimpleStringProperty(email);
		}

		public String getNavn() {
			return navn.get();
		}

		public void setNavn(String fName) {
			navn.set(fName);
		}

		public String getEmail() {
			return email.get();
		}

		public void setEmail(String fName) {
			email.set(fName);
		}

	}
}