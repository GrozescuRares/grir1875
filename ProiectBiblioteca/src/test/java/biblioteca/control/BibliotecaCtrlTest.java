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
 * Created by User on 3/26/2018.
 */
public class BibliotecaCtrlTest {

    private Carte c;
    BibliotecaMock repo;
    BibliotecaCtrl ctrl;

    public Carte createCarte(String titlu, List<String> autori, String editura, String anAparitie, List<String> cuvinteCheie){
        Carte carte = new Carte();
        carte.setTitlu(titlu);
        carte.setAutori(autori);
        carte.setEditura(editura);
        carte.setAnAparitie(anAparitie);
        carte.setCuvinteCheie(cuvinteCheie);

        return carte;
    }

    @Before
    public void setUp() throws Exception {

        repo = new BibliotecaMock();
        ctrl = new BibliotecaCtrl(repo);

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void TC1_ECP() throws Exception {

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
    public void TC4_ECP() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "-1", cuvinte));
            assertTrue (false);
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }

    @Test
    public void TC2_ECP() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("", autori, "Editura", "1800", cuvinte));
            assertTrue (false);
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }

    @Test
    public void TC3_ECP() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Titlu", autori, "", "1800", cuvinte));
            assertTrue (false);
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }


    @Test
    public void TC5_ECP() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "fuhs123", cuvinte));
            assertTrue ("Nu ar fi trebuit sa treaca", false);
        }
        catch (Exception ex){
            assertTrue("ok",true);

        }
    }

    @Test
    public void TC7_BVA() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "0", cuvinte));
            assertTrue ("ok", true);
        }
        catch (Exception ex){
            assertTrue("Ar fi trebuit sa treaca",false);

        }
    }

    @Test
    public void TC8_BVA() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "1", cuvinte));
            assertTrue ("ok", true);
        }
        catch (Exception ex){
            assertTrue("Ar fi trebuit sa treaca",false);

        }
    }

    @Test
    public void TC9_BVA() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "-1", cuvinte));
            assertTrue ("-1 nu esta valid...", false);
        }
        catch (Exception ex){
            assertTrue("-1 nu este valid",true);

        }
    }

    @Test
    public void TC10_BVA() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("Test", autori, "Editura", "2019", cuvinte));
            assertTrue ("2019 nu esta valid...", false);
        }
        catch (Exception ex){
            assertTrue("2019 nu este valid",true);

        }
    }

    @Test
    public void TC4_BVA() throws Exception {

        setUp();
        List<String> autori = new ArrayList<String>();
        autori.add("Rares");
        List<String> cuvinte = new ArrayList<String>();
        cuvinte.add("Keyword");

        try {
            ctrl.adaugaCarte(createCarte("T", autori, "Editura", "2010", cuvinte));
            assertTrue ( true);
        }
        catch (Exception ex){
            assertTrue(false);

        }
    }

    @Test
    public void BB1() throws Exception {
        setUp();

        List<Carte> carti = ctrl.getCartiOrdonateDinAnul("1973");
        assertTrue(carti.size() == 2);
    }

    @Test
    public void BB2() throws Exception {
        setUp();

        try {
            List<Carte> carti = ctrl.getCartiOrdonateDinAnul("1973dds");
            assertTrue(false);
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }




}