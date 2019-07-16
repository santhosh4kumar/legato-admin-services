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
 * This class is to describe the user specific access stuff
 */

@Entity
@Table(name = "USER_ACCESS", uniqueConstraints = {
    @UniqueConstraint(
		columnNames = {"ACCESS_NM"},
		name = "UNIQUE_ACCESS_NM"
    )}
)
public class UserAccess extends BaseEntity {
	@Column(name = "ACCESS_ID")
	private String accessId;
	
	@Column(name = "ACCESS_NM")
	private String accessName;
	
	@Column(name = "ACCESS_DESC")
	private String accessDesc;
	
	public UserAccess() {
		// Auto-generated constructor stub
	}	

	public UserAccess(String accessId, String accessName, String accessDesc) {
		super();
		this.accessId = accessId;
		this.accessName = accessName;
		this.accessDesc = accessDesc;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getAccessDesc() {
		return accessDesc;
	}

	public void setAccessDesc(String accessDesc) {
		this.accessDesc = accessDesc;
	}
}