package coolgame;

import mypanel.*;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class CoolGame{

	private JFrame frame;
	private MyPanel gamepanel;

	private int coords[] = {10, 120, 200};

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
		Timer timer = new Timer();
		timer.schedule(new IterateGameTask(), 1000, 100);
	}

	private void iterateGame(){
		coords[0]++;
		coords[1]++;
		coords[2] += 2;
        MyPanel panel = new MyPanel(coords);
        frame.add(panel);
		frame.setVisible(true);
	}

}