package gamepanel;

import gameobjects.*;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

	private int[] list;

	private ArrayList<GameObject> GameObjects;

	public GamePanel(ArrayList<GameObject> Objects, int width, int height){
		setSize(width, height);
		GameObjects = Objects;
	}

	public void paint(Graphics g){

		for (int i = 0; i < GameObjects.size(); i++){
			g.drawOval(
				GameObjects.get(i).position[0], 
				GameObjects.get(i).position[1], 
				GameObjects.get(i).size[0],
				GameObjects.get(i).size[1]
			);
		}
	}

}