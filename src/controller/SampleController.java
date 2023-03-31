package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;
import view.AppMenu;

public class SampleController implements Initializable {
	
	ArrayList<Toy> ogInventory = new ArrayList<Toy>();
	
    @FXML
    private ListView<Toy> Inventory;

    @FXML
    private Button btnBuy, btnClear;

    @FXML
    private RadioButton btnName, btnSN, btnType; // Search Radio Buttons

    @FXML
    private Button btnRemove, btnSearch;

    @FXML
    private ComboBox<?> categoryBox;

    @FXML
    private TextField enterType, enterSNRemove, enterSN, enterName; // Search Text Fields.

    @FXML
    private TextField newMaterial, newMaxPlayers, newMinPlayers, newName, newPrice, newSN, newSize, newType, newDesigners, newCount, newClassification, newBrand,
    newAge; // Add Toy Text Fields

    Toy currentSelection;
    
    @FXML
    public void removeToy(ActionEvent e) {
    	int selectedID = Inventory.getSelectionModel().getSelectedIndex();
    	Inventory.getItems().remove(selectedID);
    }
    
    
    
	@Override // Selected toy in the list.
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Inventory.getItems().addAll(ogInventory);
		
		Inventory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {

			@Override
			public void changed(ObservableValue<? extends Toy> arg0, Toy arg1, Toy arg2) {
				
				currentSelection = Inventory.getSelectionModel().getSelectedItem();
				
			}
			
		});
		
		
	}
    
}
