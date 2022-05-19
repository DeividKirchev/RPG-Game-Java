package main;


import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JLabel;
import basics.PictureDataBase;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
public class CharacterChoice extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PictureDataBase pic = new PictureDataBase();
	private String FolderPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterChoice frame = new CharacterChoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CharacterChoice() {
		this.setIconImage(pic.warrior_trans);
		setTitle("Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnWarrior = new JToggleButton("Warrior");
		btnWarrior.setFocusable(false);
		btnWarrior.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWarrior.setBounds(685, 58, 129, 36);
		contentPane.add(btnWarrior);
		
		JToggleButton btnMage = new JToggleButton("Mage");
		btnMage.setFocusable(false);
		btnMage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMage.setBounds(685, 105, 129, 36);
		contentPane.add(btnMage);
		
		JToggleButton btnHunter = new JToggleButton("Hunter");
		btnHunter.setFocusable(false);
		btnHunter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHunter.setBounds(685, 152, 129, 36);
		contentPane.add(btnHunter);
		
		JLabel lblPic = new JLabel("");
		lblPic.setBounds(40, 40, 400, 400);
		contentPane.add(lblPic);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setFocusable(false);
	
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSelect.setBounds(685, 380, 129, 36);
		contentPane.add(btnSelect);
		//======================================================LIST
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		
		String MapPath = FolderPath + "\\src\\basics\\Maps\\";
		File[] listOfFiles = new File(MapPath).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
				}
			}); 
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			model.add(i, listOfFiles[i].getName());
		}
		JList<String> list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(685, 223, 129, 146);
		contentPane.add(list);
		//==============================ACTION LISTENERS======================================
		
		ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                btnWarrior.setSelected(false);
                btnHunter.setSelected(false);
                btnMage.setSelected(false);
                abstractButton.setSelected(true);
                lblPic.setIcon(new ImageIcon(pic.getPlayerImg(abstractButton.getText()).getScaledInstance(400,400,Image.SCALE_FAST)));
            }
        };
        btnMage.addActionListener(actionListener);
        btnWarrior.addActionListener(actionListener);
        btnHunter.addActionListener(actionListener);
        //====================================================================================
        btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf;
				String map = listOfFiles[list.getSelectedIndex()].getName();
				if(btnHunter.isSelected())
				{
					mf = new MainFrame("Hunter",map);
					 mf.setVisible(true);
					 dispose();
				}
				if(btnWarrior.isSelected())
				{
					mf = new MainFrame("Warrior",map);
					 mf.setVisible(true);
					 dispose();
				}
				if(btnMage.isSelected())
				{
					mf = new MainFrame("Mage",map);
					 mf.setVisible(true);
					 dispose();
				} 
				
			}
		});
        btnWarrior.doClick();
	}
}
