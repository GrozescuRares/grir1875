package biblioteca.util;

import biblioteca.model.Carte;

public class Validator {
	
	public static boolean isStringOK(String s) throws Exception{
		boolean flag = s.matches("[a-zA-Z]+");
		if(flag == false)
			throw new Exception("String invalid");
		return flag;
	}
	
	public static void validateCarte(Carte c)throws Exception{

		String message = "";
		if(c.getCuvinteCheie()==null){

			message += "Lista cuvinte cheie vida";
		}
		if(c.getCuvinteCheie().size() > 5){
			message += "\n Maxim 5 cuvinte cheie !";
		}

		if(c.getEditura().length() == 0 || c.getEditura().length() > 255){
			message += "\n Editura nu poate fi nula !";
		}


		if(c.getAutori()==null){
			message += "\n Lista autori vida!";
		}
		if(!isOKString(c.getTitlu()) || c.getTitlu().length() > 255 || c.getTitlu().length() == 0)
			message += "\n Titlu invalid!";
		for(String s:c.getAutori()){
			if(!isOKString(s))
				message += "\n " + s + " autor invalid!";
		}
		for(String s:c.getCuvinteCheie()){
			if(!isOKString(s))
				message += "\n " + c +  " cuvant cheie invalid!";
		}
		if(!Validator.isNumber(c.getAnAparitie())) {


			message +="\n An aparitie invalid!";
		}
		else{
			int an = Integer.parseInt(c.getAnAparitie());

			if(an < 0){
				message += "An aparitie mai mare decat 0";
			}
			if(an > 2018){
				message +="\n An aparitie trebuie sa fie mai mic decat an curent";
			}


		}

		if(message.length() > 0){
			throw new Exception(message);
		}


	}
	
	public static boolean isNumber(String s){
		return s.matches("[0-9]+");
	}
	
	public static boolean isOKString(String s){
		String []t = s.split(" ");
		if(t.length==2){
			boolean ok1 = t[0].matches("[a-zA-Z]+");
			boolean ok2 = t[1].matches("[a-zA-Z]+");
			if(ok1==ok2 && ok1==true){
				return true;
			}
			return false;
		}
		return s.matches("[a-zA-Z]+");
	}
	
}
