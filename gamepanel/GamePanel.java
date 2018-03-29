package gamepanel;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

	private int[] list;

	public GamePanel(int[] arr, int width, int height){
		setSize(width, height);
		list = arr;
	}

	public void paint(Graphics g){
		g.drawOval(list[0], 100, 50, 50);
		g.drawOval(list[1], 10, 50, 50);
		g.drawOval(list[2], 50, 50, 50);
	}

}