package basics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Champions.Warrior;
public class Map {
	public final int TILE_SIZE = 25;
	private int sizeY;
	private int sizeX;
	private Boolean[][] movable_map = new Boolean[3050][3050];
	private Boolean[][] npc_map = new Boolean[3050][3050];
	private Boolean[][] interact_map = new Boolean[3050][3050];
	private Boolean[][] chest_map = new Boolean[3050][3050];
	private Boolean[][] wall_map = new Boolean[3050][3050];
	private Warrior[][] warrior_map = new Warrior[3050][3050];
	public JLabel[][] picture_map = new JLabel[3050][3050];
	PictureDataBase pic = new PictureDataBase();
	// Different constructors:
	// Default size: 150-150
	public Map()
	{
		sizeX=50;
		sizeY=50;
		setAllMovable(true);
		//------------------------
		// Initialize picture_Map
		for(int i=0;i<sizeX;i++)
			for(int j=0;j<sizeY;j++)
			{
				picture_map[i][j] = new JLabel();
			}
	}
	// Size x-x (square)
	public Map(int size)
	{
		sizeX=size;
		sizeY=size;
		setAllMovable(true);
		//------------
		// Initialize picture_Map
		for(int i=0;i<sizeX;i++)
		for(int j=0;j<sizeY;j++)
		{
			picture_map[i][j] = new JLabel();
		}
	}
	// Size x-y
	public Map(int x,int y)
	{
		sizeX=x;
		sizeY=y;
		setAllMovable(true);
		//-----------------------
		// Initialize picture_Map
		for(int i=0;i<sizeX;i++)
		for(int j=0;j<sizeY;j++)
		{
			picture_map[i][j] = new JLabel();
		}
	}
	public Map(String FilePath)
	{
		try {
			getMap(FilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//--------------------
	
	// Change sizes:
	
	// !!!!!!!!!!!!!!!!!!!!!!!!! will probably bug if I increase it (movable_map only set to movable within the first size) 
	//------ When I added the constructor from File I set everything to movable
	public void setSizeX(int x)
	{
		sizeX=x;
	}
	public void setSizeY(int y)
	{
		sizeY=y;
	}
	public int getSizeY() {
		return sizeY;
	}
	public int getSizeX() {
		return sizeX;
	}
	public void setSize(int x,int y)
	{
		sizeX=x;
		sizeY=y;
	}
	//--------------------
	
	
	// Sets a square to (not) be movable: Default movable = true
	public void setMovable(int x, int y, Boolean bool)
	{
		movable_map[x][y]=bool;
	}
	public void setMovable(int x, int y)
	{
		movable_map[x][y]=true;
	}
	
	// Sets ALL squares to (not) be movable:
	private void setAllMovable(Boolean bool)
	{
		for(int i=0;i<sizeY;i++)
			for(int j=0;j<sizeX;j++) 
				movable_map[i][j]=bool;
			
	}
	// Checks if a square is movable
	public Boolean checkMovable (int x,int y)
	{
		return movable_map[x][y];
	}
	//-------------------
	
	// Set a wall - Default wall=true
	public void setWall(int x,int y, Boolean bool)
	{
		wall_map[x][y] = bool;
		movable_map[x][y] = !bool;
	}
	public void setWall(int x,int y)
	{
		wall_map[x][y] = true;
		movable_map[x][y] = false;
	}
	//--------------------
	// Set Picture for label[x][y]
	public void setPicture(int x,int y, BufferedImage img)
	{
		picture_map[x][y].setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_FAST)));
		
	}
	// Check for wall
	public Boolean checkWall(int x,int y)
	{
		return wall_map[x][y];
	}
	//--------------------
	
	public Icon getPicture(int x,int y)
	{
		return picture_map[x][y].getIcon();
	}
	// =========================== Clear space ==========
	public void Clear(int x,int y)
	{
		setWall(x,y,false);
		setPicture(x,y,pic.Grass);
		setInteractable(x,y,false);
		setChest(x,y,false);
		setNPC(x,y,false);
		warrior_map[x][y] = null;
	}
	public Boolean isInteractable(int x,int y) {
		return interact_map[x][y];
	}
	//DEFAULT SET INTERACTABLE TRUE
	public void setInteractable(int x,int y,Boolean bool) {
		interact_map[x][y] = bool;
	}
	public void setInteractable(int x,int y) {
		interact_map[x][y] = true;
	}
	//========================================
	public Boolean isNPC(int x,int y) {
		return npc_map[x][y];
	}
	//DEFAULT SET INTERACTABLE TRUE
	public void setNPC(int x,int y,Boolean bool) {
		npc_map[x][y] = bool;
	}
	public void setNPC(int x,int y) {
		npc_map[x][y] = true;
	}
	public void setChest(int x,int y,Boolean bool) {
		chest_map[x][y] = bool;
	}
	public void setChest(int x,int y) {
		chest_map[x][y] = true;
	}
	public Boolean isChest(int x,int y) {
		return chest_map[x][y];
	}
	public Warrior getWarrior(int x,int y) {
		return warrior_map[x][y];
	}
	public void setWarrior(int x,int y) {
		warrior_map[x][y] = new Warrior();
	}
	public void INIT ()
	{
		for(int i=0;i<sizeX;i++)
		{
			for(int j=0;j<sizeY;j++) {
		       npc_map[i][j] = false;
		       interact_map[i][j] = false;
		       chest_map[i][j]=false;
			}
		}
	}
	public void Move(int x1,int y1,int x2,int y2)
	{
		movable_map[x2][y2] = movable_map[x1][y1];
		wall_map[x2][y2] = wall_map[x1][y1];
		npc_map[x2][y2] = npc_map[x1][y1];
		interact_map[x2][y2] = interact_map[x1][y1];
		picture_map[x2][y2].setIcon(picture_map[x1][y1].getIcon());
		warrior_map[x2][y2] = warrior_map[x1][y1];
		Clear(x1,y1);
	}
	//GETS MAP FROM FILE:
	private void getMap(String FilePath) throws IOException
	{
		sizeX=3000;
		sizeY=3000;
		Scanner fr = new Scanner(new File(FilePath));
	    int y=0;
	    setAllMovable(true);
	    INIT();
	    while (fr.hasNextLine())
	    {
	    	String s = fr.nextLine();
	    	s=s.replaceAll(" ", "");
	    	//System.out.println(s);
	    	for(int x=0;x<s.length();x++) 
	    	{	
	    	char c = s.charAt(x);
	    	//System.out.println(c);
	    	picture_map[x][y] = new JLabel();
	    	if(c=='t')
	    		{
	    		setPicture(x,y,pic.Tree);
	    		setMovable(x,y,false);
	    		setWall(x,y);
	    		}
	    	if(c=='n')setPicture(x,y,pic.Grass);
	    	if(c=='c')
	    		{
	    		setPicture(x,y,pic.Chest);
	    		setMovable(x,y,false);
	    		setInteractable(x,y);
	    		setChest(x,y);
	    		}
	    	if(c=='w')
	    		{
	    		setPicture(x,y,pic.Warrior);
	    		setMovable(x,y,false);
	    		setNPC(x,y);
	    		setWarrior(x,y);
	    		}
	    	}
	    	sizeX=s.length();
	    	y++;
	    	
	    }
	    sizeY=y;
	    for(int x=sizeX;x<sizeX+12;x++)
	    {
	    	
	    	for(y=0;y<sizeY+12;y++)
	    	{
	    		picture_map[x][y] = new JLabel();
	    		setPicture(x,y,pic.Tree);
	    		setMovable(x,y,false);
	    		setWall(x,y);
	    	}
	    }
	    for(int x=0;x<sizeX;x++)
	    {
	    	for(y=sizeY;y<sizeY+12;y++)
	    	{
	    		picture_map[x][y] = new JLabel();
	    		setPicture(x,y,pic.Tree);
	    		setMovable(x,y,false);
	    		setWall(x,y);
	    	}
	    }
	    
	}

}

