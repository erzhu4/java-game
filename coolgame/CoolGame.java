package coolgame;

import gamepanel.*;
import gameobjects.*;

import java.awt.event.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class CoolGame implements KeyListener {

	public JFrame frame;
	private GamePanel gamepanel;

	public int width = 800;
	public int height = 600;

	private int numOfEnemies = 15;
	private int gameFPS = 32;

	private ArrayList<GameObject> enemies = new ArrayList<GameObject>();
	private ArrayList<GameObject> ship = new ArrayList<GameObject>();
	private ArrayList<GameObject> lasers = new ArrayList<GameObject>();

	private int counter = 0;

	class IterateGameTask extends TimerTask {

		IterateGameTask(){}

	 	public void run() {
	 		iterateGame();
	   	}
	}

	public void keyPressed(KeyEvent e){
		// System.out.println("action performed");
	}

	public void keyReleased(KeyEvent e){
		// System.out.println("released");
	}

	public void keyTyped(KeyEvent e){}

	
	public CoolGame(JFrame jframe){
		this.frame = jframe;
		this.frame.addKeyListener(this);
	}

	public void start(){
		this.frame.setSize(this.width + 50, this.height);
        this.frame.setVisible(true);

		setUpGame();
        this.gamepanel = new GamePanel(this.enemies, this.lasers, this.ship, this.width + 50, this.height);
        this.frame.add(this.gamepanel);
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 1000/this.gameFPS);
	}

	public void removeEnemy(GameObject enemy){
		this.enemies.remove(enemy);
	}

	public void removeLaser(GameObject laser){
		this.lasers.remove(laser);
	}

	private void setUpGame(){
		fillEnemies();
		createShip();
	}

	private void fillEnemies(){
		int missingEnemies = this.numOfEnemies - this.enemies.size();

		if (missingEnemies <= 0){
			return;
		}

		for (int i = 0; i < missingEnemies; i++){
			Random rand = new Random();
			this.enemies.add(new Enemy(
					new int[]{rand.nextInt(width),10}, 
					new int[]{0,rand.nextInt(3) + 1},
					this
				)
			);
		}
	}

	private void createShip(){
		this.ship.add(new Ship(
				new int[]{width / 2, height - 75},
				this
			)
		);
	}

	private void iterateGame(){
		for (int i = 0; i < this.enemies.size(); i++){
			this.enemies.get(i).checkColide();
			this.enemies.get(i).move();
		}
		fillEnemies();
		this.gamepanel.repaint();
	}

}