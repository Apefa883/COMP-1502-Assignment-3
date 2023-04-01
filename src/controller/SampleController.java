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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;
import view.AppMenu;

public class SampleController implements Initializable {
	
	ArrayList<Toy> Inventory = new ArrayList<Toy>();
	AppMenu AppMen;
	private final String FILE_PATH = "res/toys.txt";
	public boolean flag;
	
    @FXML
    private ListView<Toy> listView;
    
    @FXML
    private ToggleGroup SearchOption;
    
    @FXML
    private Button btnBuy, btnClear, btnSave;

    @FXML
    private RadioButton btnName, btnSN, btnType; // Search Radio Buttons

    @FXML
    private Button btnRemove, btnSearch;

    @FXML
    private ComboBox<String> categoryBox;

    @FXML
    private TextField enterType, enterSNRemove, enterSN, enterName; // Search Text Fields.

    @FXML
    private TextField newMaterial, newMaxPlayers, newMinPlayers, newName, newPrice, newSN, newSize, newType, newDesigners, newCount, newClassification, newBrand,
    newAge; // Add Toy Text Fields

    Toy currentSelection;
    
    ObservableList<String> categoryList = FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "Board Game");
    
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
		
		categoryBox.setValue("Figure");
		categoryBox.setItems(categoryList);
		
	}
	
    @FXML
    public void removeToy(ActionEvent e) {
    	int selectedID = listView.getSelectionModel().getSelectedIndex();
    	listView.getItems().remove(selectedID);
    }
    
    @FXML
    public void search(ActionEvent e) {
    	listView.getItems().clear();
    	if (btnType.isSelected()) {
    		listView.getItems().addAll(btnSearch(enterType.getText(),Inventory));
    	}
    	if (btnName.isSelected()) {
        	listView.getItems().addAll(btnSearch(enterName.getText(),Inventory));
        }
    	if (btnSN.isSelected()) {
        	listView.getItems().addAll(btnSearch(enterSN.getText(),Inventory));
        }
    }
    
    @FXML
    public void clear(ActionEvent e) {
    	listView.getItems().clear();
    }
    
    
	private List<Toy> btnSearch(String searchWords, ArrayList<Toy> listOfStrings) {
		
		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
		
        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.getName().toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
	}
	
	@FXML
	public void save(ActionEvent e) {
		
		StringBuilder sb = new StringBuilder();
		
		categoryBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Figure")) {
        		sb.append(newSN.getText().toString() + ";" + newClassification.getText().toString() + ";" + newName.getText().toString() + ";" + 
        				newBrand.getText().toString() + ";" + newPrice.getText().toString() + ";" + newCount.getText().toString() + ";" 
        				+ newAge.getText().toString());
            }
        		else if (newValue.equals("Animal")) {
            		sb.append(newSN.getText().toString() + ";" + newMaterial.getText().toString() + ";" + 
            				newSize.getText().toString() + ";" + newName.getText().toString() + ";" + 
            				newBrand.getText().toString() + ";" + newPrice.getText().toString() + ";" + newCount.getText().toString() 
            				+ ";" + newAge.getText().toString());
            }
        		else if (newValue.equals("Puzzle")) {
            		sb.append(newSN.getText().toString() + ";" + newType.getText().toString() + ";" + newName.getText().toString() + ";" + 
            				newBrand.getText().toString() + ";" + newPrice.getText().toString() + ";" + newCount.getText().toString() 
            				+ ";" + newAge.getText().toString());
            }
        		else if (newValue.equals("Board Game")) {
            		sb.append(newSN.getText().toString() + ";" + newMaterial.getText().toString() + ";" + 
            				newMinPlayers.getText().toString() + ";" + newMaxPlayers.getText().toString() + ";" + newName.getText().toString() + 
            				newBrand.getText().toString() + ";" + newPrice.getText().toString() + ";" + newCount.getText().toString() 
            				+ ";" + newAge.getText().toString());
            }
        });
		
		File file = new File(FILE_PATH);
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
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
}
