package main;

import java.awt.Dimension;
import java.awt.Image;
import javax.imageio.ImageIO;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	String filePath = System.getProperty("user.dir") + "\\src\\basics\\";
	PictureDataBase pic = new PictureDataBase();
	private JPanel contentPane;
	MainFrame Mainframe;
	public JButton btnExit = new JButton("Exit Game");
	public JLabel btnCancel = new JLabel();
	public void CheckPressedKey (KeyEvent e) throws InterruptedException
	{
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) Mainframe.switchContentPane();
	}
	public Menu(MainFrame mainframe) {
		BufferedImage cancel_image = null;
		try {
			cancel_image = ImageIO.read(new File(filePath+"cancel_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage cancel_image_clicked = null;
		try {
			cancel_image_clicked = ImageIO.read(new File(filePath+"cancel_button_clicked.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage menu_text = null;
		try {
			menu_text = ImageIO.read(new File(filePath+"menu_text.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		final ImageIcon Cancel_Button_Clicked_Icon = (new ImageIcon(cancel_image_clicked.getScaledInstance(100, 100, Image.SCALE_FAST)));
		final ImageIcon Cancel_Button_Icon = (new ImageIcon(cancel_image.getScaledInstance(100, 100, Image.SCALE_FAST)));	
				
		setFocusable(false);
		Mainframe = mainframe;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(mainframe.getX(),mainframe.getY(), 924, 687);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCancel.setIcon(Cancel_Button_Icon);
		btnCancel.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
				Mainframe.switchContentPane();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				btnCancel.setIcon(Cancel_Button_Clicked_Icon);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btnCancel.setIcon(Cancel_Button_Icon);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		btnCancel.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnCancel.setBounds(20, 11, 116, 94);
		contentPane.add(btnCancel);
		
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFocusable(false);
		btnSettings.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnSettings.setBounds(387, 298, 133, 50);
		contentPane.add(btnSettings);
		btnExit.setFocusable(false);
		
	
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCancel.addKeyListener(new KeyAdapter() {
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
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(menu_text.getScaledInstance(200, 100, Image.SCALE_FAST)));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 45));
		lblNewLabel.setBounds(363, 147, 177, 74);
		contentPane.add(lblNewLabel);
		
		BufferedImage BG = null;
		try {
			BG = ImageIO.read(new File(filePath+"menu_BG.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel background;
		contentPane.setLayout(null);
		background = new JLabel();
		background.setLocation(0,0);
		background.setFocusable(false);
		background.setSize(new Dimension(924, 687));
		background.setIcon(new ImageIcon(BG.getScaledInstance(this.getSize().width, this.getSize().height,Image.SCALE_FAST)));
		background.setOpaque(false);
		contentPane.add(background);
		if(btnCancel.hasFocus())System.out.println("YES");
	}
}
