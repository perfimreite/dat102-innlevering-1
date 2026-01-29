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

        System.out.println("Producer: ");
        String produsent = s.nextLine();

        System.out.println("Title: ");
        String tittel = s.nextLine();

        System.out.println("Year: ");
        int aar = s.nextInt();
        s.nextLine();

        System.out.println("Genre: ");
        Sjanger sjanger = Sjanger.valueOf(s.nextLine());

        System.out.println("Company: ");
        String selskap = s.nextLine();

        Film film = new Film(filmnr, produsent, tittel, aar, sjanger, selskap);
        return film;
    }

    public void skrivUtFilm(Film film) {
        System.out.println(film.toString());
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);

        System.out.println("Films with `" + delstreng + "` in title: ");
        for (Film film : filmer) {
            System.out.println(film.getTittel());
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);

        System.out.println("Films with producer `" + delstreng + "`: ");
        for (Film film : filmer) {
            System.out.println(film.getProdusent() + ": " + film.getTittel());
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        int antallFilmer = arkiv.antall();
        System.out.println("Amount of films: " + antallFilmer);

        for (Sjanger sjanger : Sjanger.values()) {
            int antallFilmerMedSjanger = arkiv.antall();
            System.out.println("Amount of films with genre " + sjanger.name() + ": " + antallFilmer);
        }
    }
}
