package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;
import view.AppMenu;

public class SampleController implements Initializable {
	
	ObservableList<Toy> Inventory = FXCollections.observableArrayList();
	ObservableList<Toy> SearchResults = FXCollections.observableArrayList();
	AppMenu AppMen;
	private final String FILE_PATH = "res/toys.txt";
	public boolean flag;
	
    @FXML
    private Pane animaloptionpanel;

    @FXML
    private Pane boardgameoptionpanel;
    
    @FXML
    private Pane puzzleoptionpanel;
    
    @FXML
    private Pane figureoptionpanel;
	
    @FXML
    private ListView<Toy> listView;
    
    @FXML
    private ToggleGroup SearchOption;
    
    @FXML
    private Label SearchPrompt;
    
    @FXML
    private Button btnBuy, btnClear, btnSave;

    @FXML
    private RadioButton btnName, btnSN, btnType; // Search Radio Buttons

    @FXML
    private Button btnRemove, btnSearch;

    @FXML
    private ComboBox<String> categoryBox, newSize, newClassification, newType;

    @FXML
    private TextField enterSNRemove, enterSearchTerm; // Search Text Fields.

    @FXML
    private TextField newMaterial, newMaxPlayers, newMinPlayers, newName, newPrice, newSN, newDesigners, newCount, newBrand,
    newAge; // Add Toy Text Fields

    Toy currentSelection;
    

    @FXML
    private ListView<Toy> searchListView;
    
    ObservableList<String> categoryList = FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "Board Game");
    ObservableList<String> sizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
    ObservableList<String> figureList = FXCollections.observableArrayList("Action", "Doll", "Historic");
    ObservableList<String> puzzleTypeList = FXCollections.observableArrayList("Mechanical", "Cryptic", "Logic", "Trivia", "Riddle");
	/**
	 * Constructor, which launches the application and loads up all data
	 */
	public SampleController() {
		//Creates arraylist (loaded in other function)
		loadData();
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listView.getItems().addAll(Inventory);
		searchListView.getItems().addAll(Inventory);
		categoryBox.setValue("Figure");
		categoryBox.setItems(categoryList);
		
		newSize.setValue("Small");
		newSize.setItems(sizeList);
		
		newClassification.setValue("Action");
		newClassification.setItems(figureList);
		
		newType.setValue("Mechanical");
		newType.setItems(puzzleTypeList);
	}
	
    @FXML
    public void removeToy(ActionEvent e) {
    	listView.getItems().clear();
    	if(SearchSerial(enterSNRemove.getText()) != -1) {
    		Inventory.remove(SearchSerial(enterSNRemove.getText()));
    	}
    	listView.getItems().addAll(Inventory);
    }
    
    @FXML
    public void search(ActionEvent e) {
    	//Type Search
    	if (btnType.isSelected()) {
    		if(enterSearchTerm.getText().length() > 0) {
    			searchListByType(enterSearchTerm.getText().toLowerCase());
    			searchListView.getItems().clear();
    			searchListView.getItems().addAll(SearchResults);
    		}
    	}
    	//Name Search
    	if (btnName.isSelected()) {
    		if(enterSearchTerm.getText().length() > 0) {
    			searchListByName(enterSearchTerm.getText().toLowerCase());
    			searchListView.getItems().clear();
    			searchListView.getItems().addAll(SearchResults);
    		}
        }
    	//Serial Search
    	if (btnSN.isSelected()) {
    		if(enterSearchTerm.getText().length() == 10) {
    			searchListBySerial(enterSearchTerm.getText());
    			searchListView.getItems().clear();
    			searchListView.getItems().addAll(SearchResults);
    		} else {
    			System.out.println("Bad serial!");
    		}
        }
    }
    
    @FXML
    public void clear(ActionEvent e) {
    	searchListView.getItems().clear();
    	searchListView.getItems().addAll(Inventory);
    }
    
	
	@FXML
	public void save(ActionEvent e) {
		
		System.out.println("Sussy baka");
	}
	
	/**
	 * Loads all data contained in the toys.txt file.
	 */
	@FXML
	private void loadData() {
		File warehouse = new File(FILE_PATH);
		String currentLine;
		String[] parsedLine;
		
		if (warehouse.exists()) {
			try {
				Scanner fileReader = new Scanner(warehouse);
				while (fileReader.hasNextLine()) {
					currentLine = fileReader.nextLine();
					if (Character.getNumericValue(currentLine.charAt(0)) < 2) {
						parsedLine = currentLine.split(";");
						figure newToy = new figure(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 4) {
						
						parsedLine = currentLine.split(";");
						animal newToy = new animal(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6],parsedLine[7].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 7) {
						parsedLine = currentLine.split(";");
						puzzle newToy = new puzzle(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else {
						parsedLine = currentLine.split(";");
						boardgame newToy = new boardgame(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6],parsedLine[7]);
						Inventory.add(newToy);
					}
				}
				fileReader.close();
			} catch(FileNotFoundException e) {
				System.out.println("ERROR: ARCHIVE FILE NOT FOUND!");
			}
		}
	}
	
	
    /**
     * Sets the text in the serial removal space to the selected item.
     * @param event
     */
    @FXML
    void RemovalSelected(MouseEvent event) {
    	enterSNRemove.setText(listView.getSelectionModel().getSelectedItem().getSerial());
    }
    
    /**
     * Searches the inventory for a matching serial
     * @param inputserial the serial to find
     * @return returns the spot in inventory of the matching item.
     */
    public int SearchSerial(String inputserial) {
    	int spot = -1;
    	
    	for(int i = 0; i < Inventory.size(); i++) {
    		if(Inventory.get(i).getSerial().matches(inputserial)) {
    			spot = i;
    		}
    	}
    	return spot;
    }
    
    /**
     * Populates the searchlist with serials matching the provided value. 
     */
    public void searchListBySerial(String serialToFind) {
    	SearchResults.clear();
    	if(SearchSerial(serialToFind) != -1) {
    		SearchResults.add(Inventory.get(SearchSerial(serialToFind)));
    	}
    }
    
    
    /**
     * Seaches for all items in the inventory that match the provided name
     * @param nameToFind the given name
     */
    public void searchListByName(String nameToFind) {
    	SearchResults.clear();
    	for(int i = 0; i < Inventory.size(); i++) {
    		if(Inventory.get(i).getName().toLowerCase().contains(nameToFind)) {
    			SearchResults.add(Inventory.get(i));
    		}
    	}
    }
    
    
    /**
     * Handles searches by type.
     * Clears the searchresult list, then adds all items it can find.
     * @param typeToFind
     */
    public void searchListByType(String typeToFind) {
    	SearchResults.clear();
    	
    	/*
    	 * Each if statement contains a loop that iterates through the inventory.
    	 * If the item at a given index is of the desired type, it is added to the SearchResults arraylist
    	 * Searchresults will eventually be shown to the user. 
    	 */
    	if(typeToFind.contains("animal")) {
    		for(int i = 0; i < Inventory.size(); i++) {
    			if(Inventory.get(i) instanceof animal) {
    				SearchResults.add(Inventory.get(i));
    			}
    		}
    	} else if(typeToFind.contains("boardgame")) {
    		for(int i = 0; i < Inventory.size(); i++) {
    			if(Inventory.get(i) instanceof animal) {
    				SearchResults.add(Inventory.get(i));
    			}
    		}
    	} else if(typeToFind.contains("figure")) {
    		for(int i = 0; i < Inventory.size(); i++) {
    			if(Inventory.get(i) instanceof figure) {
    				SearchResults.add(Inventory.get(i));
    			}
    		}
    	} else if(typeToFind.contains("puzzle")) {
    		for(int i = 0; i < Inventory.size(); i++) {
    			if(Inventory.get(i) instanceof puzzle) {
    				SearchResults.add(Inventory.get(i));
    			}
    		}
    	}
    }
    
    /**
     * Buys the selected product.
     * @param event
     */
    @FXML
    void buyThis(ActionEvent event) {
    	if(searchListView.getSelectionModel().getSelectedItem() != null) { //If the user selects something:
    		String chosenSerial = searchListView.getSelectionModel().getSelectedItem().getSerial(); //Grabs user selection.
    		Inventory.get(SearchSerial(chosenSerial)).sellToy(1); //Finds a serial matching the selection in inventory.
    		//If in search mode, it displays the search results. Otherwise, displays everything.
    		if(SearchResults.size() > 0) {
    			searchListView.getItems().clear();
    			searchListView.getItems().addAll(SearchResults);
    		} else {
    			searchListView.getItems().clear();
    			searchListView.getItems().addAll(Inventory);
    		}
    	}
    }
    
    
    
    @FXML
    void PickedName(ActionEvent event) {
    	SearchPrompt.setText("Product Name:");
    }

    @FXML
    void PickedSerial(ActionEvent event) {
    	SearchPrompt.setText("Serial Number (SN):");
    }

    @FXML
    void PickedType(ActionEvent event) {
    	SearchPrompt.setText("Product Type:");
    }
    
    
    /**
     * Handles which subwindow to display in the Add Toy tab, depending on whether a figure, animal, puzzle or
     * boardgame has been selected.
     * @param event
     */
    @FXML
    void SelectCategory(ActionEvent event) {
    	if(categoryBox.getValue().matches("Figure")) {
    		figureoptionpanel.setVisible(true);
    		animaloptionpanel.setVisible(false);
    		puzzleoptionpanel.setVisible(false);
    		boardgameoptionpanel.setVisible(false);
    	} else if(categoryBox.getValue().matches("Animal")) {
    		figureoptionpanel.setVisible(false);
    		animaloptionpanel.setVisible(true);
    		puzzleoptionpanel.setVisible(false);
    		boardgameoptionpanel.setVisible(false);
    	} else if(categoryBox.getValue().matches("Puzzle")) {
    		figureoptionpanel.setVisible(false);
    		animaloptionpanel.setVisible(false);
    		puzzleoptionpanel.setVisible(true);
    		boardgameoptionpanel.setVisible(false);
    	} else if(categoryBox.getValue().matches("Board Game")) {
    		figureoptionpanel.setVisible(false);
    		animaloptionpanel.setVisible(false);
    		puzzleoptionpanel.setVisible(false);
    		boardgameoptionpanel.setVisible(true);
    	}
    }
    

}
