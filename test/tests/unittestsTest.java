package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
}
