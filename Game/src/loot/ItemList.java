package loot;

import java.awt.image.BufferedImage;



import basics.PictureDataBase;
import loot.Item.Type;

public class ItemList {
	private Item items[] = new Item[100];
	private PictureDataBase pic = new PictureDataBase();
	private int last = 0;
	
	public void newItem(int damage,int health,int armor, String name,Type type)
	{
		items[last] = new Item(damage,health,armor,name,type);
		last++;
	}
	public void newItem(int damage,int health,int armor, String name,Type type,BufferedImage img)
	{
		items[last] = new Item(damage,health,armor,name,type);
		items[last].Icon = img;
		last++;
	}
	public void newItem(int i,int damage,int health,int armor, String name,Type type)
	{
		items[i] = new Item(damage,health,armor,name,type);
	}
	public void newItem(int i,int damage,int health,int armor, String name,Type type,BufferedImage img)
	{
		items[i] = new Item(damage,health,armor,name,type);
		items[i].Icon =img;
	}
	public Item getItem(int i)
	{
		return items[i];
	}
	public int lenght()
	{
		return last;
	}
	
	
	public ItemList()
	{
		// Dragon Helmet 0 dmg 15 health 5 armor
		newItem(0,15,5,"Dragon Helmet",Type.HELMET,pic.DragonHelmet);
		// Dragon Chestplate 3 dmg 20 health 8 armor
		newItem(3,20,8,"Dragon Chestplate",Type.CHEST,pic.DragonChest);
		// Dragon Legguards 1 20 5
		newItem(1,20,5,"Dragon Legguards",Type.LEGS,pic.DragonLegs);
		
		// Dragonscale Sword 20,0,0
		newItem(20,0,0,"Dragonscale Sword",Type.WEAPON,pic.DragonSword);
		
		// Greatsword 15 0 0
		newItem(15,0,0,"Greatsword",Type.WEAPON,pic.GreatSword);
		
		// Greataxe 10 30 0
		newItem(10,30,0,"Greataxe of Life",Type.WEAPON,pic.AxeOfLife);
		// Helmet of Life 0 25 5
		newItem(0,25,5,"Helmet of Life",Type.HELMET,pic.HelmetOfLife);
		// Chestplate of Life 0 25 10
		newItem(0,25,10,"Chestplate of Life",Type.CHEST,pic.ChestOfLife);
		// Legguards of Life 0 25 5
		newItem(0,25,5,"Legguards of Life",Type.LEGS,pic.LegsOfLife);
		
		// Thorn Chestplate 15 5 5
		newItem(15,5,5,"Thorn Chestplate",Type.CHEST,pic.ThornChest);
		// Thorn Leggings 10 3 3
		newItem(10,3,3,"Thorn Legs",Type.LEGS,pic.ThornLegs);
		// Thorn Helmet 8 2 2
		newItem(8,2,2,"Thorn Helmet",Type.HELMET,pic.ThornHelmet);
		// Thorn Gauntlet
		newItem(15,5,5,"Thorn Gauntlets",Type.WEAPON,pic.ThornGauntlets);
		
		// HealthPotion
	    newItem(0,0,0,"Small Health Potion",Type.HEAL25,pic.health_potion);
	    // HealthPotion
	    newItem(0,0,0,"Medium Health Potion",Type.HEAL50,pic.health_potion);
	    // HealthPotion
	    newItem(0,0,0,"Large Health Potion",Type.HEALFULL,pic.health_potion);
	    
	}
}
