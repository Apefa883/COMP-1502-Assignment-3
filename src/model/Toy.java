package model;

public abstract class Toy {
	protected String serial;
	protected String name;
	protected String brand;
	protected float price;
	protected int availableCount;
	protected int ageRating;
	
	
	public Toy(String serial, String name, String brand, float price, int availableCount, int ageRating) {
		this.serial = serial;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageRating = ageRating;
	}
	
	public void setSerial(String newSerial) {
		serial = newSerial;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getSerial() {
		return serial;
	}
	
	public String getName() {
		return name;
	}
	//The new
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public int getAgeRating() {
		return ageRating;
	}
	
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	public int getCount() {
		return availableCount;
	}
	
	public void setCount(int count) {
		this.availableCount = count;
	}
	
	public void sellToy(int sold) {
		this.availableCount -= sold;
	}
	
	public void buyToy(int bought) {
		this.availableCount += bought;
	}
	
	public String format() {
		return "bruh";
	}
}
