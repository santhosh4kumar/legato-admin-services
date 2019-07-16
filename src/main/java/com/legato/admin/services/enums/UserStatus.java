package com.legato.admin.services.enums;

public enum UserStatus {
	PENDING(0, "Pending"),
    APPROVED(1, "Approved"),
    REJECTED(2, "Rejected");
	
	private int id;
	private String name;
	private UserStatus(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static UserStatus getById(int id){
		return UserStatus.values()[id];
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}