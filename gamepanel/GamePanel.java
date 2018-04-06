package gamepanel;

import gameobjects.*;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {

	private ArrayList<GameObject> objects;

	public GamePanel(ArrayList<GameObject> objs, int width, int height){
		setSize(width, height);
		objects = objs;
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		for (int i = 0; i < objects.size(); i++){
			g.drawImage(
				objects.get(i).image, 
				objects.get(i).position[0], 
				objects.get(i).position[1], 
				objects.get(i).size[0], 
				objects.get(i).size[1], 
				null
			);
		}
	}

}