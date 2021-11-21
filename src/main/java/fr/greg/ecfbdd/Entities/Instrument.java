package fr.greg.ecfbdd.Entities;

public class Instrument {
        private int id;
        private String nomInstrument;


        public Instrument(int id, String nomInstrument) {
            this.id = id;
            this.nomInstrument = nomInstrument;

        }
        public Instrument (String nomInstrument) {
            this.nomInstrument = nomInstrument;

        }
        public Instrument () {

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomInstrument() {
        return nomInstrument;
    }

    public void setNomInstrument(String nomInstrument) {
        this.nomInstrument = nomInstrument;
    }
}
