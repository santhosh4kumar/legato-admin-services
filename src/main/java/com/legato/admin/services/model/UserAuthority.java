/**
 * 
 */
package com.legato.admin.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Af83580
 *
 *         This class is to describe the user roles/authorizations
 */

@Entity
@Table(name = "USER_AUTHORITY", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "AUTHORITY_ID" }, name = "UNIQUE_AUTHORITY_ID"),
		@UniqueConstraint(columnNames = { "AUTHORITY_NM" }, name = "UNIQUE_AUTHORITY_NM") })
public class UserAuthority extends BaseEntity {
	@Column(name = "AUTHORITY_ID")
	private Long authorityId;
	@Column(name = "AUTHORITY_NM")
	private String authorityName;

	public UserAuthority() {
		// Auto-generated constructor stub
	}

	public UserAuthority(Long roleId, String roleName) {
		super();
		this.authorityId = roleId;
		this.authorityName = roleName;
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