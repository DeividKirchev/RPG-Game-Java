package Champions.Abbilities;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import Champions.Abbility;
import Champions.Champion;
import basics.Map;
import main.MainFrame;

public class spin_swipe extends Abbility {
	
	JLabel[] effect_labels = new JLabel[9];
	
	public spin_swipe(Champion player, JFrame frame)
	{
		Name = "Hurricane";
		Description = "A spinning attack, dealing damage to every enemy around the caster";
		this.player = player;
		this.setEffect(pic.sword_effect);
		for(int i=0;i<9;i++) {
		effect_labels[i] = new JLabel();
        effect_labels[i].setVisible(false);
        effect_labels[i].setIcon(this.getEffect());
		frame.getContentPane().add(effect_labels[i]);
		}
		
		effectTimer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for(int i=0;i<9;i++) 
				{
					effect_labels[i].setVisible(false);
				}
				
				}
		};
		timerDMG = new Timer(500,effectTimer);
		timerDMG.setRepeats(false);
		
		abbility_image.setIcon(new ImageIcon(pic.sword_slash.getScaledInstance(50, 50, Image.SCALE_FAST)));
		cooldown.setInitialDelay(1000);
		cooldown.setRepeats(false);
	}
	@Override
	public Boolean cast(Map map, int targetX, int targetY, int casterX, int casterY, MainFrame frame)
	{
		cooldown.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent evt) {
		    	  onCooldown = false;
		    	  frame.cdAB3.setIcon(null);
		      }
				});
		if(onCooldown)return false;
		onCooldown = true;
		cooldown.start();
		frame.cdAB3.setIcon(this.abbility_image.getIcon());
		for (int i =casterX-1;i<=casterX+1;i++)
		{
			for (int j = casterY-1;j<=casterY+1;j++)
			{
				Champion target = map.getWarrior(i, j);
				if(target == null)continue;
				if(!player.checkHit(80))continue;
				target.setCurrent_Health(target.current_Health() -  (Math.max((player.Damage()/4 * (100-target.Armor()) / 100),0) + player.rand.nextInt(10)));
				
				if(map.getWarrior(i, j) != null) 
				{
				if(!map.getWarrior(i,j).Alive())
				{
					map.Clear(i,j);
					frame.setMap(i - frame.movedX,j - frame.movedY);
					frame.getLoot();
				}
				}
			}
		}
		int p = 0;
		for (int i =casterX-1;i<=casterX+1;i++)
		{
			for (int j = casterY-1;j<=casterY+1;j++)
			{
				if(i == casterX && j == casterY)continue;
				effect_labels[p].setIcon(this.getEffect());
				effect_labels[p].setVisible(true);
				effect_labels[p].setBounds((i-frame.movedX)*50+50,(j-frame.movedY)*50+50,50,50);
				timerDMG.start();
				p++;
			}
		}
		frame.target(targetX, targetY);
		return true;
	}

}
