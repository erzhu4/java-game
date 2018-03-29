package mypanel;

import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanel extends JPanel {

	private int[] list;

	public MyPanel(int[] arr){
		setSize(500, 500);
		list = arr;
	}

	public void paint(Graphics g){
		g.drawOval(list[0], 100, 50, 50);
		g.drawOval(list[1], 10, 50, 50);
		g.drawOval(list[2], 50, 50, 50);
	}

}