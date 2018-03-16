/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */

package it.polito.tdp.parole;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {

	Parole elenco = new Parole();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtPerformances"
    private TextArea txtPerformances; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCancella(ActionEvent event) {
    	if (txtResult.getSelectedText().equals("")) {
    		txtPerformances.clear();
    		txtPerformances.setText("Seleziona una parola!");
    	}
    	else {
    		String selezionata = txtResult.getSelectedText();
    		double start = System.nanoTime();
    		elenco.removeParola(selezionata);
    		double stop = System.nanoTime();
    		
    		txtResult.clear();
    		String result = "";
    		for (String s : elenco.getElenco())
    			result += s + "\n";
    		txtResult.setText(result);
    		
    		txtPerformances.clear();
        	txtPerformances.setText("[REMOVE]" + (stop - start) + "seconds");
    	}
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	elenco.addParola( txtParola.getText());
    	double stop = System.nanoTime();
    	
    	txtResult.clear();
    	String result = "";
    	for (String s : elenco.getElenco())
    		result += s + "\n";
    	txtResult.setText(result);
    	
    	txtPerformances.clear();
    	txtPerformances.setText("[INSERT]" + (stop - start) + "seconds");
    	
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	txtPerformances.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtPerformances != null : "fx:id=\"txtPerformances\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";

    }
}
