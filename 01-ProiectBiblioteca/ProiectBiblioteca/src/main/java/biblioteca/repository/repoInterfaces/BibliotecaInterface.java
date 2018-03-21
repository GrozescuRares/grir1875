package biblioteca.repository.repoInterfaces;


import biblioteca.model.Carte;

import java.util.List;

public interface BibliotecaInterface {
	void adaugaCarte(Carte c);
	void modificaCarte(Carte nou, Carte vechie);
	void stergeCarte(Carte c);
	List<Carte> cautaCarte(String ref);
	List<Carte> getCarti();
	List<Carte> getCartiOrdonateDinAnul(String an);
}
