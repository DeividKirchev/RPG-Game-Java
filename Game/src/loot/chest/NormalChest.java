package loot.chest;

import java.util.Random;

import loot.Item;
import loot.ItemList;

public class NormalChest extends Chest {
	ItemList items = new ItemList();
	
	@Override
	public Item getLoot() {
		Random rand = new Random();
		int r = rand.nextInt(items.lenght());
		return items.getItem(r);
	}
	
}
