

package f2.spw;
 
 import java.awt.AlphaComposite;
 import java.awt.Color;
 import java.awt.Graphics2D;
 import java.awt.Toolkit; /*import image tool*/
 import java.awt.Image;
 
 public class Enemy extends Sprite{
 	public static final int Y_TO_FADE = 400;
 	public static final int Y_TO_DIE = 600;
 	
	private int step = 12;
	private int step = 10;
 	private boolean alive = true;
 	
 	public Enemy(int x, int y) {
		super(x, y, 8, 12);
		super(x, y, 10, 14);
 		
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
		/*g.setColor(Color.RED);*/
 		g.fillRect(x, y, width, height);
 		 Image img = Toolkit.getDefaultToolkit().getImage("teddy.gif");
 		 g.drawImage(img, x, y, width, height, null);
 		
 	}
