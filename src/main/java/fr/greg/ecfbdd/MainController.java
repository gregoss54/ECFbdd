package fr.greg.ecfbdd;

import fr.greg.ecfbdd.Entities.Groupe;
import fr.greg.ecfbdd.Entities.Membre;
import fr.greg.ecfbdd.Entities.Rencontre;
import fr.greg.ecfbdd.Entities.Titre;
import fr.greg.ecfbdd.utils.DataBaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableColumn<?, ?> DateClmn;

    @FXML
    private TableColumn<Membre, String> FirstNameClmn;

    @FXML
    private TableView<Groupe> GroupName;
    @FXML
    private TableColumn<Groupe, String> GrpNameClmn;

    @FXML
    private TableColumn<?, ?> HourEndClmn;

    @FXML
    private TableColumn<?, ?> HourStartClmn;

    @FXML
    private TableColumn<Rencontre, String> Meet;
    @FXML
    private TableView<Rencontre> Meet3;
    @FXML
    private TableColumn<?, ?> Meet2Clmn;

    @FXML
    private TableColumn<Rencontre, String> Meet3Clmn;

    @FXML
    private TableColumn<?, ?> Meet4Clmn;

    @FXML
    private TableView<Rencontre> MeetClmn;

    @FXML
    private TableView<Membre> MemberList;

    @FXML
    private TableColumn<Membre, String> NameClmn;

    @FXML
    private TableColumn<Titre, String> TitleClmn;

    @FXML
    private ComboBox<String> boxAddress;

    @FXML
    private ComboBox<String> boxCountry;

    @FXML
    private ComboBox<String> boxGroup;

    @FXML
    private ComboBox<String> boxInstrument;

    @FXML
    private ComboBox<String> boxMeet;

    @FXML
    private ComboBox<String> boxMeetGroup;

    @FXML
    private TextField TFNbGroup;

    @FXML
    private ComboBox<String> boxSpeciality;

    @FXML
    private TextField TFTime;

    @FXML
    private ComboBox<String> boxTitle;

    @FXML
    private ComboBox<String> boxTitleGroup;

    @FXML
    private Button SearchTitle;
    @FXML
    private Button searchGroup;

    @FXML
    private Button searchMeet;

    @FXML
    private Button searchMeetInstru;

    @FXML
    private Button searchMeetNbGroup;

    @FXML
    private Button searchProgamAddressGroup;

    @FXML
    private Button searchUser;

    ObservableList<Groupe> nomGroupeList = FXCollections.observableArrayList();
    ObservableList<Rencontre> nomRencontreList = FXCollections.observableArrayList();
    ObservableList<Membre> MembreList = FXCollections.observableArrayList();
    ObservableList<Titre> TitreList = FXCollections.observableArrayList();
    ObservableList<Rencontre> nomRencontre2List = FXCollections.observableArrayList();
    ObservableList<Rencontre> Planning = FXCollections.observableArrayList();

    // PREMIERE INTERROGATION

    // Méthodes de remplissage de la 1e comboBox
    private void RemplissageComboBoxTitre1() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageTitre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_titre"));
            }
            boxTitleGroup.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE");
        }
    }
    //DEUXIEME INTERROGATION

    //Remplissage de la 1e comboBox
    private void RemplissageComboBoxTitre2() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageTitre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_titre"));
            }
            boxTitle.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageTitre");
        }
    }

    //Remplissage de la 2e comboBox
    private void RemplissageComboBoxGroup() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageGroupe";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("DENOMINATION_GROUPE"));
            }
            boxMeetGroup.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageGroupe");
        }
    }
    //TROISIEME INTERROGATION

    //Remplissage de la 1e comboBox
    private void RemplissageComboBoxSpeciality() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageSpec";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_specialite"));
            }
            boxSpeciality.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageSpecialite");
        }
    }

    //Remplissage de la 2e comboBox
    private void RemplissageComboBoxMeet() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageRencontre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_rencontre"));
            }
            boxMeet.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageRencontre");
        }
    }

    //OBSERVABLES LISTES
//ObsList 1ere interro
    @FXML
    private ObservableList<Groupe> RemplissageTViewGroupName(ActionEvent event) throws SQLException {

        String res = boxTitleGroup.getValue();
        nomGroupeList.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call DENOMINATION_GROUPE(?)";
        CallableStatement cs = connection.prepareCall(query);

        cs.setString(1, res);
        cs.execute();
        try {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Groupe groupe = new Groupe();
                groupe.setNomGroupe(rs.getString("nomGroupe"));
                nomGroupeList.add(groupe);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nomGroupe");
        }
        connection.close();
        return nomGroupeList;


        //AFFICHAGES DISPLAY TABLE VIEW
    }//Affichage 1ere interrogation

    public void AffichageGroupName() {
        GrpNameClmn.setCellValueFactory(new PropertyValueFactory<Groupe, String>("nomGroupe"));
        GroupName.setItems(nomGroupeList);
    }


    //ObsList 2e interrogation
    @FXML
    private ObservableList<Rencontre> RemplissageTViewMeetByTitleAndGroup(ActionEvent event) throws SQLException {

        String res = boxTitle.getValue();
        String res2 = boxMeetGroup.getValue();
        nomRencontreList.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call NOM_RENCONTRE(?, ?)";
        CallableStatement cs = connection.prepareCall(query);

        cs.setString(1, res);
        cs.setString(2, res2);
        cs.execute();
        try {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Rencontre rencontre = new Rencontre();
                rencontre.setNomRencontre(rs.getString("Rencontre"));
                nomRencontreList.add(rencontre);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nomRencontre");
        }
        connection.close();
        return nomRencontreList;
    }

    //Affichage 2e interrogation
    public void AffichageMeetByTitleAndGroup() {
        Meet.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("nomRencontre"));
        MeetClmn.setItems(nomRencontreList);
    }

    //ObsList 3e interro
    @FXML
    private ObservableList<Membre> RemplissageMembreParRencontreSpecialite() throws SQLException {

        String res = boxSpeciality.getValue();
        String res2 = boxMeet.getValue();
        MembreList.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call NOM_MEMBRE(?, ?)";
        CallableStatement cs = connection.prepareCall(query);

        cs.setString(1, res);
        cs.setString(2, res2);
        cs.execute();
        try {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Membre membre = new Membre();
                membre.setNomMembre(rs.getString("NOM_MEMBRE"));
                membre.setPrenomMembre(rs.getString("PRENOM_MEMBRE"));
                MembreList.add(membre);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nomMembre");
        }
        connection.close();
        return MembreList;
    }

    public void AffichageMemberByMeetAndSpeciality() {
        FirstNameClmn.setCellValueFactory(new PropertyValueFactory<Membre, String>("prenomMembre"));
        NameClmn.setCellValueFactory(new PropertyValueFactory<Membre, String>("nomMembre"));
        MemberList.setItems(MembreList);

    }
    //4e Interrogation
    //Remplissage TextField Duree et comboBox Pays

    /*public void RemplissageTFTime() {
        ObservableList<Time> list = TFTime();
        TFTime.setCellValueFactory(new PropertyValueFactory<Time, Integer>)

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

    }

     */

    private void RemplissageComboPays() {
        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichagePays";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_pays"));
            }
            boxCountry.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nom_pays");
        }
    }


//ObsList 4e interrogation
    // @FXML
    //private void ObservableList<Titre>RemplissageParDureePays(ActionEvent event) throws SQLException(

    private void RemplissageComboInstruments() {
        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageInstru";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_instrument"));
            }
            boxInstrument.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nom_instrument");
        }
    }

    //Obslist 6e interrogation
    @FXML
    ObservableList<Rencontre> RemplissageRencontreParInstrument() throws SQLException {

        String res = boxInstrument.getValue();
        nomRencontre2List.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call RENCONTRE_INSTRUMENTS(?)";
        CallableStatement cs = connection.prepareCall(query);

        cs.setString(1, res);
        cs.execute();
        try {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Rencontre rencontre = new Rencontre();
                rencontre.setNomRencontre(rs.getString("NOM_RENCONTRE"));
                nomRencontre2List.add(rencontre);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nomRencontre");
        }
        connection.close();
        return nomRencontre2List;
    }

    private void AffichageRencontreParInstrument() {
        Meet3Clmn.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("nomRencontre"));
        Meet3.setItems(nomRencontre2List);
    }

    private void RemplissageComboLieuRencontre() {
        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageLieuRencontre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("lieu_rencontre"));
            }
            boxAddress.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nom_lieu_rencontre");
        }
    }

    private void RemplissageComboGroup() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();

        String query = "call affichageGroupe";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("DENOMINATION_GROUPE"));
            }
            boxGroup.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageGroupe");
        }
    }
//Affichage de la 7e interrogation

    @FXML
    void AffichagePlanning() throws SQLException {

        String res = boxInstrument.getValue();
        Planning.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call Planning(?)";
        CallableStatement cs = connection.prepareCall(query);

    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            RemplissageComboBoxTitre1();
            AffichageGroupName();
            RemplissageComboBoxTitre2();
            RemplissageComboBoxGroup();
            AffichageMeetByTitleAndGroup();
            RemplissageComboBoxSpeciality();
            RemplissageComboBoxMeet();
            RemplissageMembreParRencontreSpecialite();
            AffichageMemberByMeetAndSpeciality();
            RemplissageComboPays();
            RemplissageComboInstruments();
            RemplissageComboLieuRencontre();
            RemplissageComboGroup();
            RemplissageRencontreParInstrument();
            AffichageRencontreParInstrument();
            AffichagePlanning();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
