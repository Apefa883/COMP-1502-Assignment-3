package exception;

public class AgeMismatch extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgeMismatch(int min, int max){
		super("Error: Age +"+min+" is greater than "+max+"!");
	}
}
