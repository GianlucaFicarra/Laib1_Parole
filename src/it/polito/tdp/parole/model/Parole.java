package it.polito.tdp.parole.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//HO LA CLASSE PAROLA DA POPOLARE 

public class Parole {
	
	//List<String> listaParole= new LinkedList<String>();
	List<String> listaParole= new ArrayList<String>();
	
	public Parole() {
	}

	public void addParola(String p) {
	   listaParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole, new ComparatoreAlfabetico());
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear(); //pulisco tutto
	}

	
	
	
}
