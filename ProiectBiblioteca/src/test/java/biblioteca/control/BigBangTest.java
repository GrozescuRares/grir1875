package biblioteca.control;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.BibliotecaGoala;
import biblioteca.repository.repoMock.BibliotecaMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by User on 5/8/2018.
 */
public class BigBangTest {

    private BibliotecaMock rep;
    private BibliotecaCtrl ctrl;

    @Before
    public void setUp() throws Exception {

        rep = new BibliotecaMock();
        ctrl = new BibliotecaCtrl(rep);

    }

    @After
    public void tearDown() throws Exception {
    }

    public Carte createCarte(String titlu, List<String> autori, String editura, String anAparitie, List<String> cuvinteCheie){
        Carte carte = new Carte();
        carte.setTitlu(titlu);
        carte.setAutori(autori);
        carte.setEditura(editura);
        carte.setAnAparitie(anAparitie);
        carte.setCuvinteCheie(cuvinteCheie);

        return carte;
    }

    @Test

    public void testA () throws Exception {
        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "1800", cuvinte));
            assertTrue (true);
        }
        catch (Exception ex){
            assertTrue(false);
        }
    }

    @Test

    public void testB() throws Exception {
        setUp();
        assertTrue(ctrl.cautaCarte("Mihai").size() == 1);
    }

    @Test
    public  void testC() throws Exception {
        setUp();
        List<Carte> carti = ctrl.getCartiOrdonateDinAnul("1973");
        assertTrue(carti.size() == 2);
    }

    @Test
    public  void testPABC() throws Exception {
        setUp();

        //A
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "1800", cuvinte));
            assertTrue (true);
        }
        catch (Exception ex){
            assertTrue(false);
        }

        //B
        assertTrue(ctrl.cautaCarte("Rares").size() == 1);

        //C
        List<Carte> carti = ctrl.getCartiOrdonateDinAnul("1800");
        assertTrue(carti.size() == 1);

    }
}
