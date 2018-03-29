package mycanvas;

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	public void paint(Graphics g){
		g.fillOval(160, 160, 240, 240);
	}
}