package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.BibliotecaGoala;
import biblioteca.repository.repoMock.BibliotecaMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 4/19/2018.
 */
public class BibliotecaWBT {

    private BibliotecaGoala rep;

    @Before
    public void setUp() throws Exception {

        rep = new BibliotecaGoala();

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void TC1_WBT () throws Exception {
        setUp();
        assertTrue(this.rep.cautaCarte("Mihai").size() == 0);
    }

    @Test
    public void TC2_WBT () throws Exception{
        setUp();
        rep.adaugaCarte(Carte.getCarteFromString("Povesti;;1973;Corint;povesti,povestiri"));
        assertTrue(rep.cautaCarte("Mihai").size() == 0);
    }

    @Test
    public void TC4_WBT () throws Exception{
        setUp();
        rep.adaugaCarte(Carte.getCarteFromString("Povesti;Andrei;1973;Corint;povesti,povestiri"));
        assertTrue(rep.cautaCarte("Mihai").size() == 0);
    }

    @Test
    public void TC6_WBT () throws Exception{
        setUp();
        rep.adaugaCarte(Carte.getCarteFromString("Povesti;Mihai;1973;Corint;povesti,povestiri"));
        assertTrue(rep.cautaCarte("Mihai").size() == 1);
    }
}
