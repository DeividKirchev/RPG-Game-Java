package loot;

import java.awt.image.BufferedImage;


public class Item {
	private String name;
	private int damage = 0;
	private int health = 0;
	private int armor = 0;
	public BufferedImage Icon = null;
	
	public enum Type {
		CHEST,
		HELMET,
		WEAPON,
		LEGS,
		EXTRA,
		FEET,
		HEAL25,
		HEAL50,
		HEALFULL
		
	}
	public Type type;
	public Item()
	{
		name = "Default Name";
	}
	
	public Item(int damage, int health, int armor,String name,Type type) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.armor = armor;
		this.type = type;
	}
	public Item(String name)
	{
		this.name = name;
	}
               //=======================================================================Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
}
