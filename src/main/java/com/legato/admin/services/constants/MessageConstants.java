/**
 * 
 */
package com.legato.admin.services.constants;

/**
 * @author AF83580
 *
 */
public final class MessageConstants {
	private MessageConstants() {}
	public static final String NA_MSG = "Not Available";
	public static final String SUCCESS_MSG = "Successfully proccessed request.";
	public static final String FAILURE_MSG = "Failed while processing the request!";
	public static final String INTERNAL_SERVER_ERR_MSG = "Internal server error! Please try again.";
	public static final String SESSION_EXPIRED_MSG = "Session expired";
	public static final String LOGOUT_MSG = "Logged out successfully";
	public static final String USER_ROLE_NOT_FOUND_MSG = "Could not find the requested user role!";
	public static final String INVALID_PSWD_FORMAT_MSG = "Password must be 6-20 characters and must contain at least 1 uppercase letter, 1 lowecase letter, 1 digit and 1 special character in [@#$%]";
	public static final String ACCESS_DENIED_MSG = "Access denied";
	public static final String REGISTRATION_SUCCESS_MSG = "Your registration request successfully sent!\nYou will be able to access your account once your manager approves it.";
	public static final String MANGER_NOT_FOUND = "{} not found!";
	public static final String DUPLICATE_USERNAME_MSG = "Username already exists!";
	public static final String DUPLICATE_EMAIL_MSG = "Email already exists!";
	public static final String DUPLICATE_MOBILE_MSG = "Mobile number already exists!";
	public static final String DUPLICATE_PROPERTY_NAME_MSG = "Property name already exists";
}