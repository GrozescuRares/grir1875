package biblioteca.model;


import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private String titlu;
	private List<String> autori;
	private String anAparitie;
	private List<String> cuvinteCheie;
	private String editura;
	
	public Carte(){
		titlu = "";
		//referenti
		autori = new ArrayList<String>();
		anAparitie = "";
		cuvinteCheie = new ArrayList<String>();
		editura = "";
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> ref) {
		this.autori = ref;
	}

	public String getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(String anAparitie) {
		this.anAparitie = anAparitie;
	}

	public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}

	public void setCuvinteCheie(List<String> cuvinteCheie) {
		this.cuvinteCheie = cuvinteCheie;
	}
	


	
	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}
	
	public void adaugaAutor(String ref){
		autori.add(ref);
	}
	

	
	@Override
	public String toString(){
		String ref = "";
		String cuvCheie = "";
		
		for(int i=0;i<autori.size();i++){
			if(i==autori.size()-1)
				ref+=autori.get(i);
			else
				ref+=autori.get(i)+",";
		}
		
		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}
		
		return titlu+";"+ref+";"+anAparitie+";"+ editura + ";" + cuvCheie;
	}
	
	public static Carte getCarteFromString(String carte){
		Carte c = new Carte();
		String []atr = carte.split(";");
		String []referenti = atr[1].split(",");
		String []cuvCheie = atr[4].split(",");
		
		c.titlu=atr[0];
		for(String s:referenti){
			c.adaugaAutor(s);
		}
		c.anAparitie = atr[2];
		for(String s:cuvCheie){
			c.adaugaCuvantCheie(s);
		}
		
		return c;
	}
	
}
