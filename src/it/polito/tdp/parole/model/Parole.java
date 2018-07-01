package it.polito.tdp.parole.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//HO LA CLASSE PAROLA DA POPOLARE 

public class Parole {
	
	List<String> listaParole;
	
	public Parole() {
		listaParole= new ArrayList<String>();
		//lista = new LinkedList<String>();
	}

	public void addParola(String p) {
	   if(!listaParole.contains(p))
	   listaParole.add(p);
	}
	
	public List<String> getElenco() { //l'elenco di parole lo voglio in ordine alfabetico
		Collections.sort(listaParole, new ComparatoreAlfabetico());
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear(); //pulisco tutto
	}

	
	
	
}
