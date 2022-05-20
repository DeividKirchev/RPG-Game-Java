package main;
import basics.*;
import loot.Item;
import loot.chest.NormalChest;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import Champions.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final int MAP_SIZE = 10 + 1;
	final String FolderPath = System.getProperty("user.dir")+"\\src\\basics\\Maps\\";
	Menu menu = new Menu(this);
	private JPanel contentPane;
	private JPanel contentPane1;
	JButton btnExit;
	JLabel[][] tiles = new JLabel[MAP_SIZE][MAP_SIZE];
	Map map = new Map(FolderPath+"TestMap.txt");
	Backpack backpack = new Backpack();
	int moveX = -3;
	int moveY = -3;
	public int movedX=0;
	public int movedY=0;
	static final PictureDataBase pic = new PictureDataBase();
	private JLabel background;
	int targetX = 0,targetY = 0;
	NormalChest nc = new NormalChest();
	static String CharacterClass;
	
	Timer timerDMG;
	Timer timerNPC;
	public static BufferedImage playerImg;
	JLabel effect = new JLabel();
	JLabel effect1 = new JLabel();
	static Champion player;
	
	JLabel lblTargetHealth = new JLabel("");
	JLabel lblTarget = new JLabel("");
	JLabel lblTargetHealthLBL = new JLabel("Health: ");
	static JLabel lblHealth_Current = new JLabel("");
	JLabel lblGameOver = new JLabel("GAME OVER");
	
	static JLabel lblDamage_Current = new JLabel("");
	static JLabel lblArmor_Current = new JLabel("");
	public JLabel cdAB1 = new JLabel("");
	public JLabel cdAB2 = new JLabel("");
	public JLabel cdAB3= new JLabel("");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("Warrior","TestMap.txt");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public static void Heal(int heal)
	{
		player.Heal(heal);
		setStats();
		
	}
	public static void Heal()
	{
		player.FillHealth();
		setStats();
		
	}
	//==================set stats
	public static void setStats()
	{
		if(CharacterClass == "Warrior")
		{
			playerImg = pic.player_Warrior1;
		}
		if(CharacterClass == "Mage")
		{
			playerImg = pic.player_Mage;
		}
		if(CharacterClass == "Hunter")
		{
			playerImg = pic.player_Hunter;
		}				
		
		    player.setExtraArmor(Backpack.getItemArmor());
			player.setExtraHealth(Backpack.getItemHealth());
			player.setExtraDamage(Backpack.getItemDamage());		
		    lblHealth_Current.setText(Integer.toString(player.current_Health()) + " / " + Integer.toString(player.Health()));
			lblArmor_Current.setText(Integer.toString(player.Armor()));
			lblDamage_Current.setText(Integer.toString(player.Damage()));
	}
	//================= Hide the labels:==================
	private void HideLabels()
	{
		//lblabbility1.setVisible(false);
		//lblabbility1.setEnabled(false);
		//lblabbility2.setVisible(false);
		//lblabbility2.setEnabled(false);
		//lblabbility3.setVisible(false);
		//lblabbility3.setEnabled(false);
		//lblabbility4.setVisible(false);
		//lblabbility4.setEnabled(false);
	}
	//==========SET MAP METHOD==============
	private void setMap()
	{
		
		for(int i=0;i<MAP_SIZE;i++)
		{
			
			for (int j=0;j<MAP_SIZE;j++)
			{
				//System.out.print("AAAA");

				if(i==MAP_SIZE/2+moveX && j==MAP_SIZE/2+moveY)
				{
					tiles[i][j].setIcon(new ImageIcon(playerImg.getScaledInstance(50, 50, Image.SCALE_FAST)));
					continue;
				}
				//------------------------------------
				//System.out.println(map.getSizeX());
				//System.out.println(movedX);
				try {
				tiles[i][j].setIcon(map.getPicture(i+movedX,j+movedY));
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				tiles[i][j].setFocusable(false);
				
			}
			
			
		}
	}
	// set map for single position
	public void setMap(int i,int j)
	{
		if(i<0 || i>10 || j<0 || j>10)return;
		if(i==MAP_SIZE/2+moveX && j==MAP_SIZE/2+moveY)
		{
			tiles[i][j].setIcon(new ImageIcon(playerImg.getScaledInstance(50, 50, Image.SCALE_FAST)));
			return;
		}
		//------------------------------------
		//System.out.println(map.getSizeX());
		//System.out.println(movedX);
		try {
		tiles[i][j].setIcon(map.getPicture(i+movedX,j+movedY));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tiles[i][j].setFocusable(false);
	}
	
	//=============================SET MAP ON START ONLY=======================
    private void setMapStart()
	{
		for(int i=0;i<MAP_SIZE;i++)
		{
			
			for (int j=0;j<MAP_SIZE;j++)
			{
				//System.out.print("AAAA");
				JLabel tmp = new JLabel();
				
				
				tiles[i][j] = tmp;
				if(i==2 && j==2)
				{
					
					tiles[i][j].setIcon(new ImageIcon(playerImg.getScaledInstance(50, 50, Image.SCALE_FAST)));
					tiles[i][j].setBounds(50+i*50,50+j*50,50,50);
					contentPane.add(tiles[i][j]);
					continue;
				}
				//------------------------------------
				try {
				tiles[i][j].setIcon(map.getPicture(i, j));
				tiles[i][j].setBounds(50+i*50,50+j*50,50,50);
				contentPane.add(tiles[i][j]);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				tiles[i][j].setFocusable(false);
				
			}
			
			
		}
	}
	//====================PRESSED KEY====================
	public void CheckPressedKey (KeyEvent e) throws InterruptedException
	{
		if(player.Alive()==false)return;
		HideLabels();
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			contentPane.hide();
			menu.getContentPane().show();
			contentPane.show();
			this.setContentPane(menu.getContentPane());
			menu.btnExit.requestFocusInWindow();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyChar()=='w')
		{
			if(movedY == 0 && moveY==-5)return;
			
			if(map.checkMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY-1+movedY)) {
				if(moveY == -5)
					{
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY-1+movedY,false);
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
					moveY--;
					
					}
				else {
			map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY-1+movedY,false);
			map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
			moveY--;
			setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY+1);
			setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY);
			
			
			//moveNPC();
			}}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyChar()=='s')
		{
			if(movedY == map.getSizeY()-12 && moveY==5)return;
			if(map.checkMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+1+movedY)) {
				if(moveY == 5) {
					
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+1+movedY,false);
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
					moveY++;
				}
				else {
			map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+1+movedY,false);
			map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
			moveY++;
			setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY-1);
			setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY);
			
			//moveNPC();
			}}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyChar()=='a')
		{
			if(movedX == 0 && moveX==-5)return;
			if(map.checkMovable(MAP_SIZE/2+moveX-1+movedX,MAP_SIZE/2+moveY+movedY)) {
				if(moveX == -5) {
					map.setMovable(MAP_SIZE/2+moveX+movedX-1,MAP_SIZE/2+moveY+movedY,false);
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
					moveX--;
				}
				else {
				map.setMovable(MAP_SIZE/2+moveX+movedX-1,MAP_SIZE/2+moveY+movedY,false);
				map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
				moveX--;
				setMap(MAP_SIZE/2+moveX+1,MAP_SIZE/2+moveY);
				setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY);
			
			//moveNPC();
			}}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyChar()=='d')
		{
			if(movedX == map.getSizeX()-12 && moveX==5)return;
			if(map.checkMovable(MAP_SIZE/2+moveX+1+movedX,MAP_SIZE/2+moveY+movedY)) {
				if(moveX == 5) {
					
					map.setMovable(MAP_SIZE/2+moveX+movedX+1,MAP_SIZE/2+moveY+movedY,false);
					map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
					moveX++;
				}
				else {
				map.setMovable(MAP_SIZE/2+moveX+movedX+1,MAP_SIZE/2+moveY+movedY,false);
				map.setMovable(MAP_SIZE/2+moveX+movedX,MAP_SIZE/2+moveY+movedY,true);
				moveX++;
				setMap(MAP_SIZE/2+moveX-1,MAP_SIZE/2+moveY);
				setMap(MAP_SIZE/2+moveX,MAP_SIZE/2+moveY);
			
			//moveNPC();
			}}
		}
		if(e.getKeyChar()=='q')
		{ 
			//System.out.println(targetX+ " " + targetY);
			if(player.abbility1.cast(map, targetX, targetY, moveX+movedX+5, moveY+movedY+5,this))
			{
				/*effect.setVisible(true);
				effect.setIcon(player.abbility1.getEffect());
				effect.setBounds((targetX-movedX)*50+50,(targetY-movedY)*50+50,50,50);
				timerDMG.start();*/
				
				target(targetX,targetY);
				if(map.getWarrior(targetX, targetY) != null) 
				{
				if(!map.getWarrior(targetX,targetY).Alive())
				{
					map.Clear(targetX,targetY);
					setMap(targetX - movedX,targetY  -movedY);
					untarget();
					getLoot();
				}
				}
			}
		}
		if(e.getKeyChar()=='e')
		{
			//System.out.println(targetX+ " " + targetY);
			if(player.abbility2.cast(map, targetX, targetY, moveX+movedX+5, moveY+movedY+5,this))
			{
				/*effect.setVisible(true);
				effect.setIcon(player.abbility2.getEffect());
				effect.setBounds((targetX-movedX)*50+50,(targetY-movedY)*50+50,50,50);
				timerDMG.start();*/
				
				target(targetX,targetY);
				if(map.getWarrior(targetX, targetY) != null) 
				{
				if(!map.getWarrior(targetX,targetY).Alive())
				{
					map.Clear(targetX,targetY);
					setMap(targetX - movedX,targetY - movedY);
					untarget();
					getLoot();
				}
				}
			}
		}
		if(e.getKeyChar()=='1')
		{
			//System.out.println(targetX+ " " + targetY);
			if(player.abbility3.cast(map, targetX, targetY, moveX+movedX+5, moveY+movedY+5,this))
			{
				/*effect.setVisible(true);
				effect.setIcon(player.abbility3.getEffect());
				effect.setBounds((targetX-movedX)*50+50,(targetY-movedY)*50+50,50,50);
				timerDMG.start();*/
			}
		}
		//System.out.println(moveX+" "+moveY);
		if(Math.abs(moveX) > 5 || Math.abs(moveY)>5)
		{
			moveMap();
			setMap();
		}
		effect1.setBounds((moveX+5)*50+50,(moveY+5)*50+50,50,50);
		
	}
	//========================================================
	//=================Move map==============================
	private void moveMap()
	{
		if(moveX > 5)
		{
			moveX=-5;
			movedX=movedX+11;
		}
		if(moveX < -5)
		{
			moveX=5;
			movedX=movedX-11;
		}
		if(moveY > 5)
		{
			moveY=-5;
			movedY=movedY+11;
		}
		if(moveY < -5)
		{
			moveY=5;
			movedY=movedY-11;
		}
		
	}
	
	//========================================================
	//=========================================================================================================Move NPCs======================================
	private void moveNPC() throws InterruptedException
	{
		
		//------------------ Can be optimized - lower range
		Boolean[][] moved = new Boolean[map.getSizeX()+11][map.getSizeY()+11];
		for(int i=movedX;i<11+movedX;i++)
			for(int j=movedY;j<11+movedY;j++)
				moved[i][j]=false;
		
		//----------------------
		
		for(int i=movedX;i<11+movedX;i++)
		{
			for(int j=movedY;j<11+movedY;j++)
			{
				if(map.isNPC(i,j) && moved[i][j]==false)
				{
					if(NPCattack(i,j))
					{
						lblHealth_Current.setText(Integer.toString(player.current_Health())  + " / " + Integer.toString(player.Health()));
						if(player.Alive() == false)
						{
							
							lblGameOver.setVisible(true);
							timerNPC.stop();
						}
						continue;
					}
					Random rand = new Random();
					int move = rand.nextInt(5);
					int x=i-movedX;
					int y=j-movedY;
					if(move == 0 && map.checkMovable(i + 1, j))
					{
							
						map.Move(i, j, i + 1, j);
						moved[i+1][j] = true;
						setMap(x,y);
						setMap(x+1,y);
						if(targetX == x+movedX && targetY == y+movedY)targetX++;
						continue;
					}
					if(move == 1 && map.checkMovable(i - 1, j))
					{
						map.Move(i, j, i - 1, j);
						moved[i-1][j] = true;
						setMap(x,y);
						setMap(x-1,y);
						if(targetX == x+movedX && targetY == y+movedY)targetX--;
						continue;
					}
					if(move == 2 && map.checkMovable(i, j + 1))
					{
						map.Move(i, j, i, j + 1);
						moved[i][j+1] = true;
						setMap(x,y);
						setMap(x,y+1);
						if(targetX == x+movedX && targetY == y+movedY)targetY++;
						continue;
					}
					if(move == 3 && map.checkMovable(i, j - 1))
					{
						map.Move(i, j, i, j - 1);
						moved[i][j-1] = true;
						setMap(x,y);
						setMap(x,y-1);
						if(targetX == x+movedX && targetY == y+movedY)targetY--;
						continue;
					}
				}
			}
		}
		
	}
	private Boolean NPCattack(int x,int y)
	{
		int clx=moveX + movedX + 5;
		int cly=moveY + movedY + 5;
		if(Math.abs(clx-x) >= 3 || Math.abs(cly-y) >= 3)
		{
			return false;
		}
		
		if(Math.abs(clx-x) <= 1 && Math.abs(cly-y) <= 1)
		{
			if(player.current_Health()<35)
			{
				
				if(map.getWarrior(x, y).Execute(player))
				{
				effect1.setVisible(true);
				effect1.setIcon(pic.blood_effect);
				timerDMG.start();
				}
				return true;
			}
			Random rand = new Random();
			int r = rand.nextInt(2);
			
			if(r==0)
			if(map.getWarrior(x, y).baseHit(player))
			{
				effect1.setVisible(true);
				effect1.setIcon(pic.sword_effect);
				timerDMG.start();
				
			}
			if(r==1)
			if(map.getWarrior(x, y).heavyHit(player))
			{
				effect1.setVisible(true);
				effect1.setIcon(pic.sword_effect);
				timerDMG.start();
				
			}
			return true;
		}
		
		if(map.getWarrior(x, y).ThrowWeapon(player))
		{
			effect1.setVisible(true);
			effect1.setIcon(pic.throw_effect);
			effect1.setBounds((moveX+5)*50+50,(moveY+5)*50+50,50,50);
			timerDMG.start();
		}
		
		return true;
	}
	//==============================================================Target NPC================================
	public void target(int x,int y)
	{
		if(!map.isNPC(x, y))
			{
			untarget();
			return;
			}
		targetX = x;
		targetY = y;
		BufferedImage bi = new BufferedImage(
			    map.getPicture(x, y).getIconWidth(),
			    map.getPicture(x, y).getIconHeight(),
			    BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.createGraphics();
			 map.getPicture(x, y).paintIcon(null, g, 0,0);
			g.dispose();
			
		lblTarget.setIcon(new ImageIcon(bi.getScaledInstance(100, 100, Image.SCALE_FAST)));
		lblTarget.setEnabled(true);
		lblTarget.setVisible(true);
		lblTargetHealthLBL.setVisible(true);
		lblTargetHealth.setText(Integer.toString(map.getWarrior(x, y).current_Health()));
		lblTargetHealth.setVisible(true);
	}
	private void untarget()
	{
		lblTarget.setEnabled(false);
		lblTarget.setVisible(false);
		lblTargetHealthLBL.setVisible(false);
		lblTargetHealth.setVisible(false);
	}
	
	////////////////////////////////////////////////////////// TEMPORARY ///////////////////////////////// WILL FIX ///////////////////////////////////////////////
	public void getLoot()
	{
		Item item = nc.getLoot();
		if(CharacterClass == "Warrior") {
		//System.out.println(playerWarrior.getExtraArmor());
		player.setExtraArmor(player.getExtraArmor() + item.getArmor());
		//System.out.println(playerWarrior.getExtraArmor());
		player.setExtraDamage(player.getExtraDamage() + item.getDamage());
		player.setExtraHealth(player.getExtraHealth() + item.getHealth());
		}
		setStats();
		backpack.addItem(item);
	}
	
	public void switchContentPane()
	{
	    contentPane1.hide();
	    menu.getContentPane().hide();
	    this.setContentPane(contentPane);
	    contentPane.show();
	    btnExit.requestFocus();
	    timerNPC.start();
	}
	//=======================FRAME=============================
	
	
	public MainFrame(String CharacterClass,String Map){
		
        
		this.setIconImage(pic.warrior_trans);
		map  = new Map(FolderPath+Map);
		//backpack.hide();
		MainFrame.CharacterClass = CharacterClass;
		setResizable(false);
		//System.out.println(System.getProperty("user.dir"));
		//======================CONTENT PANE=========================================
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 687);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cdAB2.setBounds(684, 316, 50, 50);
		
		contentPane.add(cdAB2);
		cdAB3.setBounds(743, 316, 50, 50);
		
		contentPane.add(cdAB3);
		
		cdAB1.setBounds(624, 316, 50, 50);
		contentPane.add(cdAB1);
		
		contentPane.add(effect);
		contentPane.add(effect1);
		
		Talents t = new Talents(this);
		contentPane1 = (JPanel) t.getContentPane();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		this.addMouseListener(new MouseListener()
		{
	public void mouseClicked(MouseEvent e)
	{
		
		if(player.Alive()==false)return;
		int x= (e.getX()-55)/50;
		int y= (e.getY()-80)/50;
		if(!map.isNPC(x+movedX, y+movedY))
		{
			untarget();
			if(map.isChest(x+movedX,y+movedY) && Math.abs(x-( moveX + 5))<=1 && Math.abs(y-(moveY + 5))<=1)
			{
				getLoot();
				map.Clear(x+movedX, y+movedY);
				setMap(x,y);
			}
			return;
		}
		target(x+movedX,y+movedY);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
		});
		//============================================================================
		 ActionListener player_dmgTaken = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  effect.setVisible(false);
		    	  effect1.setVisible(false);
		      }
		  };
		  ActionListener npc_mover = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  try {
					moveNPC();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		      }
		  };
		timerDMG = new Timer(500,player_dmgTaken);
		timerDMG.setRepeats(false);
		timerNPC = new Timer(1250,npc_mover);
		timerNPC.setRepeats(true);
		
		
		
		lblGameOver.setVisible(false);
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblGameOver.setBounds(151, 199, 415, 161);
		contentPane.add(lblGameOver);
		

		lblTargetHealth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTargetHealth.setBounds(696, 79, 97, 34);
		contentPane.add(lblTargetHealth);
		lblTargetHealthLBL.setVisible(false);
		
		
		lblTargetHealthLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTargetHealthLBL.setBounds(626, 79, 97, 34);
		contentPane.add(lblTargetHealthLBL);
		
		
		lblTarget.setBounds(773, 79, 100, 100);
		contentPane.add(lblTarget);
		
		JButton btnBackpack = new JButton("Backpack");
		btnBackpack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backpack.show();
			}
		});
		btnBackpack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackpack.setFocusable(false);
		btnBackpack.setBounds(773, 377, 130, 46);
		contentPane.add(btnBackpack);
		//----------------------------------------------
		JButton btnTalents = new JButton("Talents");
		btnTalents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				setContentPane(contentPane1);
				contentPane1.show();
				
			}
		});
		btnTalents.setFocusable(false);
		btnTalents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTalents.setBounds(626, 377, 130, 46);
		contentPane.add(btnTalents);
		
		JLabel lblHealth = new JLabel("Health: ");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHealth.setBounds(684, 434, 97, 34);
		contentPane.add(lblHealth);
		
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArmor.setBounds(684, 479, 97, 34);
		contentPane.add(lblArmor);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDamage.setBounds(684, 524, 97, 34);
		contentPane.add(lblDamage);
		
		
		lblHealth_Current.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHealth_Current.setBounds(791, 434, 97, 34);
		contentPane.add(lblHealth_Current);
		
		
		lblArmor_Current.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArmor_Current.setBounds(791, 479, 97, 34);
		contentPane.add(lblArmor_Current);
		
		
		lblDamage_Current.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDamage_Current.setBounds(791, 524, 97, 34);
		contentPane.add(lblDamage_Current);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(751, 569, 137, 46);
		contentPane.add(btnExit);
		
	
		//======================CHARACTER===================
		if(CharacterClass == "Warrior")
			player = new Warrior(100,35,20,this);
		if(CharacterClass == "Mage")
			player = new Mage(100,15,35);
		if(CharacterClass == "Hunter")
			player = new Hunter(100,15,35);
		setStats();
		
		
		//---------------------------------------------------------
		setMapStart();
		//===========================BACKGROUND=======================
				background = new JLabel();
				background.setLocation(0, 0);
				background.setFocusable(false);
				background.setSize(new Dimension(924, 687));
				background.setIcon(new ImageIcon(pic.MedievalBG.getScaledInstance(this.getSize().width, this.getSize().height,Image.SCALE_FAST)));
				background.setOpaque(false);
				contentPane.add(background);
				
				
				
				btnExit.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						try {
							CheckPressedKey(e);
						} catch (InterruptedException e1) {
							
							e1.printStackTrace();
						}
					}
				});
				timerNPC.start();
				//contentPane.hide();
				//==================================================
	}
}
