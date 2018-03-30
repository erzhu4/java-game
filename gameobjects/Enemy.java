package gameobjects;

import coolgame.*;

public class Enemy extends GameObject {

	private int maxYBorder;

	public Enemy(int[] startPositionArg, int[] velocityArg, int maxY){
		super(startPositionArg, velocityArg, new int[]{50,50});
		maxYBorder = maxY;
	}

	public void checkColide(CoolGame game){
		if (position[1] >= maxYBorder - size[1]){
			// position[1] = size[1] / 2;
			game.removeEnemy(this);
		}
	}

}