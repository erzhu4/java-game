package coolgame;

import gamepanel.*;
import gameobjects.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class CoolGame{

	private JFrame frame;
	private GamePanel gamepanel;

	private int coords[] = {10, 120, 200};

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
		frame.setSize(800, 600);
        frame.setVisible(true);

		setUpGame();

        gamepanel = new GamePanel(GameObjects, 800, 600);
        frame.add(gamepanel);
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 100);
	}

	private void setUpGame(){
		GameObjects.add(new GameObject(
			new int[]{10,10}, 
			new int[]{2,0},
			new int[]{50,50}
			)
		);
		GameObjects.add(new GameObject(
			new int[]{20,20}, 
			new int[]{2,0},
			new int[]{50,50}
			)
		);
		GameObjects.add(new GameObject(
			new int[]{10,30}, 
			new int[]{1,0},
			new int[]{25,25}
			)
		);
	}

	private void iterateGame(){

		for (int i = 0; i < GameObjects.size(); i++){
			GameObjects.get(i).move();
		}
		gamepanel.repaint();
	}

}