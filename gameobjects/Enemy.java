package gameobjects;

import coolgame.CoolGame;
import java.util.Random;

public class Enemy extends GameObject {

	public Enemy(int[] startPositionArg, int[] velocityArg, CoolGame gameArg){
		super(startPositionArg, velocityArg, new int[]{60,60}, gameArg, "images/enemy.png");
		this.type = "enemy";
	}

	public void destroy(){
		Random rand = CoolGame.random;
		GameObject debris1 = new Debris(
			new int[]{this.position[0], this.position[1]},
			new int[]{rand.nextInt(15) + 5, rand.nextInt(15) + 5}, 
			this.game
		);
		GameObject debris2 = new Debris(
			this.position, 
			new int[]{rand.nextInt(15) + 5, (rand.nextInt(15) + 5) * -1}, 
			this.game
		);
		GameObject debris3 = new Debris(
			new int[]{this.position[0], this.position[1]},
			new int[]{(rand.nextInt(15) + 5) * -1, rand.nextInt(15) + 5}, 
			this.game
		);
		GameObject debris4 = new Debris(
			new int[]{this.position[0], this.position[1]},
			new int[]{(rand.nextInt(15) + 5) * -1, (rand.nextInt(15) + 5) * -1}, 
			this.game
		);
		this.game.addObject(debris1);
		this.game.addObject(debris2);
		this.game.addObject(debris3);
		this.game.addObject(debris4);
		super.destroy();
	}

}