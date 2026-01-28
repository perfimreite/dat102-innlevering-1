package no.hvl.dat102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.dat102.filmarkiv.impl.Filmarkiv2;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

    public FilmarkivADT arkiv1 = new Filmarkiv(5);
    public FilmarkivADT arkiv2 = new Filmarkiv2();

    @Test
    void testAntallErNull() {
        assertEquals(0, arkiv1.antall());

        assertEquals(0, arkiv2.antall());
    }

    @Test
    void testLeggTilFilm() {
        Film f = new Film(1, "Paramount", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures");

        arkiv1.leggTilFilm(f);
        assertEquals(1, arkiv1.antall());

        arkiv2.leggTilFilm(f);
        assertEquals(1, arkiv2.antall());
    }

    @Test
    void testFinnFilmReturnererNull() {
        assertNull(arkiv1.finnFilm(99));

        assertNull(arkiv2.finnFilm(99));
    }

    @Test
    void testSlettFilmReturnererFalse() {
        assertFalse(arkiv1.slettFilm(99));

        assertFalse(arkiv2.slettFilm(99));
    }
}

