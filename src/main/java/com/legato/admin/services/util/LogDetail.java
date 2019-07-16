/**
 * 
 */
package com.legato.admin.services.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.legato.admin.services.constants.ApplicationConstants;
import com.legato.admin.services.jwt.security.dto.AppUser;

/**
 * @author Af83580
 *
 */
public class LogDetail {
	private String system;
	private Long userId;
	private String username;
	private String uri;
	private Exception exception;
	
	public LogDetail() {
		// Auto-generated constructor stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof AppUser) {
			AppUser user = (AppUser) authentication.getPrincipal();
			this.userId = user.getId();
		} else {
			this.userId = null;
		}
	}
	
	public LogDetail(String username, String uri) {
		this();
		this.system = ApplicationConstants.SYSTEM_NAME;
		this.username = username;
		this.uri = uri;
	}
	
	public LogDetail(String username, String uri, Exception exception) {
		super();
		this.username = username;
		this.uri = uri;
		this.exception = exception;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}