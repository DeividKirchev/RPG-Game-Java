package main;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basics.PictureDataBase;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	PictureDataBase pic = new PictureDataBase();
	private JPanel contentPane;
	MainFrame Mainframe;
	public JButton btnExit = new JButton("Exit Game");
	public void CheckPressedKey (KeyEvent e) throws InterruptedException
	{
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) Mainframe.switchContentPane();
	}
	
	public Menu(MainFrame mainframe) {
		setFocusable(false);
		Mainframe = mainframe;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(mainframe.getX(),mainframe.getY(), 924, 687);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFocusable(false);
		btnSettings.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnSettings.setBounds(387, 298, 133, 50);
		contentPane.add(btnSettings);
		
	
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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
		
		btnExit.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnExit.setBounds(387, 359, 133, 50);
		contentPane.add(btnExit);
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setFocusable(false);
		btnTutorial.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnTutorial.setBounds(387, 237, 133, 50);
		contentPane.add(btnTutorial);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 45));
		lblNewLabel.setBounds(363, 147, 177, 74);
		contentPane.add(lblNewLabel);
		
		
		JLabel background;
		contentPane.setLayout(null);
		background = new JLabel();
		background.setLocation(0,0);
		background.setFocusable(false);
		background.setSize(new Dimension(924, 687));
		background.setIcon(new ImageIcon(pic.menuBG.getScaledInstance(this.getSize().width, this.getSize().height,Image.SCALE_FAST)));
		background.setOpaque(false);
		contentPane.add(background);
	}
}