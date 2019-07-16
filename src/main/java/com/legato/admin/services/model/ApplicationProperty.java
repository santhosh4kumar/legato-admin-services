/**
 * 
 */
package com.legato.admin.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author AF83580
 *
 */

@Entity
@Table(name = "APPLICATION_PROPERTY", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"PROPERTY_ID"}, name = "UNIQUE_PROPERTY_ID"), 
	@UniqueConstraint(columnNames = {"PROPERTY_NAME"}, name = "UNIQUE_PROPERTY_NAME")
	}
)
public class ApplicationProperty extends BaseEntity {
	@Column(name = "PROPERTY_ID")
	private String propertyId;
	@Column(name = "PROPERTY_NAME")
	private String propertyName;
	@Column(name = "PROPERTY_DESC")
	private String propertyDesc;
	@Column(name = "PROPERTY_VALUE")
	private String propertyValue;

	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyDesc() {
		return propertyDesc;
	}
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
}