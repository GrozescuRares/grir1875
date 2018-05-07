package biblioteca.repository.repoMock;


import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.BibliotecaInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BibliotecaGoala implements BibliotecaInterface {

    private List<Carte> carti;

    public BibliotecaGoala(){
        carti = new ArrayList<Carte>();



    }

    @Override
    public void adaugaCarte(Carte c) {
        carti.add(c);
    }

    @Override
    public List<Carte> cautaCarte(String ref) {
        List<Carte> carti = getCarti();
        List<Carte> cartiGasite = new ArrayList<Carte>();
        int i=0;
        while (i<carti.size()){
            boolean flag = false;
            List<String> lref = carti.get(i).getAutori();
            int j = 0;
            while(j<lref.size()){
                if(lref.get(j).toLowerCase().contains(ref.toLowerCase())){
                    flag = true;
                    break;
                }
                j++;
            }
            if(flag == true){
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
        return cartiGasite;
    }

    @Override
    public List<Carte> getCarti() {
        return carti;
    }

    @Override
    public void modificaCarte(Carte nou, Carte vechi) {
        // TODO Auto-generated method stub

    }

    @Override
    public void stergeCarte(Carte c) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Carte> getCartiOrdonateDinAnul(String an) {
        List<Carte> lc = getCarti();
        List<Carte> lca = new ArrayList<Carte>();
        for(Carte c:lc){
            if(c.getAnAparitie().equals(an) == true){
                lca.add(c);
            }
        }

        Collections.sort(lca,new Comparator<Carte>(){

            @Override
            public int compare(Carte a, Carte b) {
                if(a.getTitlu().compareTo(b.getTitlu())==0){
                    return a.getAutori().get(0).compareTo(b.getAutori().get(0));
                }

                return a.getTitlu().compareTo(b.getTitlu());
            }

        });

        return lca;
    }

}
