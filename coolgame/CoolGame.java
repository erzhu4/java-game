package coolgame;

import java.util.Timer;
import java.util.TimerTask;

public class CoolGame{

	private int counter = 0;

	class IterateGame extends TimerTask {
		IterateGame(){}
	 	public void run() {
	 		incrementCounter();
			System.out.println("Game Ran");
			System.out.println(counter);
	   	}
	}
	
	public CoolGame(){

	}

	public void start(){
		Timer timer = new Timer();

		timer.schedule(new IterateGame(), 1000, 1000);
	}

	private void incrementCounter(){
		counter++;
	}

}