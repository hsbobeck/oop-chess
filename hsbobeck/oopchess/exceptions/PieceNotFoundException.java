/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-07-30
 * 
 */
package hsbobeck.oopchess.exceptions;

public class PieceNotFoundException extends Exception {
	public PieceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
	public PieceNotFoundException() {
        super();
    }
	
}
