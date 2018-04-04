package gameobjects;

import java.awt.event.*;

public class Ship extends GameObject implements KeyListener {

	public static int shipSize = 60;

	public Ship(int[] startPositionArg, coolgame.CoolGame gameArg){
		super(startPositionArg, new int[]{0,0}, new int[]{Ship.shipSize, Ship.shipSize}, gameArg, "images/f18.jpg");
		gameArg.frame.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e){
		char key = e.getKeyChar();
		int keyInt = e.getKeyCode();
		// if (key == 'a'){
		// 	this.velocity[0] = -2;
		// } else if (key == 'd'){
		// 	this.velocity[0] = 2;
		// } else if (key == ' '){
		// 	System.out.println("SHOOT!!!");
		// }
		switch (keyInt){
			case 39:
				this.velocity[0] = 6;
				break;
			case 37:
				this.velocity[0] = -6;
				break;
		}
		if (key == ' '){
			fireLaser();
		}

	}

	public void keyReleased(KeyEvent e){
		int keyInt = e.getKeyCode();
		switch (keyInt){
			case 39:
				if (this.velocity[0] > 0){
					this.velocity[0] = 0;
				}
				break;
			case 37:
				if (this.velocity[0] < 0){
					this.velocity[0] = 0;	
				}
				break;
		}
	}

	public void keyTyped(KeyEvent e){}


	public void checkColide(){
		if (this.position[0] > this.game.width - this.size[0]){
			this.position[0] -= this.size[0] / 4;
			stop();
		} else if (this.position[0] < this.size[0]){
			this.position[0] += this.size[0] / 4;
			stop();
		}
	}

	private void stop(){
		this.velocity[0] = 0;
		this.velocity[1] = 0;
	}

	private void fireLaser(){
		this.game.createLaser(new int[]{this.position[0] + (this.size[0] / 2), this.position[1]}, this.velocity[0] / 2);
	}

}