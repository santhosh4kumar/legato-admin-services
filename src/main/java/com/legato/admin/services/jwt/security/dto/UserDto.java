/**
 * 
 */
package com.legato.admin.services.jwt.security.dto;

/**
 * @author af83580
 *
 */
public class UserDto {
	private String username;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String sessionId;
	private boolean admin;
	
	public UserDto() {
		// Auto-generated constructor stub
	}

	public UserDto(String username, int id, String firstName, String lastName, String email, String sessionId,
			boolean admin) {
		super();
		this.username = username;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.sessionId = sessionId;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}