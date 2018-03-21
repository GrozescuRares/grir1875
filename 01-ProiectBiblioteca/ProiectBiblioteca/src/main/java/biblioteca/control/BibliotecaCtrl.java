package biblioteca.control;


import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.BibliotecaInterface;
import biblioteca.util.Validator;

import java.util.List;

public class BibliotecaCtrl {

	private BibliotecaInterface cr;
	
	public BibliotecaCtrl(BibliotecaInterface cr){
		this.cr = cr;
	}
	
	public void adaugaCarte(Carte c) throws Exception{
		Validator.validateCarte(c);
		cr.adaugaCarte(c);
	}
	
	public void modificaCarte(Carte nou, Carte vechi) throws Exception{
		cr.modificaCarte(nou, vechi);
	}
	
	public void stergeCarte(Carte c) throws Exception{
		cr.stergeCarte(c);
	}

	public List<Carte> cautaCarte(String autor) throws Exception{
		Validator.isStringOK(autor);
		return cr.cautaCarte(autor);
	}
	
	public List<Carte> getCarti() throws Exception{
		return cr.getCarti();
	}
	
	public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
		if(!Validator.isNumber(an))
			throw new Exception("Nu e numar!");
		return cr.getCartiOrdonateDinAnul(an);
	}
	
	
}
