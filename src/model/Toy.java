package model;

import javafx.scene.Node;

public abstract class Toy {
	protected String serial;
	protected String name;
	protected String brand;
	protected float price;
	protected int availableCount;
	protected int ageRating;
	
	/**
	 * Constructor class
	 * @param serial number
	 * @param name
	 * @param brand
	 * @param price
	 * @param amount in stock
	 * @param minimum safe age to use this toy without exploding or something
	 */
	public Toy(String serial, String name, String brand, float price, int availableCount, int ageRating) {
		this.serial = serial;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageRating = ageRating;
	}
	
	/**
	 * Sets the toy's serial
	 * @param newSerial
	 */
	public void setSerial(String newSerial) {
		serial = newSerial;
	}
	
	/**
	 * Sets the name of the toy
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Gets the serial of the toy
	 * @return serial
	 */
	public String getSerial() {
		return serial;
	}
	
	/**
	 * Gets the name of the toy
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the brand of the toy
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Sets the brand of the toy
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Gets the price of the toy
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Sets the price of the toy
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Gets the recommended minimum age rating of the toy.
	 * @return
	 */
	public int getAgeRating() {
		return ageRating;
	}
	
	/**
	 * Sets the recommended minimum age rating of the toy.
	 * @param ageRating
	 */
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	/**
	 * Gets the count of the toy
	 * @return
	 */
	public int getCount() {
		return availableCount;
	}
	
	/**
	 * Sets the count of the toy
	 * @param count
	 */
	public void setCount(int count) {
		this.availableCount = count;
	}
	
	/**
	 * Sells the toy to the customer, removing it from the inventory.
	 * @param amount sold
	 */
	public void sellToy(int sold) {
		this.availableCount -= sold;
	}
	
	/**
	 * Purchases the toy to be added to the inventory.
	 * @param the amount to buy
	 */
	public void buyToy(int bought) {
		this.availableCount += bought;
	}
	
	/**
	 * A blank-ish format function, designed to be overridden by its subclasses.
	 * Pay this no mind.
	 * @return
	 */
	public String format() {
		return "bruh";
	}

}
