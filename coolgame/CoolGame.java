package coolgame;

import gamepanel.*;
import gameobjects.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class CoolGame{

	private JFrame frame;
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
	
	public CoolGame(JFrame jframe){
		frame = jframe;
	}

	public void start(){
		frame.setSize(width + 50, height);
        frame.setVisible(true);

		setUpGame();
        gamepanel = new GamePanel(enemies, lasers, ship, width + 50, height);
        frame.add(gamepanel);
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 1000/gameFPS);
	}

	public void removeEnemy(GameObject enemy){
		enemies.remove(enemy);
	}

	public void removeLaser(GameObject laser){
		lasers.remove(laser);
	}

	private void setUpGame(){
		fillEnemies();
		createShip();
	}

	private void fillEnemies(){
		int missingEnemies = numOfEnemies - enemies.size();

		if (missingEnemies <= 0){
			return;
		}

		for (int i = 0; i < missingEnemies; i++){
			Random rand = new Random();
			enemies.add(new Enemy(
					new int[]{rand.nextInt(width),10}, 
					new int[]{0,rand.nextInt(3) + 1},
					this
				)
			);
		}
	}

	private void createShip(){
		ship.add(new Ship(
				new int[]{width / 2, height - 75},
				this
			)
		);
	}

	private void iterateGame(){
		for (int i = 0; i < enemies.size(); i++){
			enemies.get(i).move();
			enemies.get(i).checkColide();
		}
		fillEnemies();
		gamepanel.repaint();
	}

}