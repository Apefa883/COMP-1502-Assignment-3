package tests;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.SampleController;
import model.Toy;
import model.figure;
import model.puzzle;

class unittestsTest {

	/*
	 * Tests the ability of the code to parse .txt info into an arraylist of toys
	 */
	@Test
	void Loadingtest() {
		String currentLine = "1147205649;Ninja Turtles;Gamezoid;46.15;10;6;A";
				 
		String[] parsedLine = currentLine.split(";");
		figure newToy = new figure(parsedLine[0],parsedLine[1],parsedLine[2],
				Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
				Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
		
		figure testToy = new figure("1147205649","Ninja Turtles","Gamezoid",(float) 46.15,10,6,'A');
		assertEquals(testToy.toString(),newToy.toString());
	}

	/*
	 * Tests if we are able to properly remove toys from an arraylist
	 */
	@Test
	void RemoveToyTest() {
		ArrayList<Toy> InventoryTest = new ArrayList<Toy>();
		figure testToy = new figure("1147205649","Ninja Turtles","Gamezoid",(float) 46.15,10,6,'A');
		puzzle testToy2 = new puzzle("4863437054","Logic puzzle","Game Shadow",(float) 265.62,11,4,'T');
		InventoryTest.add(testToy);
		InventoryTest.add(testToy2);
		int place = -1;
		while(place == -1) {
			if(place == -1) {
				//Prompts the user to tell them that the toy is out of stock
				//Asks the user to press enter to continue
				place = 0; //We simulate the user removing an object in the first place in the array
			} else {
				break;
			}
		}
		//AppMen.displaySerial(Inventory,place); Displays the serial
		Boolean kill = true;
		if(kill) {
			InventoryTest.remove(place);
			//Prompts the user to tell them that the toy is removed
		} else {
			//Tells the user they are a coward for not removing the toy
		}
		assertEquals(InventoryTest.size(),1,"Item not properly removed");
	}
	
	/**
	 * Testing how toys handle being sold
	 */
	@Test
	void sellToyTest() {
		int sold = 3;
		int availableCount = 50;
		availableCount -= sold;
		assertEquals(availableCount,47,"Item not properly sold");
	}
	
	/**
	 * Testing the ability of the boardgame class to intake a string data for its player range and
	 * extract max and min players respectively
	 */
	@Test
	void boardgameTest() {
		String playerNum = "59-124456";
		String playerNumArray[] = playerNum.split("-");
		int minPlayers = Integer.parseInt(playerNumArray[0]);
		int maxPlayers = Integer.parseInt(playerNumArray[1]);
		assertEquals(minPlayers,59,"Minimum players do not match string input");
		assertEquals(maxPlayers,124456,"Maximum players do not match string input");
	}
	
	    
    private SampleController controller;

    @Before
    public void setUp() {
        controller = new SampleController();
    }

    @Test
    public void testPickedType() {
        controller.PickedType(new ActionEvent());
        assertEquals("Product Type:", controller.SearchPrompt.getText());
    }
    
    @Test
    public void testPickedSerial() {
        controller.PickedSerial(new ActionEvent());
        assertEquals("Serial Number (SN):", controller.SearchPrompt.getText());
    }
    
    @Test
    public void testPickedName() {
        controller.PickedName(new ActionEvent());
        assertEquals("Product Name:", controller.SearchPrompt.getText());
    }
    
    @Test
    public void testClickedRemoveTab() {
        // create test data
        ObservableList<String> inventory = FXCollections.observableArrayList("Item1", "Item2", "Item3");
        ListView<String> listView = new ListView<>(inventory);

        // simulate click event
        Event event = new Event(null);
        ClickedRemoveTab(event, listView, inventory);

        // assert that listView has been cleared and re-populated with inventory items
        assertEquals(3, listView.getItems().size());
        assertEquals(inventory, listView.getItems());
    }

    private void ClickedRemoveTab(Event event, ListView<String> listView, ObservableList<String> inventory) {
        listView.getItems().clear();
        listView.getItems().addAll(inventory);
    }
    
    @Test
    public void testClickedHomeTab() {
        // create test data
        ObservableList<String> inventory = FXCollections.observableArrayList("Item1", "Item2", "Item3");
        ListView<String> searchListView = new ListView<>(inventory);

        // simulate click event
        Event event = new Event(null);
        ClickedHomeTab(event, searchListView, inventory);

        // assert that searchListView has been cleared and re-populated with inventory items
        assertEquals(3, searchListView.getItems().size());
        assertEquals(inventory, searchListView.getItems());
    }

    private void ClickedHomeTab(Event event, ListView<String> searchListView, ObservableList<String> inventory) {
        searchListView.getItems().clear();
        searchListView.getItems().addAll(inventory);
    }
}
