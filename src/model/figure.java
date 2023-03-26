package model;

public class figure extends Toy{
	char classification;
	
	
	
	public figure(String serial, String name, String brand, float price, int availableCount, 
			int ageRating, char classification) {
		super(serial, name, brand, price, availableCount, ageRating);
		this.classification = classification;
	}
	
	public char getClassification() {
		return classification;
	}
	
	public void setClassification(char classification) {
		this.classification = classification;
	}

	public String toString() {
		String title = (brand+" "+name);
		switch(classification) {
		case 'A':
			title+=(" action figure ");
			break;
		case 'D':
			title+=(" doll ");
			break;
		case 'H':
			title+=(" historical figure ");
			break;
		default:
			title += (" figure ");
			break;
		}
		title += ("$"+price+"\n"+"For ages "+ageRating+" and up. "+availableCount+" in stock."+" Serial #"+serial);
		return title;
	}
	
	public String format() {
		//Example: 1147205649;Ninja Turtles;Gamezoid;46.15;10;6;A
		String formattedTitle;
		formattedTitle = (serial+";"+name+";"+brand+";"+price+";"+availableCount+";"+ageRating+";"+classification);
		return formattedTitle;
	}
}
