package no.hvl.dat102.filmarkiv.impl;


import java.util.Objects;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String selskap;

    public Film() {};

    public Film(int filmnr, String produsent, String tittel, int aar, Sjanger sjaner, String selskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = sjaner;
        this.selskap = selskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjaner(Sjanger sjaner) {
        this.sjanger = sjaner;
    }

    public String getSelskap() {
        return selskap;
    }

    public void setSelskap(String selskap) {
        this.selskap = selskap;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Film film = (Film) object;
        return filmnr == film.filmnr;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), filmnr);
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmnr=" + filmnr +
                ", produsent='" + produsent + '\'' +
                ", tittel='" + tittel + '\'' +
                ", aar=" + aar +
                ", sjanger=" + sjanger.name() +
                ", selskap='" + selskap + '\'' +
                '}';
    }
}