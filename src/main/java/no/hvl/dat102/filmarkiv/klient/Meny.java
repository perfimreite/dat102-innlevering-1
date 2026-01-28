package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        this.tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
        Film f1 = new Film(1, "Paramount", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures");
        Film f2 = new Film(2, "Lucasfilm", "Star Wars", 1977, Sjanger.SCIFI, "20th Century Fox");
        Film f3 = new Film(3, "Universal", "Jaws", 1975, Sjanger.THRILLER, "Universal Pictures");
        Film f4 = new Film(4, "Disney", "The Lion King", 1994, Sjanger.ANIMATION, "Walt Disney");
        Film f5 = new Film(5, "Warner Bros", "The Matrix", 1999, Sjanger.ACTION, "Warner Bros");

        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        filmarkiv.leggTilFilm(f4);
        filmarkiv.leggTilFilm(f5);

        Scanner s = new Scanner(System.in);
        String choice = "";
        boolean quit = false;

        while (!quit) {
            System.out.println("What do you want do in the film archive?");
            System.out.println("Quit                (q)");
            System.out.println("Find film           (1)");
            System.out.println("Search for title    (2)");
            System.out.println("Search for producer (3)");
            System.out.println("Get total count     (4)");
            System.out.print("-> : ");

            choice = s.nextLine();

            switch (choice) {
                case "q": {
                    quit = true;
                    System.out.println("Closing application...");
                    break;
                }
                case "1": {
                    System.out.print("Number: ");
                    int nr = s.nextInt();
                    s.nextLine();

                    Film film = filmarkiv.finnFilm(nr);
                    System.out.println("Film: " + film.getTittel());
                    break;
                }
                case "2": {
                    System.out.print("Title (or part of title): ");
                    String delstreng = s.nextLine();

                    Film[] filmer = filmarkiv.soekTittel(delstreng);
                    System.out.println("Matches: ");
                    for (Film film : filmer) {
                        System.out.println("  " + film.getTittel());
                    }
                    System.out.println();
                    break;
                }
                case "3": {
                    System.out.print("Producer (or part of producer name): ");
                    String delstreng = s.nextLine();

                    Film[] filmer = filmarkiv.soekProdusent(delstreng);
                    System.out.println("Matches: ");
                    for (Film film : filmer) {
                        System.out.println("  " + film.getTittel() + ": " + film.getProdusent());
                    }
                    System.out.println();
                    break;
                }
                case "4": {
                    System.out.println("Amount of films stored: " + filmarkiv.antall());
                    break;
                }
            }
        }
    }
}