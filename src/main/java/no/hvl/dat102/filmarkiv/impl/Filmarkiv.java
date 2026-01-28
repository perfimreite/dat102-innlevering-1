package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    public Film[] filmer;
    private int antall;
    private int plass;

    public Filmarkiv(int plass) {
        this.filmer = new Film[plass];
        this.antall = 0;
        this.plass = plass;
    }

    private void utvid() {
        plass *= 2;
        Film[] temp = new Film[plass];
        if (antall >= 0) System.arraycopy(filmer, 0, temp, 0, antall);
        filmer = temp;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            Film film = filmer[i];
            if (film.getFilmnr() == nr) {
                return film;
            }
        }

        return null;
    }

    @Override
    public void leggTilFilm(Film film) {
        if (plass == antall) utvid();

        filmer[antall++] = film;
    }

    @Override
    public boolean slettFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == nr) {
                antall--;

                filmer[i] = filmer[antall];
                filmer[antall] = null;

                return true;
            }
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] f = new Film[plass];
        int idx = 0;

        for (Film film : filmer) {
            if (film == null) break;
            if (film.getTittel().contains(delstreng)) {
                f[idx++] = film;
            }
        }

        Film[] ret = new Film[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] f = new Film[plass];
        int idx = 0;

        for (Film film : filmer) {
            if (film == null) break;
            if (film.getProdusent().contains(delstreng)) {
                f[idx++] = film;
            }
        }

        Film[] ret = new Film[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        Sjanger s1 = Sjanger.finnSjanger(sjanger.name());
        if (s1 == null) return count;

        for (Film film : filmer) {
            Sjanger s2 = Sjanger.finnSjanger(film.getSjanger().name());
            if (s1.equals(s2)) {
                count += 1;
            }
        }

        return count;
    }

    @Override
    public int antall() {
        return antall;
    }
}
