/**
 * 
 */
package com.legato.admin.services.enums;

/**
 * @author af83580
 *
 */
public enum UserCategory {
	ADMIN(1, "ADMIN"),
    USER(2, "USER");
	
	private int id;
	private String name;
	private UserCategory(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static UserRoleEnum getById(int id){
		return UserRoleEnum.values()[id];
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}