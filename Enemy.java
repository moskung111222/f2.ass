

package f2.ass;
 
 import java.awt.AlphaComposite;
 import java.awt.Color;
 import java.awt.Graphics2D;
 
 public class Enemy extends Sprite{
 	public static final int Y_TO_FADE = 400;
 	public static final int Y_TO_DIE = 600;
 	
	private int step = 12;
	private int step = 10;
 	private boolean alive = true;
 	
 	public Enemy(int x, int y) {
		super(x, y, 5, 10);
		super(x, y, 8, 12);
 		
 	}
 
 	@Override
 	public void draw(Graphics2D g) { /*create Enemy*/
 		if(y < Y_TO_FADE)
 			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
 		else{
 			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
 					(float)(Y_TO_DIE - y)/(Y_TO_DIE - Y_TO_FADE)));
 		}
		g.setColor(Color.GREEN);
		g.setColor(Color.RED);
 		g.fillRect(x, y, width, height);
 		
 	}
