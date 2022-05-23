package Champions;
import java.util.Random;

public abstract class Champion {
	protected int baseHealth;
	protected int baseSpeed;
	protected int baseArmor;
	protected int baseDamage;
	protected int baseRange;
	protected int extraHealth = 0;
	protected int extraSpeed = 0;
	protected int extraArmor = 0;
	protected int extraDamage = 0;
	protected int extraRange = 0;
	
	protected Boolean alive = true;
	protected int current_health;
	protected String name = new String();
	
	public Random rand = new Random();
	public Ability ability1;
	public Ability ability2;
	public Ability ability3;
	public Ability ability4;
	public Ability ability5;
	public Ability ability6;
	//Constructors:
	// Everything constructor
	public Champion(int hp,int sp,int arm,int dmg,int rng)
	{
		baseHealth = hp;
		baseSpeed = sp;
		baseArmor = arm;
		baseDamage = dmg;
		baseRange = rng;
	}
	//HP,baseArmor,DMG constructor
	public Champion(int baseHealth, int baseArmor,int baseDamage)
	{
		this.baseHealth = baseHealth;
		this.baseArmor = baseArmor;
		this.baseDamage = baseDamage;
		baseSpeed = 3;
		baseRange = 3;
	}
	// Base constructor
	public Champion()
	{
		baseHealth = 50;
		baseArmor = 10;
		baseDamage = 10;
		baseRange = 1;
		baseSpeed = 1;
	}
	//-------------------------

	// Getters & Setters:
	public void setBaseHealth(int baseHealth) {
		this.baseHealth = baseHealth;
	}
	public int getBaseHealth() {
		return baseHealth;
	}
	public int getBaseSpeed() {
		return baseSpeed;
	}
	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}
	public int getBaseArmor() {
		return baseArmor;
	}
	public void setBaseArmor(int baseArmor) {
		this.baseArmor = baseArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public int getBaseRange() {
		return baseRange;
	}
	public void setBaseRange(int baseRange) {
		this.baseRange = baseRange;
	}
	public String Name() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExtraHealth() {
		return extraHealth;
	}
	public void setExtraHealth(int extraHealth) {
		this.extraHealth = extraHealth;
		if(this.current_Health()>this.Health())this.setCurrent_Health(this.Health());
	}
	public int getExtraSpeed() {
		return extraSpeed;
	}
	public void setExtraSpeed(int extraSpeed) {
		this.extraSpeed = extraSpeed;
	}
	public int getExtraArmor() {
		return extraArmor;
	}
	public void setExtraArmor(int extraArmor) {
		this.extraArmor = extraArmor;
	}
	public int getExtraDamage() {
		return extraDamage;
	}
	public void setExtraDamage(int extraDamage) {
		this.extraDamage = extraDamage;
	}
	public int getExtraRange() {
		return extraRange;
	}
	public void setExtraRange(int extraRange) {
		this.extraRange = extraRange;
	}
	public Boolean Alive() {
		return alive;
	}
	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
	
	public int Armor()
	{
		return baseArmor+extraArmor;
	}
	public int Damage()
	{
		return baseDamage+extraDamage;
	}
	public int Health()
	{
		return baseHealth+extraHealth;
	}
	public int current_Health()
	{
		return current_health;
	}
	public void setCurrent_Health(int hp)
	{
		this.current_health = hp;
		if(this.current_Health() <= 0)this.setAlive(false);
	}
	public int Speed()
	{
		return baseSpeed+extraSpeed;
	}
	public int Range()
	{
		return baseRange+extraRange;
	}
	public void Revive(int health_percent)
	{
		alive = true;
		current_health = this.Health() * (health_percent / 100);
	}
	public void FillHealth()
	{
		current_health = this.Health();
	}
	public void Heal(int heal)
	{
		current_health = Math.min(current_health+heal,Health());
	}
	//-----------------------------------
	public Boolean checkHit(int HitPercent)
	{
		int hit = rand.nextInt(100) + Damage()/8;
		if(hit >= (100 - HitPercent) )return true;
		return false;
	}
}
