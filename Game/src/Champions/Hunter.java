package Champions;

public class Hunter extends Champion{
	
	public Hunter(int baseHealth, int baseArmor, int baseDamage) 
	{
		this.baseHealth = baseHealth;
		this.baseArmor = baseArmor;
		this.baseDamage = baseDamage;
		baseSpeed = 1;
		baseRange = 1;
		current_health = baseHealth;
	}
}
