package gameobjects;

import coolgame.*;

public class Enemy extends GameObject {

	public Enemy(int[] startPositionArg, int[] velocityArg, CoolGame gameArg){
		super(startPositionArg, velocityArg, new int[]{50,50}, gameArg);
	}

	public void checkColide(){
		if (position[1] >= game.height - size[1]){
			// position[1] = size[1] / 2;
			game.removeEnemy(this);
		}
	}

	public void destroy(){

	}

}