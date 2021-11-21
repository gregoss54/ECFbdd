package fr.greg.ecfbdd.Entities;

public class Titre {

        private int id;
        private String nomTitre;


        public Titre(int id, String nomPays) {
            this.id = id;
            this.nomTitre = nomPays;

        }
        public Titre(String nomPays) {
            this.nomTitre = nomPays;

        }
        public Titre() {

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(String nomTitre) {
        this.nomTitre = nomTitre;
    }
}
