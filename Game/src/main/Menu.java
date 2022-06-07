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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	String filePath = System.getProperty("user.dir") + "\\src\\basics\\";
	PictureDataBase pic = new PictureDataBase();
	private JPanel contentPane;
	MainFrame Mainframe;
	public JLabel btnExit = new JLabel();
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
		BufferedImage exit_image = null;
		try {
			exit_image = ImageIO.read(new File(filePath+"exit_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage exit_image_clicked = null;
		try {
			exit_image_clicked = ImageIO.read(new File(filePath+"exit_button_clicked.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage tutorial_image = null;
		try {
			tutorial_image = ImageIO.read(new File(filePath+"tutorial_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage tutorial_image_clicked = null;
		try {
			tutorial_image_clicked = ImageIO.read(new File(filePath+"tutorial_button_clicked.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage settings_image = null;
		try {
			settings_image = ImageIO.read(new File(filePath+"settings_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage settings_image_clicked = null;
		try {
			settings_image_clicked = ImageIO.read(new File(filePath+"settings_button_clicked.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage menu_text = null;
		try {
			menu_text = ImageIO.read(new File(filePath+"menu_text.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		final ImageIcon Cancel_Button_Clicked_Icon = (new ImageIcon(cancel_image_clicked.getScaledInstance(125, 125, Image.SCALE_FAST)));
		final ImageIcon Cancel_Button_Icon = (new ImageIcon(cancel_image.getScaledInstance(125, 125, Image.SCALE_FAST)));	
		final ImageIcon Exit_Button_Clicked_Icon = (new ImageIcon(exit_image_clicked.getScaledInstance(125, 125, Image.SCALE_FAST)));
		final ImageIcon Exit_Button_Icon = (new ImageIcon(exit_image.getScaledInstance(125, 125, Image.SCALE_FAST)));	
		final ImageIcon Tutorial_Button_Clicked_Icon = (new ImageIcon(tutorial_image_clicked.getScaledInstance(125, 125, Image.SCALE_FAST)));
		final ImageIcon Tutorial_Button_Icon = (new ImageIcon(tutorial_image.getScaledInstance(125, 125, Image.SCALE_FAST)));	
		final ImageIcon Settings_Button_Clicked_Icon = (new ImageIcon(settings_image_clicked.getScaledInstance(125, 125, Image.SCALE_FAST)));
		final ImageIcon Settings_Button_Icon = (new ImageIcon(settings_image.getScaledInstance(125, 125, Image.SCALE_FAST)));	
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
				if(e.getX()>0 && e.getX()<btnCancel.getWidth() && e.getY()>0 && e.getY()<btnCancel.getHeight())Mainframe.switchContentPane();
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
		
		
		JLabel btnSettings = new JLabel();
		btnSettings.setIcon(Settings_Button_Icon);
		btnSettings.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSettings.setIcon(Settings_Button_Clicked_Icon);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSettings.setIcon(Settings_Button_Icon);
				
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
		btnSettings.setFocusable(false);
		btnSettings.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnSettings.setBounds(398, 339, 116, 94);
		contentPane.add(btnSettings);
		
		btnExit.setFocusable(false);
		btnExit.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				btnExit.setIcon(Exit_Button_Clicked_Icon);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btnExit.setIcon(Exit_Button_Icon);
				if(e.getX()>0 && e.getX()<btnExit.getWidth() && e.getY()>0 && e.getY()<btnExit.getHeight())System.exit(0);
				
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
		btnExit.setIcon(Exit_Button_Icon);
		btnExit.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnExit.setBounds(398, 428, 116, 94);
		contentPane.add(btnExit);
		
		JLabel btnTutorial = new JLabel();
		btnTutorial.setIcon(Tutorial_Button_Icon);
		btnTutorial.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				btnTutorial.setIcon(Tutorial_Button_Clicked_Icon);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				btnTutorial.setIcon(Tutorial_Button_Icon);
				
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
		btnTutorial.setFocusable(false);
		btnTutorial.setFont(new Font("Swis721 WGL4 BT", Font.ITALIC, 20));
		btnTutorial.setBounds(398, 237, 116, 94);
		contentPane.add(btnTutorial);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(menu_text.getScaledInstance(200, 100, Image.SCALE_FAST)));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 45));
		lblNewLabel.setBounds(366, 141, 177, 74);
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
