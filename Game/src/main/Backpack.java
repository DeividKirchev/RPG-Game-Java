package main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import basics.PictureDataBase;
import loot.Item;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Dimension;

public class Backpack extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	static Item itemHelmet;
	static Item itemChest;
	static Item itemLegs;
	static Item itemWeaponRight;
	static Item itemWeaponLeft;
	static Item itemExtra;
	Item swap1;
	Item swap2;
	JLabel swap;
	JLabel movingLabel = new JLabel();
	PictureDataBase pic = new PictureDataBase();
	JLabel lblExtra = new JLabel("");
	JLabel lblLegs = new JLabel("");
	JLabel lblWeaponRight = new JLabel("");
	JLabel lblWeaponLeft = new JLabel("");
	JLabel lblChest = new JLabel("");
	JLabel lblHelmet = new JLabel("");
	JEditorPane paneStats = new JEditorPane();
	JLabel[] inventory = new JLabel[15];
	Boolean dragging = false;
	static Item[] inventory_items = new Item[15];
	
	    MouseAdapter a = new MouseAdapter()
			{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			MainFrame.lblHealth.requestFocusInWindow();
			
			if(!MainFrame.player.Alive())return;
			dragging = true;
			swap = null;
			JLabel l = (JLabel) e.getSource();
			swap = l;
			swap1 = null;
			if(l.getName() == lblExtra.getName())
				{
				swap1 = itemExtra;
				}
			if(l.getName() == lblChest.getName())
			    {
				swap1 = itemChest;
				}
			if(l.getName() == lblLegs.getName())
			    {
				swap1 = itemLegs;
				}
			if(l.getName() == lblHelmet.getName())
				{
				swap1 = itemHelmet;
				}
			if(l.getName() == lblWeaponRight.getName())
				{
				swap1 = itemWeaponRight;
				}
			if(l.getName() == lblWeaponLeft.getName())
				{
				swap1 = itemWeaponLeft;
				}
			for(int i=0;i<15;i++)
			{
				if(l.getName() == inventory[i].getName())
					{
					swap1 = inventory_items[i];
					}
			}
			//System.out.println(swap1.getName());
			//System.out.println(l.getName());
		}

		public void mouseReleased(MouseEvent e) 
		{
			if(!MainFrame.player.Alive())return;
			dragging=false;
			movingLabel.setVisible(false);
			if(swap1 == null)return;
			JLabel l1 = (JLabel) e.getSource();
			int x = (e.getX()+l1.getX())/60;
			int y = (e.getY()+l1.getY()-20)/60;
			//System.out.println(x+" "+y);
			JLabel l = new JLabel();
			if(x==1 && y==0)l=lblHelmet;
			if(x==1 && y==1)l=lblChest;
			if(x==1 && y==2)l=lblLegs;
			if(x==0 && y==1)l=lblWeaponLeft;
			if(x==2 && y==1)l=lblWeaponRight;
			if(x==0 && y==2)l=lblExtra;
			
			for(int i=0;i<3;i++)
			{ 
				for(int j=0;j<=4;j++)
			{
				if(x==j+4 && y == i) l = inventory[i*5+j];
			}
			}
			
		    //System.out.println(l.getName());
			//System.out.println("swap" + swap1.getName());
			    Boolean f = false;
			    
				swap2=null;
				//System.out.println("here");
				if(l.getName() == lblExtra.getName())
					{
					if(swap1.type != Item.Type.EXTRA)return;
					swap2 = itemExtra;
					itemExtra = swap1;
					f = true;
					}
				if(l.getName() == lblChest.getName())
					{
					if(swap1.type != Item.Type.CHEST)return;
					swap2 = itemChest;
					itemChest = swap1;
					f = true;
					}
				if(l.getName() == lblLegs.getName())
					{
					if(swap1.type != Item.Type.LEGS)return;
					swap2 = itemLegs;
					itemLegs= swap1;
					f = true;
					}
				if(l.getName() == lblHelmet.getName()){
					if(swap1.type != Item.Type.HELMET)return;
					
					swap2 = itemHelmet;
					itemHelmet = swap1;
					f = true;
					//System.out.println("hereeeee");
					}
				if(l.getName() == lblWeaponRight.getName())
					{
					if(swap1.type != Item.Type.WEAPON)return;
					swap2 = itemWeaponRight;
					itemWeaponRight = swap1;
					f = true;
					
					}
				if(l.getName() == lblWeaponLeft.getName())
					{
					if(swap1.type != Item.Type.WEAPON)return;
					swap2 = itemWeaponLeft;
					itemWeaponLeft = swap1;
					f = true;
					}
				for(int i=0;i<15;i++)
				{
					if(l.getName() == inventory[i].getName())
						{
						swap2 = inventory_items[i];
						inventory_items[i] = swap1;
						f = true;
						}
				}
				if(f == false)return;
				setIcon(l);
			//if(swap2!=null)System.out.println("swap 2 " + swap2.getName());
			
			
				if(swap.getName() == lblExtra.getName())
				{
				itemExtra = swap2;
				}
			if(swap.getName() == lblChest.getName())
				{
				itemChest = swap2;
				}
			if(swap.getName() == lblLegs.getName())
				{
				itemLegs = swap2;
				}
			if(swap.getName() == lblHelmet.getName())
				{
				itemHelmet = swap2;
				}
			if(swap.getName() == lblWeaponLeft.getName())
				{
				itemWeaponLeft = swap2;
				}
			if(swap.getName() == lblWeaponRight.getName())
				{
				itemWeaponRight = swap2;
				}
			for(int i=0;i<15;i++)
			{
				if(swap.getName() == inventory[i].getName())
					{
					inventory_items[i] = swap2;
					}
			}
			setIcon(swap);
			//System.out.println("------------------------");
			
			MainFrame.setStats();
			//movingLabel.setVisible(false);
       }
			
		

		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!MainFrame.player.Alive())return;
			JLabel l = (JLabel) e.getSource();
			if (e.getClickCount() == 2 && !e.isConsumed()) 
			{
				if(l.getName() == lblExtra.getName())
				{
					if(itemExtra == null || used() == 15)return;
				addItem(itemExtra);
				itemExtra = null;
				setIcon(lblExtra);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			if(l.getName() == lblChest.getName())
				{
				if(itemChest == null || used() == 15 )return;
				addItem(itemChest);
				itemChest = null;
				setIcon(lblChest);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			if(l.getName() == lblLegs.getName())
				{
				if(itemLegs == null || used() == 15)return;
				addItem(itemLegs);
				itemLegs = null;
				setIcon(lblLegs);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			if(l.getName() == lblHelmet.getName())
				{
				if(itemHelmet == null || used() == 15 )return;
				addItem(itemHelmet);
				itemHelmet = null;
				setIcon(lblHelmet);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			if(l.getName() == lblWeaponLeft.getName())
				{
				if(itemWeaponLeft == null || used() == 15)return;
				addItem(itemWeaponLeft);
				itemWeaponLeft = null;
				setIcon(lblWeaponLeft);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			if(l.getName() == lblWeaponRight.getName())
				{
				if(itemWeaponRight == null || used() == 15)return;
				addItem(itemWeaponRight);
				itemWeaponRight = null;
				setIcon(lblWeaponRight);
				paneStats.hide();
				MainFrame.setStats();
				return;
				}
			for(int i=0;i<15;i++)
			{
				if(l.getName() == inventory[i].getName())
					{
					if(inventory_items[i]==null)return;
					
					if(inventory_items[i].type == Item.Type.EXTRA)
					{
						swap1 = itemExtra;
						itemExtra = inventory_items[i];
						inventory_items[i] = swap1;
						setIcon(lblExtra);
						setIcon(inventory[i]);
						paneStats.hide();
						MainFrame.setStats();
						return;
					}
					if(inventory_items[i].type == Item.Type.CHEST)
					{
						swap1 = itemChest;
						itemChest = inventory_items[i];
						inventory_items[i] = swap1;
						setIcon(lblChest);
						setIcon(inventory[i]);
						paneStats.hide();
						MainFrame.setStats();
						return;
					}
					if(inventory_items[i].type == Item.Type.LEGS)
					{
						swap1 = itemLegs;
						itemLegs = inventory_items[i];
						inventory_items[i] = swap1;
						setIcon(lblLegs);
						setIcon(inventory[i]);
						paneStats.hide();
						MainFrame.setStats();
						return;
					}
					if(inventory_items[i].type == Item.Type.WEAPON)
					{
						if(itemWeaponLeft == null || itemWeaponRight !=null) {
						swap1 = itemWeaponLeft;
						itemWeaponLeft = inventory_items[i];
						inventory_items[i] = swap1;
						setIcon(lblWeaponLeft);
						}
						else
						{
							swap1 = itemWeaponRight;
							itemWeaponRight = inventory_items[i];
							inventory_items[i] = swap1;
							setIcon(lblWeaponRight);
						}
						setIcon(inventory[i]);
						paneStats.hide();
						MainFrame.setStats();
						return;
					}
					if(inventory_items[i].type == Item.Type.HELMET)
					{
						swap1 = itemHelmet;
						itemHelmet = inventory_items[i];
						inventory_items[i] = swap1;
						setIcon(lblHelmet);
						setIcon(inventory[i]);
						paneStats.hide();
						MainFrame.setStats();
						return;
					}
					
					}
			}
			     e.consume();
			     return;
			}
			
		for(int i=0;i<15;i++)
		{
			if(l.getName() == inventory[i].getName())
				{
				
				if(inventory_items[i] == null)return;
				
				if(inventory_items[i].type == Item.Type.HEAL25) {
					MainFrame.Heal(25);
					inventory[i].setIcon(new ImageIcon(pic.board.getScaledInstance(50, 50, Image.SCALE_FAST)));
					inventory_items[i] = null;
					return;
				}
				if(inventory_items[i].type == Item.Type.HEAL50) {
					MainFrame.Heal(50);
					inventory[i].setIcon(new ImageIcon(pic.board.getScaledInstance(50, 50, Image.SCALE_FAST)));
					inventory_items[i] = null;
					return;
				}
				if(inventory_items[i].type == Item.Type.HEALFULL) {
					MainFrame.Heal();
					inventory[i].setIcon(new ImageIcon(pic.board.getScaledInstance(50, 50, Image.SCALE_FAST)));
					inventory_items[i] = null;
					return;
				}
				}
		}
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
				JLabel l = (JLabel) e.getSource();
				//System.out.println(l.getName());
				if(l.getName() == lblExtra.getName())
				{
					if(itemExtra != null)showStats(itemExtra,l.getX()+l.getWidth(),l.getY()+l.getHeight()-102);
				}
			if(l.getName() == lblChest.getName())
				{
				if(itemChest != null)showStats(itemChest,l.getX()+l.getWidth(),l.getY()+l.getHeight());
				}
			if(l.getName() == lblHelmet.getName())
				{
				if(itemHelmet != null)showStats(itemHelmet,l.getX()+l.getWidth(),l.getY()+l.getHeight());
				}
			if(l.getName() == lblLegs.getName())
				{
				if(itemLegs != null)showStats(itemLegs,l.getX()+l.getWidth(),l.getY()+l.getHeight()-102);
				}
			if(l.getName() == lblWeaponLeft.getName())
				{
				if(itemWeaponLeft != null)showStats(itemWeaponLeft,l.getX()+l.getWidth(),l.getY()+l.getHeight());
				}
			if(l.getName() == lblWeaponRight.getName())
				{
				if(itemWeaponRight != null)showStats(itemWeaponRight,l.getX()+l.getWidth(),l.getY()+l.getHeight());
				}
			    for(int i=0;i<10;i++)
			     {
				    if(l.getName() == inventory[i].getName())
					{
					if(inventory_items[i] != null)showStats(inventory_items[i],l.getX()+l.getWidth(),l.getY()+l.getHeight());
					}
				
		          }
			    for(int i=10;i<15;i++)
			     {
				    if(l.getName() == inventory[i].getName())
					{
					if(inventory_items[i] != null)showStats(inventory_items[i],l.getX()+l.getWidth(),l.getY()+l.getHeight()-102);
					}
				
		          }
		}

		@Override
		public void mouseExited(MouseEvent e) {
			e.consume();
			paneStats.setVisible(false);
			
		}

			
			};	
			
			
			
			
			public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Backpack frame = new Backpack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
			//===========================================================================================================================
			
		 MouseAdapter ml = new MouseAdapter()
			{

				@Override
				public void mouseDragged(MouseEvent e) 
				{
					if(swap1 == null)return;
					
				   movingLabel.setVisible(true);
				   movingLabel.setText(swap.getText());
				   movingLabel.setIcon(swap.getIcon());
				   movingLabel.setBounds(e.getX()+swap.getX()-25, e.getY()+swap.getY()-25,50,50 );
				   if(!dragging)movingLabel.setVisible(false);

				}

				@Override
				public void mouseMoved(MouseEvent e)
				{
					
				}
			};
			
			
			//=====================================================================================================================================
	public void setIcon(JLabel swap)
	{
		if(swap.getName() == lblExtra.getName())
		{
			lblExtra.setIcon(null);
			if(itemExtra == null)
			{
				lblExtra.setText("");
				lblExtra.setIcon(new ImageIcon(pic.boardExtra.getScaledInstance(50, 50, Image.SCALE_FAST)));
				return;
			}
			if(itemExtra.getName()!=null)lblExtra.setText(itemExtra.getName());
			if(itemExtra.Icon != null) {
		lblExtra.setIcon(new ImageIcon(itemExtra.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblExtra.setText("");
			}
			
			
		
		}
		
	if(swap.getName() == lblChest.getName())
		{
		lblChest.setIcon(null);
		if(itemChest == null)
			{
				lblChest.setText("");
				lblChest.setIcon(new ImageIcon(pic.boardChest.getScaledInstance(50, 50, Image.SCALE_FAST)));
				return;
			}
		if(itemChest.getName()!=null)lblChest.setText(itemChest.getName());
		
		   if(itemChest.Icon != null) {
			lblChest.setIcon(new ImageIcon(itemChest.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			lblChest.setText("");
		   }
		   
			
			
		}
	if(swap.getName() == lblLegs.getName())
		{
		lblLegs.setIcon(null);
		if(itemLegs == null)
			{
				lblLegs.setText("");
				lblLegs.setIcon(new ImageIcon(pic.boardLegs.getScaledInstance(50, 50, Image.SCALE_FAST)));
				return;
			}
		
		if(itemLegs.getName()!=null)lblLegs.setText(itemLegs.getName());
			
			if(itemLegs.Icon != null) {
			lblLegs.setText("");
			lblLegs.setIcon(new ImageIcon(itemLegs.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			}
			
			
			
		}
	    if(swap.getName() == lblHelmet.getName())
		{
		lblHelmet.setIcon(null);
		if(itemHelmet == null)
		{
			lblHelmet.setText("");
			lblHelmet.setIcon(new ImageIcon(pic.boardHelmet.getScaledInstance(50, 50, Image.SCALE_FAST)));
			return;
		}
		if(itemHelmet.getName()!=null)lblHelmet.setText(itemHelmet.getName());
			
			if(itemHelmet.Icon != null) {
			lblHelmet.setText("");
			lblHelmet.setIcon(new ImageIcon(itemHelmet.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			}
			
		}
	if(swap.getName() == lblWeaponLeft.getName())
		{
		lblWeaponLeft.setIcon(null);
		 if(itemWeaponLeft == null)
			{
				lblWeaponLeft.setText("");
				lblWeaponLeft.setIcon(new ImageIcon(pic.boardWeaponL.getScaledInstance(50, 50, Image.SCALE_FAST)));
				return;
			}
		if(itemWeaponLeft.getName()!=null)lblWeaponLeft.setText(itemWeaponLeft.getName());
		 if(itemWeaponLeft.Icon != null) {
			lblWeaponLeft.setIcon(new ImageIcon(itemWeaponLeft.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			lblWeaponLeft.setText("");
		 }
		
			
		}
	if(swap.getName() == lblWeaponRight.getName())
		{
		
		lblWeaponRight.setIcon(null);
		if(itemWeaponRight == null)
		{
			lblWeaponRight.setText("");
			lblWeaponRight.setIcon(new ImageIcon(pic.boardWeaponR.getScaledInstance(50, 50, Image.SCALE_FAST)));
			return;
		}
		if(itemWeaponRight.getName()!=null)lblWeaponRight.setText(itemWeaponRight.getName());
			if(itemWeaponRight.Icon != null) {
			lblWeaponRight.setText("");
			lblWeaponRight.setIcon(new ImageIcon(itemWeaponRight.Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			}
			
		}
	
	for(int i=0;i<15;i++)
	{
		//System.out.println(i);
		if(swap.getName() == inventory[i].getName())
			{
			
			inventory[i].setIcon(null);
			if(inventory_items[i] == null)
			{
				inventory[i].setText("");
				inventory[i].setIcon(new ImageIcon(pic.board.getScaledInstance(50, 50, Image.SCALE_FAST)));
				return;
			}
			if(inventory_items[i].getName()!=null)inventory[i].setText(inventory_items[i].getName());
			if(inventory_items[i].Icon != null) 
			{
					inventory[i].setText("");
			inventory[i].setIcon(new ImageIcon(inventory_items[i].Icon.getScaledInstance(50, 50, Image.SCALE_FAST)));
			}
			
			}
	}
	}
	public void showStats(Item item,int x,int y)
	{
		paneStats.setBounds(x, y,125,175);
		paneStats.setText(item.getName() + "\r\n" + "Health: " + item.getHealth() + "\r\n" + "Armor: " + item.getArmor() + "\r\n" + "Damage: " + item.getDamage() + "\r\n");
		paneStats.setVisible(true);
	}
	public void showStats(int x,int y)
	{
		paneStats.setBounds(x, y,125,175);
	}
	public int used()
	{
		int br = 0;
		for(int i=0;i<15;i++)
		{
			if(inventory_items[i] != null)br++;
		}
		return br;
		
	}
	public void setInventory()
	{
		for(int i=0;i<3;i++)
		{ 
			for(int j=0;j<5;j++)
		       {
			inventory[i*5+j] = new JLabel();
			contentPane.add(inventory[i*5+j]);
			inventory[i*5+j].setBounds((j+4)*60,i*60+20,50,50);
			inventory[i*5+j].setIcon(new ImageIcon(pic.board.getScaledInstance(50, 50, Image.SCALE_FAST)));
			inventory[i*5+j].addMouseListener(a);
			inventory[i*5+j].setName("inv"+Integer.toString(i*5+j));
			inventory[i*5+j].addMouseMotionListener(ml);
		      }
		}
		//----------------------------------------------------------------------------------------
		lblExtra.setIcon(new ImageIcon(pic.boardExtra.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblLegs.setIcon(new ImageIcon(pic.boardLegs.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblChest.setIcon(new ImageIcon(pic.boardChest.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblHelmet.setIcon(new ImageIcon(pic.boardHelmet.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblWeaponRight.setIcon(new ImageIcon(pic.boardWeaponR.getScaledInstance(50, 50, Image.SCALE_FAST)));
		lblWeaponLeft.setIcon(new ImageIcon(pic.boardWeaponL.getScaledInstance(50, 50, Image.SCALE_FAST)));
		//------------------------------------------------------------------------------------------------
		lblExtra.setName("lblExtra");
		lblLegs.setName("lblLegs");
		lblChest.setName("lblChest");
		lblHelmet.setName("lblHelmet");
		lblWeaponRight.setName("lblWeaponRight");
		lblWeaponLeft.setName("lblWeaponLeft");
		//------------------------------------------------------------------------------------------------
		lblExtra.addMouseListener(a);
        lblLegs.addMouseListener(a);
		lblChest.addMouseListener(a);
		lblHelmet.addMouseListener(a);
		lblWeaponRight.addMouseListener(a);
		lblWeaponLeft.addMouseListener(a);
		//-------------------------------------
		lblExtra.addMouseMotionListener(ml);
        lblLegs.addMouseMotionListener(ml);
		lblChest.addMouseMotionListener(ml);
		lblHelmet.addMouseMotionListener(ml);
		lblWeaponRight.addMouseMotionListener(ml);
		lblWeaponLeft.addMouseMotionListener(ml);
		//--------------------------------------
		/*lblExtra.addMouseMotionListener(hideml);
        lblLegs.addMouseMotionListener(hideml);
		lblChest.addMouseMotionListener(hideml);
		lblHelmet.addMouseMotionListener(hideml);
		lblWeaponRight.addMouseMotionListener(hideml);
		lblWeaponLeft.addMouseMotionListener(hideml);
		this.addMouseMotionListener(hideml);*/
		
	}
	public static int getItemArmor()
	{
		int armor =0;
		if(itemExtra!=null)armor = armor + itemExtra.getArmor();
		if(itemChest!=null)armor = armor + itemChest.getArmor();
		if(itemLegs!=null)armor = armor + itemLegs.getArmor();
		if(itemHelmet!=null)armor = armor + itemHelmet.getArmor();
		if(itemWeaponLeft!=null)armor = armor + itemWeaponLeft.getArmor();
		if(itemWeaponRight!=null)armor = armor + itemWeaponRight.getArmor();
		return armor;
		
	}
	public static int getItemHealth()
	{
		int health = 0;
		if(itemExtra!=null)health = health + itemExtra.getHealth();
		if(itemChest!=null)health = health + itemChest.getHealth();
		if(itemLegs!=null)health = health + itemLegs.getHealth();
		if(itemHelmet!=null)health = health + itemHelmet.getHealth();
		if(itemWeaponLeft!=null)health = health + itemWeaponLeft.getHealth();
		if(itemWeaponRight!=null)health = health + itemWeaponRight.getHealth();
		return health;
	}
	public static int getItemDamage()
	{
		int damage = 0;
		if(itemExtra!=null)damage = damage + itemExtra.getDamage();
		if(itemChest!=null)damage = damage + itemChest.getDamage();
		if(itemLegs!=null)damage = damage + itemLegs.getDamage();
		if(itemHelmet!=null)damage = damage + itemHelmet.getDamage();
		if(itemWeaponLeft!=null)damage = damage + itemWeaponLeft.getDamage();
		if(itemWeaponRight!=null)damage = damage + itemWeaponRight.getDamage();
		return damage;
	}
	public void addItem(Item item)
	{
		int used = used();
		if(used==15)return;
		int i;
		for(i=0;i<15;i++) 
		{
			if(inventory_items[i] == null)
				
				{
				inventory_items[i]=item;
				break;
				}
		}
		setIcon(inventory[i]);
	}
	public void swapItems(int a,int b)
	{
		ImageIcon x;
		Item y;
		x=(ImageIcon) inventory[a].getIcon();
		inventory[a].setIcon(inventory[b].getIcon());
		inventory[b].setIcon(x);
		y=inventory_items[a];
	    inventory_items[a]=inventory_items[b];
	    inventory_items[b]=y;
	}
	public Backpack() {
		super("Backpack",
		          false, //resizable
		          true, //closable
		          false, //maximizable
		          false);
		//System.out.print("HERE");
		this.setFrameIcon(new ImageIcon (pic.backpack.getScaledInstance(20, 20, Image.SCALE_FAST)));
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 551, 247);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 contentPane.add(movingLabel);
		
		
		paneStats.setVisible(false);
		paneStats.setBounds(328, 183, 107, 102);
		contentPane.add(paneStats);
		
	
		lblHelmet.setBounds(60+20,20,50,50);
		contentPane.add(lblHelmet);
		
		
		lblChest.setBounds(60+20,60+20,50,50);
		contentPane.add(lblChest);
		
		
		lblWeaponLeft.setBounds(20,60+20,50,50);
		contentPane.add(lblWeaponLeft);
		
		
		lblWeaponRight.setBounds(2*60+20,60+20,50,50);
		contentPane.add(lblWeaponRight);
		
		
		lblLegs.setBounds(60+20,2*60+20,50,50);
		contentPane.add(lblLegs);
		
		lblExtra.setBounds(20,2*60+20,50,50);
		contentPane.add(lblExtra);
		
		setInventory();
		//===========================BACKGROUND=======================
		JLabel background = new JLabel();
		background.setLocation(0, 0);
		background.setFocusable(false);
		background.setSize(new Dimension(this.getSize().width, this.getSize().height));
		background.setIcon(new ImageIcon(pic.LeatherBG.getScaledInstance(this.getSize().width, this.getSize().height,Image.SCALE_FAST)));
		background.setOpaque(false);
		contentPane.add(background);
		
		//==================================================
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(final ComponentEvent e) {
            	MainFrame.lblHealth.requestFocusInWindow();
            }
            
            public void componentHidden(final ComponentEvent e)
            {
            	MainFrame.lblHealth.requestFocusInWindow();
            }
            public void componentShown(final ComponentEvent e)
            {
            	MainFrame.lblHealth.requestFocusInWindow();
            }
        });
	}
}
