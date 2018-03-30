package gameobjects;

import coolgame.*;

public class Ship extends GameObject {

	public Ship(int[] startPositionArg, CoolGame gameArg){
		super(startPositionArg, new int[]{0,0}, new int[]{40,40}, gameArg);
	}

}