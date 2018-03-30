package gameobjects;

import coolgame.*;

public class Enemy extends GameObject {

	public Enemy(int[] startPositionArg, int[] velocityArg, CoolGame gameArg){
		super(startPositionArg, velocityArg, new int[]{50,50}, gameArg);
	}

	public void checkColide(){
		if (this.position[1] >= this.game.height - this.size[1]){
			// position[1] = size[1] / 2;
			this.game.removeEnemy(this);
		}
	}

	public void destroy(){

	}

}