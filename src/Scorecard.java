import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class Scorecard extends JPanel {
	//fields
	
	FarkleFrame top;
	ArrayList<ScoreLine> lines;
	
	//methods
	
	public Scorecard(FarkleFrame top_i){
		top = top_i;
		lines = new ArrayList<ScoreLine>();
		this.setBorder(BorderFactory.createEmptyBorder(50, 25, 25, 100));
		Box format = Box.createVerticalBox();
		format.add(new JLabel("Score"));
		for (Player player : top.game.getPlayers()){
			lines.add(new ScoreLine(player));
		}
		for (ScoreLine line : lines){
			format.add(line);
		}
		add(format);
	}
	
	public void updateAll(){
		for (ScoreLine line : lines){
			line.update();
		}
	}
	
	//subclasses
	public class ScoreLine extends JPanel {
		Player player;
		JLabel name;
		JLabel score;
		
		public ScoreLine(Player player_i){
			player = player_i;
			name = new JLabel(player.getName());
			score = new JLabel(Integer.toString(player.getScore()));
			Box line = Box.createHorizontalBox();
			line.add(name);
			line.add(Box.createRigidArea(new Dimension(25,0)));
			line.add(Box.createHorizontalGlue());
			line.add(score);
			add(line);
		}
		
		public void update(){
			name.setText(player.getName());
			score.setText(Integer.toString(player.getScore()));
		}
	}
}
