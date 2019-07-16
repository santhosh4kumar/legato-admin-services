/**
 * 
 */
package com.legato.admin.services.exception;

/**
 * @author Niranjan
 *
 */
public class InvalidFormatException extends RuntimeException{
	private static final long serialVersionUID = -2912994441810155305L;
	
	/**
	 * 
	 */
	public InvalidFormatException() {
		super("Invalid format exception !");
	}
	
	public InvalidFormatException(String message) {
		super(message);
	}
}