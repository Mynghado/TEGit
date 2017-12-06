package application;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableauDeBordEntrepriseControlleur {
	// ************************** DEBUT DES ATTRIBUTS **************************

	// ----------- TABLE VIEW EN BAS A GAUCHE-------------------
	@FXML
	private TableView<OffreStage> offreStage;

	@FXML
	private TableColumn<OffreStage, String> offrePostee_libelle;
	@FXML
	private TableColumn<OffreStage, String> offrePostee_dateDebut;
	// -------------- FIN TABLEVIEW EN BAS A GAUCHE
	// --------------------------------

	// ----------- TABLE VIEW EN HAUT A DROITE-------------------
	@FXML
	private TableView<OffrePostulee> offreStagePostulee;

	@FXML
	private TableColumn<OffrePostulee, String> offrePostulee_nom;
	@FXML
	private TableColumn<OffrePostulee, String> offrePostulee_prenom;
	@FXML
	private TableColumn<OffrePostulee, String> offrePostulee_libelle;
	// -------------- FIN TABLEVIEW EN EN HAUT A DROITE

	// ----------- TABLE VIEW EN BAS A DROITE-------------------
	@FXML
	private TableView<OffrePostulee> offreStagePostulee_Accepte;

	@FXML
	private TableColumn<OffrePostulee, String> offreStagePostulee_Accepte_nom;
	@FXML
	private TableColumn<OffrePostulee, String> offreStagePostulee_Accepte_prenom;
	@FXML
	private TableColumn<OffrePostulee, String> offreStagePostulee_Accepte_libelle;
	// -------------- FIN TABLEVIEW EN BAS A DROITE
	// --------------------------------

	@FXML
	private Button retourAccueil;
	@FXML
	private Button supprimerOffre;
	@FXML
	private Button accepterCandidat;
	@FXML
	private Button deconnexion;

	@FXML
	private Text nomDeL_Entreprise;
	@FXML
	private Text rue;
	@FXML
	private Text CP;
	@FXML
	private Text ville;
	@FXML
	private Text mail;
	@FXML
	private Text noTel;

	private ObservableList<OffreStage> offreEntreprise;
	private ObservableList<OffrePostulee> offreAcceptee;
	private ObservableList<OffrePostulee> offrePostulee;

	// ************************** FIN DES ATTRIBUTS **************************

	public TableauDeBordEntrepriseControlleur() {
		// LE CONSTRUCTEUR DU CONTROLLEUR DOIT ETRE VIDE
	}

	@FXML
	public void initialize() {
		offreEntreprise = FXCollections.observableArrayList(); // d�finition des donn�es
		offreAcceptee = FXCollections.observableArrayList(); // d�finition des donn�es
		offrePostulee = FXCollections.observableArrayList(); // d�finition des donn�es
		
		Main.gst.importOffre();
		Main.gst.importEnt();
		Main.gst.importOffresPostulees();
		triOffres();

		System.out.println(offreAcceptee.size());
		// param�tre -> le nom de l'attribut - il doit y avoir un "nomVariableProperty"
		// EN BAS A GAUCHE
		offrePostee_libelle.setCellValueFactory(new PropertyValueFactory<>("libl"));
		offrePostee_dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));

		// EN HAUT A DROITE
		offrePostulee_nom.setCellValueFactory(new PropertyValueFactory<>("nomEtudiant"));
		offrePostulee_prenom.setCellValueFactory(new PropertyValueFactory<>("prenomEtudiant"));
		offrePostulee_libelle.setCellValueFactory(new PropertyValueFactory<>("libl"));

		// EN BAS A DROITE
		offreStagePostulee_Accepte_nom.setCellValueFactory(new PropertyValueFactory<>("nomEtudiant"));
		offreStagePostulee_Accepte_prenom.setCellValueFactory(new PropertyValueFactory<>("prenomEtudiant"));
		offreStagePostulee_Accepte_libelle.setCellValueFactory(new PropertyValueFactory<>("libl"));
		
		offreStage.setItems(null);
		offreStage.setItems(offreEntreprise);

		offreStagePostulee.setItems(null);
		offreStagePostulee.setItems(offrePostulee);
		
		offreStagePostulee_Accepte.setItems(null);
		offreStagePostulee_Accepte.setItems(offreAcceptee);
		
		// EN HAUT A GAUCHE
		// INITIALISE LES INFORMATIONS DE L'ENTREPRISE CONNECT�E
		for (Entreprise e : Main.listeEntreprise) {
			if (e.getIDEntreprise().equals(Main.gst.getId())) {
				nomDeL_Entreprise.setText(e.getNomEnt());
				rue.setText(e.getRue());
				CP.setText(e.getCodePostal());
				ville.setText(e.getVille());
				mail.setText(e.getMail());
				noTel.setText(e.getNumTel());
			}
		}
	}

	// RETOUR � L'ACCUEIL
	@FXML
	public void clicRetourAcceuil(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage primaryStage = new Stage();

			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("Acceuil.fxml"));

			// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
			BorderPane rootLayout = (BorderPane) loader.load();

			// LA SCENE CONTIENDRA NOTRE PANE RACINE
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// RETOUR � L'ACCUEIL & D�CONNEXION
	@FXML
	public void clicDeconnexion(ActionEvent event) {
		Main.gst.deconnexion();
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage primaryStage = new Stage();

			// CR�E UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("Acceuil.fxml"));

			// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
			BorderPane rootLayout = (BorderPane) loader.load();

			// LA SCENE CONTIENDRA NOTRE PANE RACINE
			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ACTION CLIC SUPPRIMER OFFRE
	@FXML
	public void clicSupprimerOffre(ActionEvent event) {
		Alert alert = new Alert(AlertType.ERROR);
		// ON CREE UNE VARIABLE POUR L'INDEX
		int i = offreStage.getSelectionModel().getSelectedIndex();

		// SI L'ENTREPRISE EST DANS LA LISTE
		if (i >= 0) {
			// 1 - RECUPERATION DE L'ID DE L'ENTREPRISE ET SUPPRESSION DANS LA
			// BDD
			Main.gst.supprOffre(offreEntreprise.get(i).getIDOffreStage());

			// 3 - REIMPORTATION DE LA LISTE DEPUIS LA BDD
			Main.gst.importOffre();
			triOffres();

			// 4 - APPLIQUER LA "NOUVELLE" LISTE OBSERVABLE AU TABLE VIEW
			offreStage.setItems(offreEntreprise);
		}
		// MESSAGE D'ERREUR SI L'UTILISATEUR N'A PAS SELECTIONNE D'ENTREPRISE
		else {
			alert.setTitle("Attention !");
			alert.setHeaderText("Vous n'avez pas selectionn� d'offre de stage");
			alert.setContentText("Cliquez sur une offre de stage pour la supprimer");
			alert.showAndWait();
		}
	}

	// ACTION CLIC ACCEPTER �TUDIANT
	@FXML
	public void clicAccepterCandidat(ActionEvent event) {
		Alert alert = new Alert(AlertType.ERROR);
		// ON CREE UNE VARIABLE POUR L'INDEX
		int i = offreStagePostulee.getSelectionModel().getSelectedIndex();
		if (i >= 0) {
			Main.gst.accepterOffre(offrePostulee.get(i).getIDOffreStage(), offrePostulee.get(i).getIDEtudiant());
			
			Main.gst.importOffresPostulees();
			triOffres();
			offreStagePostulee.setItems(offrePostulee);
		}
		// MESSAGE D'ERREUR SI L'UTILISATEUR N'A PAS SELECTIONNE D'ENTREPRISE
		else {
			alert.setTitle("Attention !");
			alert.setHeaderText("Vous n'avez pas selectionn� de postulation");
			alert.setContentText("Cliquez sur une postulation pour l'accepter");
			alert.showAndWait();
		}
	}

	public void triOffres() {
		offreEntreprise.remove(0, offreEntreprise.size());
		offrePostulee.remove(0, offrePostulee.size());
		offreAcceptee.remove(0, offreAcceptee.size());

		for (OffreStage o : Main.listeOffre) {
			if (o.getIDEntreprise_fk().equals(Main.gst.getId())) {
				offreEntreprise.add(o);
			}
		}
		
		for(OffrePostulee o : Main.listeOffrePostulee) {
			if(o.getStatut().equals("1")){
				offreAcceptee.add(o);
			}
			else{
				offrePostulee.add(o);
			}
		}
	}
}