/**
 * 
 */
package com.legato.admin.services.view.response;

/**
 * @author af83580
 *
 */

public class AuthorityResponseView {
	private Long id;
	private Long authorityId;
	private String authorityName;

	public AuthorityResponseView() {
		// Auto-generated constructor stub
	}

	public AuthorityResponseView(Long id, Long authorityId, String authorityName) {
		super();
		this.id = id;
		this.authorityId = authorityId;
		this.authorityName = authorityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
}