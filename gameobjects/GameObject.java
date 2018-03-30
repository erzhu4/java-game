package gameobjects;

import coolgame.*;

public class GameObject implements GameMovableElement  {

	public int[] position;
	public int[] velocity;
	public int[] size;

	protected CoolGame game;

	public GameObject(int[] startPositionArg, int[] velocityArg, int[] sizeArg, CoolGame gameArg){
		position = startPositionArg;
		velocity = velocityArg;
		size = sizeArg;
		game = gameArg;
	}

	public void move(){
		position[0] += velocity[0];
		position[1] += velocity[1];
	}

	public void checkColide(){}

}