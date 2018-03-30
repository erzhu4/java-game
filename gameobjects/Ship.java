package gameobjects;

import coolgame.*;

import java.awt.event.*;

public class Ship extends GameObject implements KeyListener {

	private int speed = 2;

	public Ship(int[] startPositionArg, CoolGame gameArg){
		super(startPositionArg, new int[]{0,0}, new int[]{40,40}, gameArg);
		gameArg.frame.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e){
		char key = e.getKeyChar();
		if (key == 'a'){
			System.out.println("go left");
		} else if (key == 'd'){
			System.out.println("go right");
		} else if (key == ' '){
			System.out.println("SHOOT!!!");
		}
	}

	public void keyReleased(KeyEvent e){
		// System.out.println("ship released");
	}

	public void keyTyped(KeyEvent e){}


	public void checkColide(){
		
	}

}