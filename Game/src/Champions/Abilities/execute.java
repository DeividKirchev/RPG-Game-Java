package Champions.Abilities;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import Champions.Ability;
import Champions.Champion;
import basics.Map;
import main.MainFrame;

public class execute extends Ability {
	public execute(Champion player, JFrame frame)
	{
		Name = "Execute";
		Description = "A finnishing move, dealing fatal damage. Has a higher chance of hitting on lower health enemies";
		this.player = player;
		this.setEffect(pic.blood_effect);
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
		
		ability_image.setIcon(new ImageIcon(pic.execute.getScaledInstance(50, 50, Image.SCALE_FAST)));
		cooldown.setInitialDelay(5000);
		cooldown.setRepeats(false);
	}
	public Boolean cast(Map map,int targetX,int targetY, int casterX,int casterY, MainFrame frame)
	{
		Champion target = map.getWarrior(targetX, targetY);
		if(target == null)return false; 
		 if(!checkRange(targetX, targetY, casterX, casterY,  1))
			{
			return false;
			}
		 
		cooldown.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent evt) {
    	  onCooldown = false;
    	  frame.cdAB2.setIcon(null);
      }
		});
		
		if(onCooldown)return false;
		onCooldown = true;
		cooldown.start();
		frame.cdAB2.setIcon(this.ability_image.getIcon());
		
		
		int hpPercent = target.current_Health()*100/target.Health();
		if(hpPercent < 35)
		   {
			if(!player.checkHit(100- hpPercent + 5) ) 
			   return false;
		   }
		else
			if(!player.checkHit(100- hpPercent - 10) )
			{
			return false;
			}
			
		   
		    effect_label.setIcon(this.getEffect());
			effect_label.setVisible(true);
			effect_label.setBounds((targetX-frame.movedX)*50+50,(targetY-frame.movedY)*50+50,50,50);
			timerDMG.start();
		    player.Heal(target.current_Health());
			target.setCurrent_Health(0);
			return true;
	}

}