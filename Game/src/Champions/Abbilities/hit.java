package Champions.Abbilities;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import Champions.Abbility;
import Champions.Champion;
import basics.Map;
import main.MainFrame;

public class hit extends Abbility {
	public hit(Champion player, JFrame frame)
	{
		Name = "Hit";
		Description = "A basic attack with weapons, dealing Damage lowered by the target armor";
		this.player = player;
		this.setEffect(pic.sword_effect);
		effect_label.setVisible(false);
		
		effect_label.setIcon(this.getEffect());
		effectTimer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		    	  effect_label.setVisible(false);
		      }
		};
		timerDMG = new Timer(500,effectTimer);
		timerDMG.setRepeats(false);
		frame.getContentPane().add(effect_label);
		
		abbility_image.setIcon(new ImageIcon(pic.sword_hit.getScaledInstance(50, 50, Image.SCALE_FAST)));
		cooldown.setInitialDelay(1000);
		cooldown.setRepeats(false);
	}
	public Boolean cast(Map map,int targetX,int targetY, int casterX,int casterY, MainFrame frame)
	{
		cooldown.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent evt) {
    	  onCooldown = false;
    	  frame.cdAB1.setIcon(null);
      }
		});
		if(onCooldown)return false;
		onCooldown = true;
		cooldown.start();
		frame.cdAB1.setIcon(this.abbility_image.getIcon());
		
		if(!player.checkHit(80))
			{
			return false;
			}
		if(!checkRange(targetX, targetY, casterX, casterY,  1))
			{
			return false;
			}
		
		Champion target = map.getWarrior(targetX, targetY);
		if(target == null)return false;
		effect_label.setIcon(this.getEffect());
		effect_label.setVisible(true);
		effect_label.setBounds((targetX-frame.movedX)*50+50,(targetY-frame.movedY)*50+50,50,50);
		timerDMG.start();
		target.setCurrent_Health(target.current_Health() -  (Math.max((player.Damage() * (100-target.Armor()) / 100),0) + player.rand.nextInt(10)));
		return true;
	}
}
