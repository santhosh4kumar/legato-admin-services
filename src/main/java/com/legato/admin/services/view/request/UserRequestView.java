package com.legato.admin.services.view.request;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class UserRequestView {
	private Long id;
	private String firstName;
	private String lastName;
	private int gender;
	private String username;
	private String email;
	private String password;
	private String mobile;
	private String addressLine1;
	private String addressLine2;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date birthDate;
	private String profilePic;
	private Boolean active;
	private Integer status;
	private Set<Long> role;
	private int userCategory;
	private Set<Long> accesses;
	private int managerId;

	public UserRequestView() {
		// Auto-generated constructor stub
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Long> getRole() {
		return role;
	}

	public void setRole(Set<Long> role) {
		this.role = role;
	}

	public Set<Long> getAccesses() {
		return accesses;
	}

	public void setAccesses(Set<Long> accesses) {
		this.accesses = accesses;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}