package model;

public class boardgame extends Toy {
	int minPlayers;
	int maxPlayers;
	String designers;
	
	
	
	public boardgame(String serial, String name, String brand, float price, int availableCount, 
			int ageRating, String playerNum, String designers) {
		super(serial, name, brand, price, availableCount, ageRating);
		String playerNumArray[] = playerNum.split("-");
		minPlayers = Integer.parseInt(playerNumArray[0]);
		maxPlayers = Integer.parseInt(playerNumArray[1]);
		this.designers = designers;
	}
	
	public int getMinPlayers() {
		return minPlayers;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMinPlayers(int playerNumber) {
		this.minPlayers = playerNumber;
	}
	
	public void setMaxPlayers(int playerNumber) {
		this.maxPlayers = playerNumber;
	}
	
	public String getDesigners() {
		return designers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
	
	public String toString() {
		String title = (brand+" "+name+" $"+price+"\n"+"For "+minPlayers+"-"+maxPlayers+
				" players, ages "+ageRating+" and up. "+availableCount+" in stock."
				+" Serial #"+serial);
		return title;
	}
	
	public String format() {
		//Example: 9074383778;Blue Max;Gamearo;199.37;11;2;1-3;Rojin Poole
		String formattedTitle;
		formattedTitle = (serial+";"+name+";"+brand+";"+price+";"+availableCount+";"+ageRating+";"+minPlayers+"-"+
		maxPlayers+";"+designers);
		return formattedTitle;
	}
}
