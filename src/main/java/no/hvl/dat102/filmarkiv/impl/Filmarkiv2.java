package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

class LinearNode <T> {
    private T data;
    private LinearNode<T> neste;

    public LinearNode(T data, LinearNode<T> neste) {
        this.data = data;
        this.neste = neste;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}

public class Filmarkiv2 implements FilmarkivADT {
    private int antall = 0;
    private LinearNode<Film> start;

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> n = start;

        while (n != null) {
            Film film = (Film)n.getData();
            if (film.getFilmnr() == nr) {
                return film;
            }

            n = n.getNeste();
        }

        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm, null);
        antall += 1;

        if (start == null) {
            start = nyNode;
            return;
        }

        LinearNode<Film> n = start;
        while (n.getNeste() != null) {
            n = n.getNeste();
        }

        n.setNeste(nyNode);
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> n = start;

        while (n != null) {
            Film film = (Film) n.getNeste().getData();
            if (film.getFilmnr() == filmnr) {
                n.setNeste(n.getNeste().getNeste());
                return true;
            }

            n = n.getNeste();
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> n = start;
        Film[] f = new Film[antall];
        int idx = 0;

        while (n != null) {
            Film film = (Film) n.getData();
            if (film.getTittel().contains(delstreng)) {
                f[idx++] = film;
            }

            n = n.getNeste();
        }

        Film[] ret = new Film[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> n = start;
        Film[] f = new Film[antall];
        int idx = 0;

        while (n != null) {
            Film film = (Film)n.getData();
            if (film.getProdusent().contains(delstreng)) {
                f[idx++] = film;
            }

            n = n.getNeste();
        }

        Film[] ret = new Film[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> n = start;
        int count = 0;
        Sjanger s1 = Sjanger.finnSjanger(sjanger.name());
        if (s1 == null) return count;

        while (n != null) {
            Film film = (Film) n.getData();
            Sjanger s2 = Sjanger.finnSjanger(film.getSjanger().name());

            if (s1.equals(s2)) {
                count += 1;
            }

            n = n.getNeste();
        }

        return count;
    }

    @Override
    public int antall() {
        return antall;
    }
}