package main;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basics.PictureDataBase;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Talents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    PictureDataBase pic = new PictureDataBase();
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Talents frame = new Talents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public Talents(MainFrame mainframe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.switchContentPane();
			}
		});
		btnBack.setBounds(650, 506, 124, 35);
		contentPane.add(btnBack);
		
		
		JLabel background;
		background = new JLabel();
		background.setLocation(0, 0);
		background.setFocusable(false);
		background.setSize(new Dimension(924, 687));
		background.setIcon(new ImageIcon(pic.talentsBG.getScaledInstance(this.getSize().width, this.getSize().height,Image.SCALE_FAST)));
		background.setOpaque(false);
		contentPane.add(background);
	}
}
