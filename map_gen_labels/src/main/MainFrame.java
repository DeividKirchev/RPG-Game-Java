package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import basics.*;
import mapGenMain.MapFileMaker;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class MainFrame extends JFrame {
	String FolderPath = System.getProperty("user.dir") + "\\src";
	JLabel lblSelected = new JLabel();
	String Selected = new String("Grass");
	private static final long serialVersionUID = 1L;
	PictureDataBase pic = new PictureDataBase();
	JLabel[][] editor_map = new JLabel[100][100];
	Character[][] export_map = new Character[100][100];
	Boolean flag = false;
	private JPanel contentPane;
	private JTextField txtSizeX;
	private JTextField txtSizeY;
	private JTextField txtMapName;
	private JTextField txtImport;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void setMap(int x,int y)
	{
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				editor_map[i][j].setVisible(true);
		
				
		 for(int i=x;i<33;i++)
		 {
			 for(int j=0;j<33;j++)
			 {
				 editor_map[i][j].setVisible(false);
			 }
		 }
		 for(int i=0;i<x;i++)
		 {
			 for(int j=y;j<33;j++)
			 {
				 editor_map[i][j].setVisible(false);
			 }
		 }
	}
				 
	private void setMapOnStart()
	{
		int i;
		 for(i=0;i<33;i++)
		 {
			 for(int j=0;j<33;j++)
			 {
				 JLabel tmp = new JLabel();
				 tmp.setText("n");
				 tmp.setForeground(new Color(0, 0, 0, 0));
				 tmp.addMouseListener(new MouseAdapter()
				 {
					 public void mouseClicked(MouseEvent e)
					 {
						 if(Selected == "Grass")
						 {
							 tmp.setIcon(new ImageIcon(pic.Grass.getScaledInstance(25, 25, Image.SCALE_FAST)));
							 tmp.setText("n");
						 }
						 if(Selected == "Tree") 
						 {
							 tmp.setIcon(new ImageIcon(pic.Tree.getScaledInstance(25, 25, Image.SCALE_FAST)));
							 tmp.setText("t");
						 }
						 if(Selected == "Warrior") 
						 {
						
							 tmp.setIcon(new ImageIcon(pic.Warrior.getScaledInstance(25, 25, Image.SCALE_FAST)));	
							 tmp.setText("w");
						 }
						 if(Selected == "Chest") 
						 {
							 tmp.setIcon(new ImageIcon(pic.Chest.getScaledInstance(25, 25, Image.SCALE_FAST)));
							 tmp.setText("c");
						 }
					 }
					 public void mouseEntered(MouseEvent e)
					 {
						 if(e.isShiftDown()) {
							 if(Selected == "Grass")
							 {
								 tmp.setIcon(new ImageIcon(pic.Grass.getScaledInstance(25, 25, Image.SCALE_FAST)));
								 tmp.setText("n");
							 }
							 if(Selected == "Tree") 
							 {
								 tmp.setIcon(new ImageIcon(pic.Tree.getScaledInstance(25, 25, Image.SCALE_FAST)));
								 tmp.setText("t");
							 }
							 if(Selected == "Warrior") 
							 {
							
								 tmp.setIcon(new ImageIcon(pic.Warrior.getScaledInstance(25, 25, Image.SCALE_FAST)));	
								 tmp.setText("w");
							 }
							 if(Selected == "Chest") 
							 {
								 tmp.setIcon(new ImageIcon(pic.Chest.getScaledInstance(25, 25, Image.SCALE_FAST)));
								 tmp.setText("c");
							 }
					                    }
					 }
				 });
				 editor_map[i][j]=tmp;
				 editor_map[i][j].setBounds(i*25+10, j*25+10, 25, 25);
				 editor_map[i][j].setIcon(new ImageIcon(pic.Grass.getScaledInstance(25, 25, Image.SCALE_FAST)));
				 export_map[i][j] = 'n';
				 contentPane.add(editor_map[i][j]);
			 }
		 }
	}
	
	private void Import (String FileName) throws IOException
	{
		String FilePath = FolderPath + "\\" + FileName + ".txt";
		System.out.println(FilePath);
		File file = new File(FilePath);
		Scanner myReader = new Scanner(file);
		int y = -1;
	      while (myReader.hasNextLine()) {
	    	  y++;
	          String data = myReader.nextLine();
	          System.out.println(data);
	          for(int i=0;i<data.length();i++)
	          {
	        	  System.out.println(i+" "+y);
	        	  if(data.charAt(i)=='n') {
	        		  editor_map[i][y].setIcon(new ImageIcon(pic.Grass.getScaledInstance(25, 25, Image.SCALE_FAST)));
	        		  export_map[i][y] = 'n';
	        		  continue;
	        	  }
	        	  if(data.charAt(i)=='t') {
	        		  editor_map[i][y].setIcon(new ImageIcon(pic.Tree.getScaledInstance(25, 25, Image.SCALE_FAST)));
	        		  export_map[i][y] = 't';
	        		  continue;
	        	  }
	        	  if(data.charAt(i)=='w') {
	        		  editor_map[i][y].setIcon(new ImageIcon(pic.Warrior.getScaledInstance(25, 25, Image.SCALE_FAST)));
	        		  export_map[i][y] = 'w';
	        		  continue;
	        	  }
	        	  if(data.charAt(i)=='c') {
	        		  editor_map[i][y].setIcon(new ImageIcon(pic.Chest.getScaledInstance(25, 25, Image.SCALE_FAST)));
	        		  export_map[i][y] = 'c';
	        		  continue;
	        	  }
	          }
	          txtSizeX.setText(Integer.toString(data.length()));
	      }
	      txtSizeX.setText(Integer.toString(y));
	}
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		
		g.drawRect(18,40 ,11*25,11*25);
		g.drawRect(18,40+11*25,11*25,11*25);
		g.drawRect(18,40+22*25,11*25,11*25);
		
		g.drawRect(18+11*25,40 ,11*25,11*25);
		g.drawRect(18+11*25,40+11*25,11*25,11*25);
		g.drawRect(18+11*25,40+22*25,11*25,11*25);
		
		g.drawRect(18+22*25,40 ,11*25,11*25);
		g.drawRect(18+22*25,40+11*25,11*25,11*25);
		g.drawRect(18+22*25,40+22*25,11*25,11*25);
	}

	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFocusable(false);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(957, 771, 117, 37);
		contentPane.add(btnExit);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x,y;
				try {
				x = Integer.parseInt(txtSizeX.getText());
				y = Integer.parseInt(txtSizeY.getText());
				}
				catch (Exception e1)
				{
					x = 33;
					y = 33;
				}
				String Map = new String();
				for(int j=0;j<x;j++)
				{
					for(int i=0;i<y;i++)
					{
						Map=  Map + (editor_map[i][j].getText());
					}
					Map=Map+"\r\n";
				}
				
				System.out.print(Map);
				try {
					MapFileMaker filemaker = new MapFileMaker(Map,txtMapName.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExport.setBounds(957, 553, 117, 37);
		contentPane.add(btnExport);
		
		JButton btnTree = new JButton("Tree");
		btnTree.setFocusable(false);
		btnTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelected.setIcon(new ImageIcon(pic.Tree.getScaledInstance(100, 100,Image.SCALE_FAST)));
				Selected = "Tree";
			}
		});
		btnTree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTree.setBounds(957, 195, 117, 37);
		contentPane.add(btnTree);
		
		JButton btnWarrior = new JButton("Warrior");
		btnWarrior.setFocusable(false);
		btnWarrior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelected.setIcon(new ImageIcon(pic.Warrior.getScaledInstance(100, 100,Image.SCALE_FAST)));
				Selected = "Warrior";
			}
		});
		btnWarrior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnWarrior.setBounds(957, 243, 117, 37);
		contentPane.add(btnWarrior);
		
		JButton btnChest = new JButton("Chest");
		btnChest.setFocusable(false);
		btnChest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelected.setIcon(new ImageIcon(pic.Chest.getScaledInstance(100, 100,Image.SCALE_FAST)));
				Selected = "Chest";
			}
		});
		btnChest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChest.setBounds(957, 291, 117, 37);
		contentPane.add(btnChest);
		
		
		lblSelected.setBounds(957, 35, 117, 124);
		contentPane.add(lblSelected);
		lblSelected.setIcon(new ImageIcon(pic.Grass.getScaledInstance(100, 100,Image.SCALE_FAST)));
		
		JButton btnNull = new JButton("Null");
		btnNull.setFocusable(false);
		btnNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelected.setIcon(new ImageIcon(pic.Grass.getScaledInstance(100, 100,Image.SCALE_FAST)));
				Selected = "Grass";
			}
		});
		btnNull.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNull.setBounds(957, 339, 117, 37);
		contentPane.add(btnNull);
		
		txtSizeX = new JTextField();
		txtSizeX.setBounds(988, 402, 86, 20);
		contentPane.add(txtSizeX);
		txtSizeX.setColumns(10);
		
		txtSizeY = new JTextField();
		txtSizeY.setColumns(10);
		txtSizeY.setBounds(988, 433, 86, 20);
		contentPane.add(txtSizeY);
		
		JLabel lblSizeX = new JLabel("Size X:");
		lblSizeX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSizeX.setBounds(897, 402, 81, 20);
		contentPane.add(lblSizeX);
		
		JLabel lblSizeY = new JLabel("Size Y:");
		lblSizeY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSizeY.setBounds(897, 432, 81, 21);
		contentPane.add(lblSizeY);
		//================================== CHANGE SIZE ===========================
		JButton btnChangeSize = new JButton("Change Size");
		btnChangeSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=33;
				int y=33;
				try {
					
				x = Integer.parseInt(txtSizeX.getText());
					
				}
				catch(Exception e1)
				{
					x = 0;
					txtSizeX.setText("0");
				}
				try {
					y = Integer.parseInt(txtSizeY.getText());
				}
				catch (Exception e1)
				{
					y=0;
					txtSizeY.setText("0");
				}
				if(x>33)
				{
					x = 33;
					txtSizeX.setText(Integer.toString(x));
				}
				if(y>33)
				{
					y= 33;
					txtSizeY.setText(Integer.toString(y));
				}
				setMap(x,y);
				repaint();
				
			}
		});
		btnChangeSize.setBounds(957, 464, 117, 30);
		contentPane.add(btnChangeSize);
		
		txtMapName = new JTextField();
		txtMapName.setText("MapName");
		txtMapName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMapName.setBounds(957, 515, 117, 27);
		contentPane.add(txtMapName);
		txtMapName.setColumns(10);
		
		txtImport = new JTextField();
		txtImport.setText("MapName");
		txtImport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtImport.setColumns(10);
		txtImport.setBounds(957, 612, 117, 27);
		contentPane.add(txtImport);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Import(txtImport.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnImport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImport.setBounds(957, 652, 117, 37);
		contentPane.add(btnImport);
		
		
		//=====================================================
		setMapOnStart();
	}
}
