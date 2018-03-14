package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */
//LAVORO CON LA CLASSE PAROLA

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnCancella;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    
    
    
    
    @FXML
    void doInsert(ActionEvent event) { //all'evento scateno un azione
    	long iniziale = System.nanoTime();
    	String parola=txtParola.getText();  //salvo la parola del txtField che avevo salvato nel txtParola
    	elenco.addParola(parola);
   		
    	//devo stampare l'elenco delle mie parole nel txtArea che vuole stringa
    	//converto l'elenco in una stringa e la stampo
    	String msg="";
    	for(String i: elenco.getElenco()) {
    		msg+=i+"\n";
    	}
    	txtResult.setText(msg);
    	txtParola.setText("");
    	
    	long end = System.nanoTime();
    	long durata = end-iniziale;
    	txtTime.appendText("Tempo per inserire la parola "+durata+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	//resetto l'elenco delle mie parole e l'elenco delle parole da stampare
    	elenco.reset();
    	txtResult.setText("");
    }  
    
    @FXML
    void doCancella(ActionEvent event) {
    	long iniziale = System.nanoTime();
    	
    	//eliminare dalla struttura dati solamente la parola selezionata nell’area di testo
    	String parola=txtResult.getSelectedText(); //salvo la parola selezionata
    	elenco.getElenco().remove(parola);
    	
    	String msg="";
    	for(String i: elenco.getElenco()) {
    		msg+=i+"\n";
    	}
    	txtResult.setText(msg);   	
    	
    	long end = System.nanoTime();
    	long durata = end-iniziale;
    	txtTime.appendText("Tempo per cancellare la parola"+" "+durata+"\n");
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
      
        elenco = new Parole() ;
        
    }
}
