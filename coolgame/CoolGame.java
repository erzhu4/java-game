package coolgame;

import gamepanel.*;
import gameobjects.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class CoolGame {

	public JFrame frame;
	private GamePanel gamepanel;

	public int width = 800;
	public int height = 800;

	private int numOfEnemies = 15;
	private int gameFPS = 32;

	public ArrayList<GameObject> enemies = new ArrayList<GameObject>();
	public ArrayList<GameObject> ship = new ArrayList<GameObject>();
	public ArrayList<GameObject> lasers = new ArrayList<GameObject>();

	private int counter = 0;

	class IterateGameTask extends TimerTask {

		IterateGameTask(){}

	 	public void run() {
	 		iterateGame();
	   	}
	}

	
	public CoolGame(JFrame jframe){
		this.frame = jframe;
	}

	public void start() {
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

	public void createLaser(int[] position, int xVelocity){
		this.lasers.add(new Laser(
				position,
				xVelocity,
				this
			)
		);
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
					new int[]{rand.nextInt(width) + 5, 10}, 
					new int[]{0, rand.nextInt(3) + 1},
					this
				)
			);
		}
	}

	private void createShip(){
		this.ship.add(new Ship(
				new int[]{width / 2, height - (Ship.shipSize * 2)},
				this
			)
		);
	}

	private void iterateGame(){
		for (int i = 0; i < this.enemies.size(); i++){
			this.enemies.get(i).move();
			this.enemies.get(i).checkColide();
		}
		for (int i = 0; i < this.ship.size(); i++){
			this.ship.get(i).move();
			this.ship.get(i).checkColide();
		}
		for (int i = 0; i < this.lasers.size(); i++){
			this.lasers.get(i).move();
			this.lasers.get(i).checkColide();
		}
		fillEnemies();
		this.gamepanel.repaint();
	}

}