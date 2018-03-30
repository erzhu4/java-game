package gamepanel;

import gameobjects.*;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

	private ArrayList<GameObject> enemiesArr;
	private ArrayList<GameObject> lasersArr;
	private ArrayList<GameObject> shipsArr;

	public GamePanel(ArrayList<GameObject> enemies, ArrayList<GameObject> lasers, ArrayList<GameObject> ships, int width, int height){
		setSize(width, height);
		enemiesArr = enemies;
		lasersArr = lasers;
		shipsArr = ships;
	}

	public void paint(Graphics g){

		for (int i = 0; i < enemiesArr.size(); i++){
			g.drawOval(
				enemiesArr.get(i).position[0], 
				enemiesArr.get(i).position[1], 
				enemiesArr.get(i).size[0],
				enemiesArr.get(i).size[1]
			);
		}

		for (int i = 0; i < lasersArr.size(); i++){
			g.drawOval(
				enemiesArr.get(i).position[0], 
				enemiesArr.get(i).position[1], 
				enemiesArr.get(i).size[0],
				enemiesArr.get(i).size[1]
			);
		}

		for (int i = 0; i < shipsArr.size(); i++){
			g.drawOval(
				enemiesArr.get(i).position[0], 
				enemiesArr.get(i).position[1], 
				enemiesArr.get(i).size[0],
				enemiesArr.get(i).size[1]
			);
		}
	}

}