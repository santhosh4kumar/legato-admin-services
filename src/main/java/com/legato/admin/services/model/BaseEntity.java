package com.legato.admin.services.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(updatable = false, name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "VALID_FROM")
	@CreationTimestamp
	private Date validFrom;

	@Column(name = "VALID_TO")
	private Date validTo;
	
	@Column(name = "ACTIVE", columnDefinition="bit default true")
    private boolean active = true;

	public BaseEntity() {
		// default constructor
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	@PrePersist
	public void onCreate() {
		createdAt = new Date();
		if(validFrom == null) {
			validFrom = new Date();
		}
		if (validTo == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(8888, 11, 31, 0, 0, 0);
			validTo = calendar.getTime();
		}
		if(createdBy == null || createdBy.isEmpty()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			createdBy = username;
		}
	}

	@PreUpdate
	public void onUpdate() {
		updatedAt = new Date();
		if(validFrom == null) {
			validFrom = new Date();
		}
		if (validTo == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(8888, 11, 31, 0, 0, 0);
			validTo = calendar.getTime();
		}
		if(updatedBy == null || updatedBy.isEmpty()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			updatedBy = username;
		}
	}
	
	/**
	 * return true if {@link #id} are matched.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseEntity) {
			return getId() == ((BaseEntity)obj).getId();
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		if (id != null) return id.hashCode();
		return super.hashCode();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}