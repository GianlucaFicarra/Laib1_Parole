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
	
	Parole elenco= new Parole() ;;

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

    
    
    //PUNTO 1
    
    @FXML
    void doInsert(ActionEvent event) { //all'evento scateno un azione
    	
    	//codice per l'inserimento:
    	long iniziale = System.nanoTime();
    	
    	String parola=txtParola.getText().toLowerCase();  //salvo la parola del txtField che avevo salvato nel txtParola
    	
    	int n=elenco.getElenco().size();
    	elenco.addParola(parola);           //richiamando il metodo add
    	int m=elenco.getElenco().size();
    	
   		long end = System.nanoTime();
   				
    	//codice per la stampare l'elenco delle mie parole nel txtArea che vuole stringa
    	//converto l'elenco (getElenco) in una stringa e la stampo
   		txtResult.clear();
    	String msg="";
    	for(String i: elenco.getElenco()) {
    		msg += i+"\n";
    	}
    	txtResult.setText(msg);
    	
    	if(n!=m) {//uso trucco con le dimensioni per valutare se sia stata inserita o meno la parola nel DB
    	long durata = end-iniziale;
    	txtTime.clear();
    	txtTime.appendText("Tempo per inserire la parola "+durata+"\n");
    	} else {
    		txtTime.clear();
    		txtTime.appendText("Hai inserito una parola già presente nella lista!");
    	}
    	txtParola.clear();
    }
    
    
    
    @FXML
    void doReset(ActionEvent event) {
    	//resetto l'elenco delle mie parole e l'elenco delle parole da stampare
    	
    	elenco.reset(); //metodo per resettare la lista parola implementato in parole
    	txtResult.clear();
    	txtTime.clear();
    	txtParola.clear();
    }  
    
    
    /*PUNTO 2
     il bottone Cancella, che permette di eliminare dalla
    struttura dati solamente la parola selezionata nell’area di testo*/
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	if(txtResult.getSelectedText().equals("")){//nel caso non selezioni nulla
    		txtTime.clear();
    		txtTime.setText("Seleziona una Parola!"); //avviso di errore
		}
		else{
			
	    	//eliminare dalla struttura dati solamente la parola selezionata nell’area di testo
	    	String parola=txtResult.getSelectedText(); //salvo la parola selezionata
	    	
	    	long iniziale = System.nanoTime();
	    	elenco.getElenco().remove(parola);//rimuovo dall'elenco solo ma parola evidenziata
	    	long end = System.nanoTime();
	    	
	    	txtResult.clear();//ristampo l'elenco aggiornato senza la parola eliminata
	    	String msg="";
	    	for(String i: elenco.getElenco()) {
	    		msg += i+"\n";
	    	}
	    	txtResult.setText(msg);   	
	    	
	    	
	    	long durata = end-iniziale;
	    	txtTime.clear();
	    	txtTime.appendText("Tempo per cancellare la parola"+" "+durata+"\n");
	    	//nuova area di testo per visualizzare i tempi di esecuzione di ciascuna operazione eseguita dal programma
			}
    	
		}
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
      
        
        
    }
}
