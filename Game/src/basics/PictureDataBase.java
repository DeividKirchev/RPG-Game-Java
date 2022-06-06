package basics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	public BufferedImage player_Warrior_damaged;
	public BufferedImage Warrior_damaged;
	public Image LeatherBG;
	public BufferedImage board;
	public BufferedImage ThornChest;
	public BufferedImage ThornLegs;
	public BufferedImage ThornHelmet;
	public BufferedImage ThornGauntlets;
	public BufferedImage ChestOfLife;
	public BufferedImage LegsOfLife;
	public BufferedImage HelmetOfLife;
	public BufferedImage AxeOfLife;
	public BufferedImage DragonChest;
	public BufferedImage DragonLegs;
	public BufferedImage DragonHelmet;
	public BufferedImage DragonSword;
	public BufferedImage GreatSword;
	public BufferedImage talentsBG;
	public BufferedImage player_Warrior1;
	public BufferedImage boardHelmet;
	public BufferedImage boardChest;
	public BufferedImage boardWeaponL;
	public BufferedImage boardWeaponR;
	public BufferedImage boardExtra;
	public BufferedImage boardLegs;
	public BufferedImage menuBG;
	public BufferedImage backpack;
	public BufferedImage warrior_trans;
	public BufferedImage warrior_trans1;
	public BufferedImage mage_trans;
	public BufferedImage hunter_trans;
	public BufferedImage health_potion;
	
	public ImageIcon sword_effect = new ImageIcon(System.getProperty("user.dir")+"\\src\\basics\\sword_slash1.gif");
	public ImageIcon blood_effect = new ImageIcon(System.getProperty("user.dir")+"\\src\\basics\\blood_slash1.gif");
	public ImageIcon throw_effect = new ImageIcon(System.getProperty("user.dir")+"\\src\\basics\\throw_effect1.gif");
	public BufferedImage talents_img_pressed;
	public BufferedImage  talents_img;
	public BufferedImage backpack_img_pressed;
	public BufferedImage  backpack_img;
	public BufferedImage sword_hit;
	public BufferedImage sword_slash;
	public BufferedImage execute;
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
		// Medieval BackGround
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
			Grass = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\grass1.jpg"));
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
		try {
			player_Warrior_damaged = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\player_warrior_damaged.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			player_Warrior1 = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\player_warrior1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Warrior_damaged = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\warrior_damaged.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LeatherBG = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\leatherBG.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			board = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\board1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//---------------------------------------------------------------------------------------------------------------------------------------------
		try {
			ThornChest = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\thornchest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ThornLegs = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\thornlegs.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ThornHelmet = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\thornhelmet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ThornGauntlets = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\thorngauntlets.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		try {
			DragonChest = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\dragonchest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DragonLegs = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\dragonlegs.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DragonHelmet = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\dragonhelmet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DragonSword = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\dragonsword.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		try {
					ChestOfLife = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\chestoflife.png"));
		} catch (IOException e) {
					e.printStackTrace();
		}
		try {
					LegsOfLife = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\legsoflife.png"));
		} catch (IOException e) {
					e.printStackTrace();
		}
		try {
					HelmetOfLife = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\helmetoflife.png"));
		} catch (IOException e) {
					e.printStackTrace();
		}
		try {
					AxeOfLife = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\axeoflife.png"));
		} catch (IOException e) {
					e.printStackTrace();
		}
				//--------------------------------------------------------------------------------------------------------------------------------------
		try {
					GreatSword = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\greatsword.png"));
		} catch (IOException e) {
					e.printStackTrace();
		
		}
		//----------------------------------------------------------------------------------------------------------------------------------------------
		try {
			boardWeaponL = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardWeaponL.jpg"));
} catch (IOException e) {
			e.printStackTrace();
}
try {
	boardWeaponR = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardWeaponR.jpg"));
} catch (IOException e) {
			e.printStackTrace();
}
try {
			boardHelmet = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardHelmet.jpg"));
} catch (IOException e) {
			e.printStackTrace();
}
try {
			boardChest = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardChestplate.jpg"));
} catch (IOException e) {
			e.printStackTrace();
}
try {
	boardLegs = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardLegs.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	boardExtra = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\boardExtra.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
try {
	backpack = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\backpack.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	warrior_trans1= ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\warrior_transparent1.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	warrior_trans= ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\warrior_transparent.png"));
} catch (IOException e) {
	e.printStackTrace();
}

try {
	health_potion= ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\hpotion.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	talentsBG = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\talentsBG.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}

try {
	execute = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\execute_image.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	sword_hit = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\sword_hit.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	sword_slash = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\sword_slash.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	menuBG = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\menuBG.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	hunter_trans = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\hunter.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	mage_trans = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\mage.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	talents_img_pressed = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\button_wood_talents_pressed.png"));
} catch (IOException e) {
	e.printStackTrace();
}
//WARRIOR
try {
	talents_img = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\button_wood_talents.png"));
} catch (IOException e) {
	e.printStackTrace();
}
try {
	backpack_img_pressed = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\button_wood_backpack_pressed.png"));
} catch (IOException e) {
	e.printStackTrace();
}
//WARRIOR
try {
	backpack_img = ImageIO.read(new File(DefaultFilePath+"\\src\\basics\\button_wood_backpack.png"));
} catch (IOException e) {
	e.printStackTrace();
}
//sword_effect = new ImageIcon(newimg);
	}
	
	public BufferedImage getPlayerImg(String s)
	{
		if(s=="Warrior") return warrior_trans;
		if(s=="Mage") return mage_trans;
		if(s=="Hunter") return hunter_trans;
		return null;
	}
}
