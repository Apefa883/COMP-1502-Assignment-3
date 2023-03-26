package exception;

public class NegativePrice extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativePrice(float price){
		super("Error: Negative price "+price);
	}
}
