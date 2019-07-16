package com.legato.admin.services.model;
/**
 * 
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Af83580
 *
 * This class is to describe the user profiles which are approved
 */

@Entity
@Table(name = "USER_PROFILE", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USERNAME" }, name = "UNIQUE_USERNAME"),
		@UniqueConstraint(columnNames = { "MOBILE" }, name = "UNIQUE_MOBILE"),
		@UniqueConstraint(columnNames = { "EMAIL_ID" }, name = "UNIQUE_EMAIL_ID") })
public class UserProfile extends BaseEntity{
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "FIRST_NM")
	private String firstName;
	@Column(name = "LAST_NM")
	private String lastName;
	@Column(name = "GENDER")
	private Integer gender;
	@Column(name = "EMAIL_ID")
	private String email;
	@Column(name = "MOBILE")
	private String mobile;
	@Column(name = "ADDRESS_LINE_ONE")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_TWO")
	private String addressLine2;
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "id")
	private UserProfile managerId;
	@Column(name = "PROFILE_PIC")
	private String profilePic;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_CATEGORY")
	private int userCategory;
	@Column(name = "STATUS")
	private Integer status;
	    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "AUTHORITY_MANAGER", 
    	joinColumns = @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FOREIGN_AUTHORITY_USER_ID")), 
    	inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", foreignKey = @ForeignKey(name = "FOREIGN_AUTHORITY_ID")))
    private Set<UserAuthority> authorities = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ACCESS_MANAGER", 
    	joinColumns = @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FOREIGN_ACCESS_USER_ID")), 
    	inverseJoinColumns = @JoinColumn(name = "ACCESS_ID", foreignKey = @ForeignKey(name = "FOREIGN_ACCESS_ID")))
    private Set<UserAccess> accesses = new HashSet<>();

    public UserProfile() {
    	// Auto-generated constructor stub
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserProfile getManagerId() {
		return managerId;
	}

	public void setManagerId(UserProfile managerId) {
		this.managerId = managerId;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}

	public Set<UserAccess> getAccesses() {
		return accesses;
	}

	public void setAccesses(Set<UserAccess> accesses) {
		this.accesses = accesses;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
}