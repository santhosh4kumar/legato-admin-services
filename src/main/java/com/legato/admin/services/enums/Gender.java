/**
 * 
 */
package com.legato.admin.services.enums;

/**
 * @author af83580
 *
 */
public enum Gender {
	MALE(1, "Male"),
    FEMALE(2, "Female");
	
	private int id;
	private String name;
	private Gender(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static Gender getById(int id){
		return Gender.values()[id];
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}