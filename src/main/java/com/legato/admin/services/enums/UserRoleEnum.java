/**
 * 
 */
package com.legato.admin.services.enums;

/**
 * @author af83580
 *
 */
public enum  UserRoleEnum {
	ROLE_SUPERADMIN(0, "ROLE_SUPERADMIN"),
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER");
	
	private int id;
	private String name;
	private UserRoleEnum(int id, String name){
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