package gamepanel;

import gameobjects.*;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {

	private ArrayList<GameObject> enemiesArr;
	private ArrayList<GameObject> lasersArr;
	private ArrayList<GameObject> shipsArr;

	public GamePanel(ArrayList<GameObject> enemies, ArrayList<GameObject> lasers, ArrayList<GameObject> ships, int width, int height){
		setSize(width, height);
		enemiesArr = enemies;
		lasersArr = lasers;
		shipsArr = ships;
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		for (int i = 0; i < enemiesArr.size(); i++){
			g.drawImage(
				enemiesArr.get(i).image,
				enemiesArr.get(i).position[0], 
				enemiesArr.get(i).position[1], 
				enemiesArr.get(i).size[0],
				enemiesArr.get(i).size[1],
				null
			);
		}

		for (int i = 0; i < lasersArr.size(); i++){
			g.drawOval(
				lasersArr.get(i).position[0], 
				lasersArr.get(i).position[1], 
				lasersArr.get(i).size[0],
				lasersArr.get(i).size[1]
			);
		}

		for (int i = 0; i < shipsArr.size(); i++){
			g.drawImage(
				shipsArr.get(i).image, 
				shipsArr.get(i).position[0], 
				shipsArr.get(i).position[1], 
				shipsArr.get(i).size[0], 
				shipsArr.get(i).size[1], 
				null
			);
		}
	}

}