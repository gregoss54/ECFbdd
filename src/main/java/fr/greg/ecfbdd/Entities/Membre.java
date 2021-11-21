package fr.greg.ecfbdd.Entities;

public class Membre {
    private int id;
    private String nomMembre;
    private String prenomMembre;

    public Membre(int id, String nomMembre, String prenomMembre) {
        this.id = id;
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
    }
    public Membre (String nomMembre, String prenomMembre) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
    }
    public Membre() {

    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }
}
