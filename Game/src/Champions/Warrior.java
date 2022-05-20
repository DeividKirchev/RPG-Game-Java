package Champions;

import Champions.Abilities.execute;
import Champions.Abilities.hit;
import Champions.Abilities.spin_swipe;
import main.MainFrame;

public class Warrior extends Champion{
	//=========================================
	public Warrior(int hp,int sp,int arm,int dmg,int rng)
	{
		baseHealth = hp;
		baseSpeed = sp;
		baseArmor = arm;
		baseDamage = dmg;
		baseRange = rng;
		current_health = baseHealth;
	}
	//HP,baseArmor,DMG constructor
	public Warrior(int baseHealth, int baseArmor,int baseDamage,MainFrame frame)
	{
		this.baseHealth = baseHealth;
		this.baseArmor = baseArmor;
		this.baseDamage = baseDamage;
		baseSpeed = 1;
		baseRange = 1;
		current_health = baseHealth;
		
		ability1 = new hit(this,frame);
		ability2 = new execute(this,frame);
		ability3 = new spin_swipe(this,frame);
	}
	// Base constructor
	public Warrior()
	{
		baseHealth = 100;
		baseArmor = 25;
		baseDamage = 15;
		baseRange = 1;
		baseSpeed = 1;
		current_health = baseHealth;
	}
	//-------------------------
	//-------------------------
	//===================================
	// Abilities:
	    // 80% hit
		public Boolean baseHit(Champion x)
		{
			if(!checkHit(80))return false;
			x.current_health = x.current_health -  (Math.max((this.Damage() * (100-x.Armor()) / 100),0) + rand.nextInt(10));
			//System.out.println((this.Damage() * (100-x.Armor()) / 100) + rand.nextInt(10));
			if(x.current_health <= 0)x.setAlive(false);
			return true;
		}
		
		// 45% hit (level 2?)
		public Boolean heavyHit(Champion x) {
			if(!checkHit(55))return false;
			
			x.current_health -= (Math.max((this.Damage() * (100-x.Armor()) / 100),0) + rand.nextInt(15))*7/5;
			if(x.current_health <= 0)x.setAlive(false);
			return true;
		}
		public Boolean ThrowWeapon(Champion x)
		{
			if(!checkHit(35))return false;
			x.current_health -= Math.max((this.Damage() * (100-x.Armor()) / 100),0);
			if(x.current_health <= 0)x.setAlive(false);
			return true;
		}
		//=============================================
		// Execute - lower hp%, higher chance (level 3?) 
		// Under 35% 5% chance of success
		// Over 35% -10% chance of success
		public Boolean Execute(Champion x) {
			int hpPercent = x.current_health*100/x.Health();
			if(hpPercent < 35)
			   {if(!checkHit(100- hpPercent + 5) ) return false;}
			else {if(!checkHit(100- hpPercent - 10) ) return false;}
			
			Heal(x.current_health);
			x.current_health = 0;
			x.setAlive(false);
			return true;
		}
		//=============================================
		

}
