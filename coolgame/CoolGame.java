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
	public ArrayList<GameObject> allGameObjects = new ArrayList<GameObject>();

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
        this.gamepanel = new GamePanel(this.allGameObjects, this.width + 50, this.height);
        this.frame.add(this.gamepanel);
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 1000/this.gameFPS);
	}

	private int countEnemies(){
		int sum = 0;
		for (GameObject obj: this.allGameObjects){
			if (obj.type == "enemy"){
				sum += 1;
			}
		}
		return sum;
	}

	public void removeObject(GameObject obj){
		this.allGameObjects.remove(obj);
	}

	public void addObject(GameObject obj){
		this.allGameObjects.add(obj);
	}

	public void createLaser(int[] position, int xVelocity){
		this.allGameObjects.add(new Laser(
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
		int missingEnemies = this.numOfEnemies - this.countEnemies();

		if (missingEnemies <= 0){
			return;
		}

		for (int i = 0; i < missingEnemies; i++){
			Random rand = new Random();
			this.allGameObjects.add(new Enemy(
					new int[]{rand.nextInt(width) + 5, 10}, 
					new int[]{0, rand.nextInt(3) + 1},
					this
				)
			);
		}
	}

	private void createShip(){
		this.allGameObjects.add(new Ship(
				new int[]{width / 2, height - (Ship.shipSize * 2)},
				this
			)
		);
	}

	private void iterateGame(){
		for (int i = 0; i < this.allGameObjects.size(); i++){
			this.allGameObjects.get(i).move();
			this.allGameObjects.get(i).checkColide();
		}
		fillEnemies();
		this.gamepanel.repaint();
	}

}