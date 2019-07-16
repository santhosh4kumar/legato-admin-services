/**
 * 
 */
package com.legato.admin.services.view.response;

/**
 * @author af83580
 *
 */
public class AuthResponse {
	private String token;
	private boolean success;

	public AuthResponse(String token) {
		this.success = (token != null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}