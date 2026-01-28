package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
    public Film lesFilm(){
        Scanner s = new Scanner(System.in);

        System.out.println("Filmnr: ");
        int filmnr = s.nextInt();
        s.nextLine();

        System.out.println("Produsent: ");
        String produsent = s.nextLine();

        System.out.println("Tittel: ");
        String tittel = s.nextLine();

        System.out.println("År: ");
        int aar = s.nextInt();
        s.nextLine();

        System.out.println("Sjanger: ");
        Sjanger sjanger = Sjanger.valueOf(s.nextLine());

        System.out.println("Selskap: ");
        String selskap = s.nextLine();

        Film film = new Film(filmnr, produsent, tittel, aar, sjanger, selskap);
        return film;
    }

    public void skrivUtFilm(Film film) {
        System.out.println(film.toString());
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);

        System.out.print("Antall filmer med " + delstreng + "i tittelen: ");
        for (Film film : filmer) {
            System.out.print(film.getTittel());
        }
        System.out.println();
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);

        System.out.print("Antall filmer med produsent " + delstreng + ": ");
        for (Film film : filmer) {
            System.out.print(film.getTittel());
        }
        System.out.println();
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        int antallFilmer = arkiv.antall();
        System.out.println("Antall filmer: " + antallFilmer);

        for (Sjanger sjanger : Sjanger.values()) {
            int antallFilmerMedSjanger = arkiv.antall();
            System.out.println("Antall filmer med sjanger " + sjanger.name() + ": " + antallFilmer);
        }
    }
}
