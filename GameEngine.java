public void start(){
 		timer.start();
 	}
 	
 	private void generateEnemy(){
 		Enemy e = new Enemy((int)(Math.random()*390), 30);
 		gp.sprites.add(e);
 		enemies.add(e);
 	}
 	
 	private void process(){
 		if(Math.random() < difficulty){
 			generateEnemy();
 		}
 		
 		Iterator<Enemy> e_iter = enemies.iterator();
 		while(e_iter.hasNext()){
 			Enemy e = e_iter.next();
 			e.proceed();
 			
  			if(!e.isAlive()){
  				e_iter.remove();
  				gp.sprites.remove(e);
 -				score += 100;
 +				score += 200;
  			}
  		}
  		
 		gp.updateGameUI(this);
 		
 		Rectangle2D.Double vr = v.getRectangle();
 		Rectangle2D.Double er;
 		for(Enemy e : enemies){
 			er = e.getRectangle();
 			if(er.intersects(vr)){
 				die();
 				return;
 			}
 		}
 	}
 	
 	public void die(){
 		timer.stop();
 	}
  	
  	void controlVehicle(KeyEvent e) {
  		switch (e.getKeyCode()) {
 +		case KeyEvent.VK_UP:
 +			v.move(0,-1);
 +			break;
 +		case KeyEvent.VK_DOWN:
 +			v.move(0,1);
 +			break;
  		case KeyEvent.VK_LEFT:
 -			v.move(-1);
 +			v.move(-1,0);
  			break;
  		case KeyEvent.VK_RIGHT:
 -			v.move(1);
 +			v.move(1,0);
  			break;
  		case KeyEvent.VK_D:
  			difficulty += 0.1;
