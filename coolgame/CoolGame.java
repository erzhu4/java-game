package coolgame;

import gamepanel.*;
import gameobjects.*;
import enemy.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class CoolGame{

	private JFrame frame;
	private GamePanel gamepanel;

	private int width = 800;
	private int height = 600;
	private int numOfEnemies = 15;
	private int gameFPS = 32;

	private ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();

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

        gamepanel = new GamePanel(GameObjects, width + 50, height);
        frame.add(gamepanel);
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 1000/gameFPS);
	}

	private void setUpGame(){

		for (int i = 0; i < numOfEnemies; i++){
			Random rand = new Random();

			GameObjects.add(new Enemy(
					new int[]{rand.nextInt(width),10}, 
					new int[]{0,rand.nextInt(3) + 1},
					height
				)
			);
		}
	}



	private void iterateGame(){
		for (int i = 0; i < GameObjects.size(); i++){
			GameObjects.get(i).move();
			GameObjects.get(i).checkColide();
		}
		gamepanel.repaint();
	}

}