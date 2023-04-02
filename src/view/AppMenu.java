package view;



public class AppMenu {
	//This class will display things to the user
	
	/**
	 * Tells the user if their serial is bad
	 */
	public void tellBadSerial() {
		System.out.println("Bad serial!");
	}

	/**
	 * Tells the user if something that ought to be positive is negative.
	 */
	public void tellNegativeVal() {
		System.out.println("Error! Negative numerical value entered!!");
	}

	/**
	 * Tells the user if key numerical values cannot be parsed as numbers.
	 */
	public void tellNotNumbers() {
		System.out.println("Error! Values are not numbers!!");
	}

	/**
	 * Tells the user if the fields are of improper length.
	 */
	public void tellEmptyField() {
		System.out.println("Fields are of improper length!");
	}

	/**
	 * Tells the user if the serial is already in the system.
	 */
	public void tellExistingSerial() {
		System.out.println("Serial already exists!");
	}

	/**
	 * Tells the user if the serial does not match the product type.
	 */
	public void tellNonMatchSerial() {
		System.out.println("Serial does not match product type!");
	}

	/**
	 * Informs the user that saving was successful.
	 */
	public void promptSaved() {
		System.out.println("Saved!");
	}

	/**
	 * Tells the user if the code could not save the new toy
	 */
	public void tellCouldntSave() {
		System.out.println("Could not save! Invalid values!");
	}

	/**
	 * Tells the user if the minimum player count is over the maximum
	 */
	public void tellPlayerCountMismatch() {
		System.out.println("Invalid player counts!");
	}

	/**
	 * Tells the user if the file is not found
	 */
	public void tellNoFile() {
		System.out.println("ERROR: ARCHIVE FILE NOT FOUND!");
	}

	

}