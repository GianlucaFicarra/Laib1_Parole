package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatoreAlfabetico implements Comparator<String> {


	@Override
	public int compare(String p1, String p2) {
		
		return p1.compareTo(p2);
	}

}
