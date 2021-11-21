package fr.greg.ecfbdd;

import fr.greg.ecfbdd.Entities.Groupe;
import fr.greg.ecfbdd.Entities.Membre;
import fr.greg.ecfbdd.Entities.Rencontre;
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
    private TableColumn<?, ?> Meet2Clmn;

    @FXML
    private TableColumn<?, ?> Meet3Clmn;

    @FXML
    private TableColumn<?, ?> Meet4Clmn;

    @FXML
    private TableView<Rencontre> MeetClmn;

    @FXML
    private TableView<Membre> MemberList;

    @FXML
    private TableColumn<Membre, String> NameClmn;

    @FXML
    private Button SearchTitle;

    @FXML
    private TableColumn<?, ?> TitleClmn;

    @FXML
    private ComboBox<?> boxAddress;

    @FXML
    private ComboBox<?> boxCountry;

    @FXML
    private ComboBox<?> boxGroup;

    @FXML
    private ComboBox<?> boxInstrument;

    @FXML
    private ComboBox<String> boxMeet;

    @FXML
    private ComboBox<String> boxMeetGroup;

    @FXML
    private TextField boxNbGroup;

    @FXML
    private ComboBox<String> boxSpeciality;

    @FXML
    private TextField boxTime;

    @FXML
    private ComboBox<String> boxTitle;

    @FXML
    private ComboBox<String> boxTitleGroup;

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


    // Méthodes de remplissages de la 1e comboBox
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

    //Remplissage de la 2e comboBox
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

        //Remplissage de la 3e comboBox
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
    //Remplissage de la 4e comboBox
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
//Remplissage de la 5e comboBox
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

//ObsList 1ere interro
@FXML
private ObservableList<Groupe> RemplissageTViewGroupName(ActionEvent event) throws SQLException {

        String res = boxTitleGroup.getValue();
        nomGroupeList.clear();

    DataBaseController dataBaseController = new DataBaseController();
    Connection connection = dataBaseController.getConnection();
    String query = "call DENOMINATION_GROUPE(?)";
    CallableStatement cs = connection.prepareCall(query);

    cs.setString (1, res);
    cs.execute();
    try{
        ResultSet rs = cs.getResultSet();
        while (rs.next()) {
            Groupe groupe = new Groupe();
            groupe.setNomGroupe(rs.getString("nomGroupe"));
            nomGroupeList.add(groupe);
        }
    }catch (Exception e) {
        e.printStackTrace();
        System.out.println("ERREUR DANS LA REQUETE nomGroupe");
    }
    connection.close();
    return nomGroupeList;
}//Affichage 1ere interrogation

    public void AffichageGroupName() {
        GrpNameClmn.setCellValueFactory(new PropertyValueFactory<Groupe, String>("nomGroupe"));
        GroupName.setItems(nomGroupeList);
    }
//ObsList 2e interro
    @FXML
    private ObservableList<Rencontre> RemplissageTViewMeetByTitleAndGroup(ActionEvent event) throws SQLException {

        String res = boxTitle.getValue();
        String res2 = boxMeetGroup.getValue();
        nomRencontreList.clear();

        DataBaseController dataBaseController = new DataBaseController();
        Connection connection = dataBaseController.getConnection();
        String query = "call NOM_RENCONTRE(?, ?)";
        CallableStatement cs = connection.prepareCall(query);

        cs.setString(1,res);
        cs.setString(2, res2);
        cs.execute();
        try{
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Rencontre rencontre = new Rencontre();
                rencontre.setNomRencontre(rs.getString("Rencontre"));
                nomRencontreList.add(rencontre);
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE nomRencontre");
        }
        connection.close();
        return nomRencontreList;
    }

//Affichage 2e interrogation
    public void  AffichageMeetByTitleAndGroup() {
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

    cs.setString(1,res);
    cs.setString(2, res2);
    cs.execute();
    try{
        ResultSet rs = cs.getResultSet();
        while (rs.next()) {
            Membre membre = new Membre();
            membre.setNomMembre(rs.getString("NOM_MEMBRE"));
            membre.setPrenomMembre(rs.getString ("PRENOM_MEMBRE"));
            MembreList.add(membre);
        }
    }catch (Exception e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
