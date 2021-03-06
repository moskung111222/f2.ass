

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Image;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
		private Image imgBackground;
        
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		/*imgBackground = Toolkit.getDefaultToolkit().getImage("NightBG.gif");*/
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		/*big.setBackground(Color.BLACK);*/
		big.drawImage(imgBackground, 0, 0, 400, 600,null);
	}

	public void updateGameUI(GameReporter reporter){
		//big.clearRect(0, 0, 400, 600);
		big.drawImage(imgBackground, 0, 0, 400, 600,null);
		big.setColor(Color.WHITE);		
		big.drawString(String.format("Score point:%08d", reporter.getScore()), 300, 20);
		big.setColor(Color.WHITE);
		big.drawString(String.format("Gift point:%08d", reporter.getScoreItem()), 150, 20);
		big.setColor(Color.WHITE);
		big.drawString(String.format("Total point:%08d", reporter.getScoreTotal()), 50, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}
	/*public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(bi, 0, 0, null);
	}*/
}