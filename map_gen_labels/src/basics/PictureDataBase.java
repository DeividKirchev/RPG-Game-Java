package basics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PictureDataBase
{
	private String DefaultFilePath = System.getProperty("user.dir");
	public BufferedImage Tree;
	public BufferedImage Warrior;
	public Image MedievalBG;
	public BufferedImage Chest;
	public BufferedImage Grass;
	public BufferedImage player_Warrior;
	public BufferedImage player_Mage;
	public BufferedImage player_Hunter;
	
	public PictureDataBase()
	{
		//TREE
		try {
			Tree = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\tree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//WARRIOR
		try {
			Warrior = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\warrior.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Mediaval BackGround
		try {
			MedievalBG = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\medievalBG.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Chest 
		try {
			Chest = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\chest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Grass = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\grass.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			player_Warrior = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\player_warrior.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			player_Hunter = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\player_hunter.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			player_Mage = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\player_mage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getPlayerImg(String s)
	{
		if(s=="Warrior") return player_Warrior;
		if(s=="Mage") return player_Mage;
		if(s=="Hunter") return player_Hunter;
		return null;
	}
}
