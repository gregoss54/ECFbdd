package fr.greg.ecfbdd.Entities;

public class Groupe {
    private int id;
    private String nomGroupe;

    public Groupe(int id, String nomGroupe) {
        this.id = id;
        this.nomGroupe = nomGroupe;
    }

    public Groupe (String nomGroupe)  {

        this.nomGroupe = nomGroupe;
    }

    public Groupe() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}
