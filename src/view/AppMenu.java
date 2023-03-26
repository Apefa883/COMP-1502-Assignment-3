package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.AgeMismatch;
import exception.NegativePrice;
import model.Toy;

public class AppMenu {
	//This class will display things to the user
	//All of the info its menus glean will go back to BrowserManager.
	
	Scanner input;
	
	/**
	 * Constructor class.
	 * Creates Scanner for user input.
	 * @return Doesn't return anything.
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Prints out main menu.
	 * Takes and stores user input first character into variable "option".
	 * @param char  Takes user first character input.
	 * @return returns user input's first character.
	 */
	public char showMainMenu() {
		
		System.out.println("**************************************************");
		System.out.println("*          WELCOME TO TOY STORE COMPANY!         *");
		System.out.println("**************************************************");
		System.out.println("");
		System.out.println("How We May Help You?");
		System.out.println("");
		System.out.println("(1)   Search Inventory and Purchase Toy");
		System.out.println("(2)   Add New Toy");
		System.out.println("(3)   Remove Toy");
		System.out.println("(4)   Save & Exit");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	/**
	 * Prints out Sub Menu.
	 * Takes and stores user input first character into variable "option".
	 * @param char  Takes user first character input.
	 * @return returns user input's first character.
	 */
	public char showSubMenu() {
		
		System.out.println("Find Toys With:");
		System.out.println("");
		System.out.println("(1)   Serial Number (SN)");
		System.out.println("(2)   Toy Name");
		System.out.println("(3)   Type");
		System.out.println("(4)   Back to Main Menu");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	/**
	 * Prompts the user for a toy type
	 * @return returns the user's choice as a char
	 */
	public char promptType() {
		System.out.print("Enter a toy type: \n");
		System.out.println("(1)   Figure");
		System.out.println("(2)   Animal");
		System.out.println("(3)   Puzzle");
		System.out.println("(4)   Board Game");
		
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	/**
	 * Prompts the user for a serial.
	 * Does not do anything other than display a message.
	 */
	public void promptSerial() {
		System.out.print("\nEnter a serial number (must be a 10-digit number): ");
	}
	
	/**
	 * Yells at the user for inputting an incorrect serial.
	 * Does not do anything other than display a message.
	 */
	public void angrySerial() {
		System.out.println("Invalid serial entered! It must be a valid 10-digit number: ");
	}

	/**
	 * Displays the serial number of a toy at the given place in the Inventory
	 * Does not do anything other than display a message.
	 */
	public void displaySerial(ArrayList<Toy> Inventory,int place) {
		System.out.println("This item found: \n");
		System.out.println(Inventory.get(place)+"\n");
		
	}
	
	/**
	 * Prompts the user to press enter to continue.
	 */
	public void promptContinue() {
		System.out.println("Press \"Enter\" to continue...");
		input.nextLine();
	}

	/**
	 * Yells at the user for making a wrong choice
	 */
	public void promptInvalid() {
		System.out.println("Invalid selection...");
		System.out.println("Please Try Again: ");
		input.nextLine();
	}
	
	/**
	 * Does nothing but print out an error message
	 */
	public void OutOfStock() {
		System.out.println("\nNo items with this serial number found.\n");
	}
	
	/**
	 * Does nothing but print out an error message
	 */
	public void promptNotFound() {
		System.out.println("No matches found.");
	}

	/**
	 * Does nothing but print out an error message
	 */
	public void promptOutOfStock() {
		System.out.println("Sorry, this toy is out of stock!");
	}

	/**
	 * Does nothing but print out an error message
	 */
	public void promptPurchased() {
		System.out.print("\nPurchase Successful!\n\n");
		
	}

	/**
	 * Lets the user know that their data is being saved
	 */
	public void promptSaving() {
		System.out.println("");
		System.out.println("Saving Data Into Database...");
	}

	/**
	 * Thanks the user for visiting
	 */
	public void promptSaved() {
		System.out.println("");
		System.out.println("*********** THANKS FOR VISITING US! ***********");
	}

	/**
	 * Prompts the user for a name, and prompts them again if they enter a blank string.
	 */
	public String promptName() {
		System.out.print("\nEnter toy name: ");
		String type = input.nextLine().trim();
		while(type.length() < 1) {
			System.out.print("\nBlank string entered! Enter toy name: ");
			type = input.nextLine().trim();
		}
		return type;
	}
	
	/**
	 * Prompts the user for a brand name, and prompts them again if they enter a blank string.
	 */
	public String promptBrand() {
		System.out.print("\nEnter toy brand: ");
		String type = input.nextLine().trim();
		while(type.length() < 1) {
			System.out.print("\nBlank string entered! Enter toy name: ");
			type = input.nextLine().trim();
		}
		return type;
	}
	
	/**
	 * Prompts the user for an age requirement for a toy, and prompts them again if they enter a negative integer
	 * or a value that cannot be parsed as an integer.
	 */
	public int promptAppropAge() {
		System.out.print("\nEnter Appropriate Age: ");
		
		String type = input.nextLine().trim();
		int age = 0;
		while(age <= 0) {
			try {	
				age = Integer.parseInt(type);
				if(age <=0) {
					System.out.print("Age must be positive! Try again:");
					type = input.nextLine().trim();
				}
			} catch (Exception e) {
				System.out.print("\nInvalid Value! Try again: ");
				type = input.nextLine().trim();
			}
		}
		return age;
	}
	
	/**
	 * Prompts the user for a price repeatedly until a valid float is entered.
	 */
	public float promptPrice() {
		System.out.print("\nEnter price: ");
		String priceIO = input.nextLine().trim();
		float price = 0;
		while(price <= 0) {
			try {	
				price = Float.parseFloat(priceIO);
				if(price <= 0) {
					throw new NegativePrice(price);
				} else {
					break;
				}
			} catch (NegativePrice e) {
				System.out.print("\nPrice cannot be a negative number! Try again: ");
			}catch (Exception e2) {
				System.out.print("\nPrice must be a valid numerical value! Try again: ");
			}
			priceIO = input.nextLine().trim();
		}
		return price;
	}
	
	/**
	 * Prompts the user for serial number and validates it.
	 */
	public String validateSerial() {
	    promptSerial();
	    String serial = input.nextLine();
	    Boolean validNumber = false;
	    Boolean validLength = false;
	    while (validNumber == false || validLength == false) {
	    	try {
	    		Long.parseLong(serial);
	    		validNumber = true;
	    		if(serial.length() == 10) {
	    			validLength = true;
	    		} else {
	    			angrySerial();
	    			serial = input.nextLine();
	    		}
	    	} catch(Exception e) {
	    		angrySerial();
	    		serial = input.nextLine();
	    	}
	    }
		return serial;
	}
	
	/**
	 * Prompts the user for a count of a new toy
	 * @return returns the count
	 */
	public int promptCount() {
		System.out.print("\nEnter Available Count: ");
		String CountIO = input.nextLine().trim();
		int Count = -1;
		while(Count <= 0) {
			try {	
				Count = Integer.parseInt(CountIO);
				if(Count <= 0) {
					throw new NegativePrice(Count);
				} else {
					break;
				}
			} catch (NegativePrice e) {
				System.out.print("\nCount cannot be a negative number! Try again: ");
			}catch (Exception e2) {
				System.out.print("\nCount must be a valid positive whole number! Try again: ");
			}
			CountIO = input.nextLine().trim();
		}
		return Count;
	}

	/**
	 * Prompts the user for a figure classification and validates the answer
	 * @return returns the figure type as a string
	 */
	public String promptClassification() {
		System.out.print("\nEnter Figure Classification: ");
		char FigType = (input.nextLine().trim()+" ").charAt(0);
		while(Character.toLowerCase(FigType) != 'a' && Character.toLowerCase(FigType) != 'd' && 
				Character.toLowerCase(FigType) != 'h') {
			System.out.print("\nIncorrect value entered! Must be A (Action), D (Doll), or H (Historic): ");
			FigType = (input.nextLine().trim()+" ").charAt(0);
		}
		return FigType+"";
	}

	/**
	 * Prompts the user for a toy animal's material
	 * @return returns the material type (string)
	 */
	public String promptMaterial() {
		System.out.print("\nEnter Material: ");
		String Material = input.nextLine().trim();
		while(Material.length() <= 0) {
			System.out.print("\nERROR: Valid String must be given: ");
			Material = input.nextLine().trim();
		}
		return Material;
	}

	/**
	 * Prompts the user for toy animal size
	 * @return returns the size as a string
	 */
	public String promptSize() {
		System.out.print("\nEnter Animal Size: ");
		char Size = (input.nextLine().trim()+" ").charAt(0);
		while(Character.toLowerCase(Size) != 's' && Character.toLowerCase(Size) != 'm' && 
				Character.toLowerCase(Size) != 'l') {
			System.out.print("\nIncorrect value entered! Must be S (Small), M (Medium), or L (Large): ");
			Size = (input.nextLine().trim()+" ").charAt(0);
		}
		return Size+"";
	}

	/**
	 * Prompts the user to enter the minimum and maximum numbers of players, validates the input and returns a string
	 * with the format "x-y"
	 * @return returns the player range as a string
	 */
	public String promptPlayerNum() {
		Boolean validated = false;
		int min = -1;
		int max = -1;
		String minString;
		String maxString;
		while(!validated) {
			try {
				System.out.print("\nEnter a minimum player count: ");
				minString = input.nextLine().trim();
				while(min <= 0) {
					try {	
						min = Integer.parseInt(minString);
						if(min <= 0) {
							throw new NegativePrice(min);
						} else {
							break;
						}
					} catch (NegativePrice e) {
						System.out.print("\nMinimum Count cannot be a negative number! Try again: ");
					}catch (Exception e2) {
						System.out.print("\nMinimum Count must be a valid positive whole number! Try again: ");
					}
					minString = input.nextLine().trim();
				}
				
				System.out.print("\nEnter a maximum player count: ");
				maxString = input.nextLine().trim();
				while(max <= 0) {
					try {	
						max = Integer.parseInt(maxString);
						if(max <= 0) {
							throw new NegativePrice(max);
						} else {
							break;
						}
					} catch (NegativePrice e) {
						System.out.print("\nMaximum Count cannot be a negative number! Try again: ");
					}catch (Exception e2) {
						System.out.print("\nMaximum Count must be a valid positive whole number! Try again: ");
					}
					maxString = input.nextLine().trim();
				}
				
				if(max < min) {
					throw new AgeMismatch(min,max);
				} else {
					validated = true;
				}
			} catch (AgeMismatch badage) {
				System.out.print("\nMaximum Age must be greater than or equal to Minimum age!\n");
				min = -1;
				max = -1;
			}
		}
		return (min+"-"+max);
	}
	
	
	/**
	 * Prompts the user to enter the toy designers and validates their answer
	 * @return returns the designer list as a string
	 */
	public String promptDesigners() {
		System.out.print("\nEnter Designer Names (Use ',' to separate the names if there is more than"
				+ " one name): ");
		String Designers = input.nextLine().trim();
		while(Designers.length() <= 0) {
			System.out.print("\nERROR: Valid String must be given: ");
			Designers = input.nextLine().trim();
		}
		return Designers;
	}

	public void promptExistingSerial() {
		System.out.print("\nERROR: Serial Already Exists!");
	}

	/**
	 * Prompts the user for a puzzle type and validates their answer
	 * @return returns the puzzle type as a string
	 */
	public String promptPuzzleType() {
		System.out.print("\nEnter Puzzle type: ");
		char PuzType = (input.nextLine().trim()+" ").charAt(0);
		while(Character.toLowerCase(PuzType) != 'm' && Character.toLowerCase(PuzType) != 'c' && 
				Character.toLowerCase(PuzType) != 'l' && Character.toLowerCase(PuzType) != 't' 
				&& Character.toLowerCase(PuzType) != 'r') {
			System.out.print("\nIncorrect value entered! Must be M (Mechanical), C (Cryptic), L (Logical), "
					+ "T (Trivia), or R (Riddle): ");
			PuzType = (input.nextLine().trim()+" ").charAt(0);
		}
		return PuzType+"";
	}

	public void newToy() {
		System.out.print("\nNew Toy Added!\n");
		promptContinue();
	}

	public void promptSaveFailure() {
		System.out.print("\nERROR: Failed to save data!\n");
		promptContinue();
	}

	/**
	 * Checks if the user is willing to remove the toy with a validated Y/N question
	 * @return returns a boolean: true if the user chooses to delete the toy and false otherwise
	 */
	public Boolean promptRemove() {
		System.out.print("\nDo you want to remove it (Y/N)? ");
		Boolean removeOrNah = false;
		char answer = (input.nextLine().trim()+" ").charAt(0);
		while(Character.toLowerCase(answer) != 'y' && Character.toLowerCase(answer) != 'n') {
			System.out.print("\nInvalid answer! Again, do you want to remove it (Y/N): ");
			answer = (input.nextLine().trim()+" ").charAt(0);
		}
		if(answer == 'y') {
			removeOrNah = true;
		}
		return removeOrNah;
	}
	
	/**
	 * Checks if the user is willing to buy the toy with a validated Y/N question
	 * @return returns a boolean: true if the purchase goes through and false otherwise
	 */
	public Boolean promptSureToBuy() {
		System.out.print("\nDo you want to buy this toy (Y/N)? ");
		Boolean buyOrNah = false;
		char answer = (input.nextLine().trim()+" ").charAt(0);
		while(Character.toLowerCase(answer) != 'y' && Character.toLowerCase(answer) != 'n') {
			System.out.print("\nInvalid answer! Again, do you want to buy this? (Y/N): ");
			answer = (input.nextLine().trim()+" ").charAt(0);
		}
		if(answer == 'y') {
			buyOrNah = true;
		}
		return buyOrNah;
	}

	public void promptKilled() {
		System.out.print("\nItem Removed!\n");
		promptContinue();
		
	}

	/**
	 * Calls the user a coward. Very important.
	 */
	public void promptCoward() {
		System.out.print("\nCoward.\n\n");
		promptContinue();
	}
	
	public void promptInvalidOption() {
		System.out.print("");
		System.out.print("******************************");
		System.out.print("* Invalid Option! Try Again! *");
		System.out.print("******************************");
		System.out.print("");
	}

	/**
	 * Displays results of a search
	 * @param matches A list of items matching the user's search
	 * @return The index, in matches[], of the object to purchase
	 */
	public int displayResults(ArrayList<Toy> matches) {
		int j;
    	for (j = 0; j < matches.size(); j++) {
        	System.out.println("("+(j+1)+") "+matches.get(j).toString());
        }
    	System.out.println("("+(j+1)+") Back to Search Menu");
    	
    	
    	System.out.print("\n\nEnter option number to purchase: ");
		String ChoiceIO = input.nextLine().trim();
		int Choice = -1;
		while(Choice < 0 || Choice >= matches.size()) {
			try {	
				Choice = Integer.parseInt(ChoiceIO) - 1;
				if(Choice < matches.size() && Choice >= 0) {
					break;
				} else if(Choice == matches.size()) {
					break;
				} else {
					System.out.print("\nChoose a valid menu option! Try again: ");
					ChoiceIO = input.nextLine().trim();
				}
			}catch (Exception e) {
				System.out.print("\nChoice must be a valid positive whole number! Try again: ");
				ChoiceIO = input.nextLine().trim();
			}
		}
    	
		return Choice;
	}
}