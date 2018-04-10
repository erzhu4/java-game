package gameobjects;

import java.awt.event.*;

public class Ship extends GameObject implements KeyListener {

	public static int shipSize = 60;

	public Ship(int[] startPositionArg, coolgame.CoolGame gameArg){
		super(startPositionArg, new int[]{0,0}, new int[]{Ship.shipSize, Ship.shipSize}, gameArg, "images/fighter.png");
		gameArg.frame.addKeyListener(this);
		this.type = "ship";
	}

	public void keyPressed(KeyEvent e){
		char key = e.getKeyChar();
		int keyInt = e.getKeyCode();
		switch (keyInt){
			case 39: // right
				this.velocity[0] = 6;
				break;
			case 37: // left
				this.velocity[0] = -6;
				break;
			case 38: //up
				this.velocity[1] = -6;
				break;
			case 40: // down
				this.velocity[1] = 6;
				break;
		}
		if (key == ' '){
			fireLaser();
		}

	}

	public void keyReleased(KeyEvent e){
		int keyInt = e.getKeyCode();
		switch (keyInt){
			case 39: // right
				if (this.velocity[0] > 0){
					this.velocity[0] = 0;
				}
				break;
			case 37: // left
				if (this.velocity[0] < 0){
					this.velocity[0] = 0;
				}
				break;
			case 38: //up
				if (this.velocity[1] < 0){
					this.velocity[1] = 0;
				}
			case 40: // down
				if (this.velocity[1] > 0){
					this.velocity[1] = 0;
				}
		}
	}

	public void keyTyped(KeyEvent e){}

	public void checkColide(){
		if (this.checkOutOfBounds()){
			stop();
			if (this.position[0] <= 0){
				this.position[0] += 6;
			} else if (this.position[0] >= this.game.width - this.size[0]){
				this.position[0] -= 6;
			} else if (this.position[1] <= 0){
				this.position[1] += 6;
			} else if (this.position[1] >= this.game.height - this.size[1]){
				this.position[1] -= 6;
			}
		}
	}

	private void stop(){
		this.velocity[0] = 0;
		this.velocity[1] = 0;
	}

	private void fireLaser(){
		this.game.createLaser(new int[]{this.position[0], this.position[1]}, this.velocity[0] / 2);
	}

}