package fr.greg.ecfbdd.Entities;

public class Rencontre {
private int id;
private String nomRencontre;

    public Rencontre(int id, String nomRencontre) {
        this.id = id;
        this.nomRencontre = nomRencontre;
    }

    public Rencontre (String nomRencontre)  {

        this.nomRencontre = nomRencontre;
    }

    public Rencontre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRencontre() {
        return nomRencontre;
    }

    public void setNomRencontre(String nomRencontre) {
        this.nomRencontre = nomRencontre;
    }
}
