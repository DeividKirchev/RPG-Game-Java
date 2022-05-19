package Champions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import basics.Map;
import basics.PictureDataBase;
import main.MainFrame;

public abstract class Abbility {
	protected String Name = "";
	protected String Description = "";
	public ImageIcon effect;
	public PictureDataBase pic = new PictureDataBase();
	protected JLabel effect_label = new JLabel();
	protected JLabel abbility_image = new JLabel();
	protected ActionListener effectTimer;
	protected Timer cooldown = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
	    	  onCooldown = false;
	      }
	});
	
	protected Timer timerDMG;
	protected Boolean onCooldown = false;
	//---------------------------------------------------------------------------------------------------------------------------------------
	protected Champion player;
	public Champion getPlayer() {
		return player;
	}
	public void setPlayer(Champion player) {
		this.player = player;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------- player
	protected enum Type{
		TARGET,
		RANGE_1,
		RANGE_2,
		TARGET_RANGE1,
		ROWS_COLUMNS
	}
	public abstract Boolean cast (Map map,int targetX,int targetY, int casterX,int casterY, MainFrame frame);
	protected static Boolean checkRange(int targetX,int targetY,int playerX,int playerY,int range)
	{
		if(Math.abs(playerX - targetX) > range || Math.abs(playerY - targetY) > range)return false;
		return true;
	}
	public ImageIcon getEffect()
	{
		return effect;
	}
	public void setEffect(String path)
	{
		effect = new ImageIcon(path);
	}
	public void setEffect(ImageIcon effect)
	{
		this.effect = effect;
	}
}
