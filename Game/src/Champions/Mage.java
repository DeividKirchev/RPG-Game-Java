package Champions;

public class Mage extends Champion{
	public String[] Abilities = new String[10];
	//=======================================
	public Mage(int hp,int sp,int arm,int dmg,int rng)
	{
		baseHealth = hp;
		baseSpeed = sp;
		baseArmor = arm;
		baseDamage = dmg;
		baseRange = rng;
		current_health = baseHealth;
		setAbilities();
	}
	//HP,baseArmor,DMG constructor
	public Mage(int baseHealth, int baseArmor,int baseDamage)
	{
		this.baseHealth = baseHealth;
		this.baseArmor = baseArmor;
		this.baseDamage = baseDamage;
		baseSpeed = 1;
		baseRange = 1;
		current_health = baseHealth;
		setAbilities();
	}
	// Base constructor
	public Mage()
	{
		baseHealth = 100;
		baseArmor = 25;
		baseDamage = 15;
		baseRange = 1;
		baseSpeed = 1;
		current_health = baseHealth;
		setAbilities();
	}
	//-------------------------
	//-------------------------
	//Set abilities
	private void setAbilities()
	{
		Abilities[0] = "Basic Attack";
		Abilities[1] = "Heavy Attack";
		Abilities[2] = "Fireball";
		Abilities[3] = "Meteor";
	}

		public Boolean baseHit(Champion x)
		{
			if(!checkHit(80))return false;
			x.current_health = x.current_health - (5 + rand.nextInt(10));
			//System.out.println((this.Damage() * (100-x.Armor()) / 100) + rand.nextInt(10));
			if(x.current_health <= 0)x.setAlive(false);
			return true;
		}
	

	public Boolean heavyHit(Champion x) {
		if(!checkHit(55))return false;
		
		x.current_health -= 10 + rand.nextInt(15)*7/5;
		if(x.current_health <= 0)x.setAlive(false);
		return true;
	}
	public Boolean Fireball(Champion x)
	{
		if(!checkHit(65))return false;
		x.current_health -= this.Damage()*9/10;
		if(x.current_health <= 0)x.setAlive(false);
		return true;
	}
	public Boolean Meteor(Champion x)
	{
		if(!checkHit(50))return false;
		x.current_health -= this.Damage()*5/3;
		if(x.current_health <= 0)x.setAlive(false);
		return true;
	}
	
}
