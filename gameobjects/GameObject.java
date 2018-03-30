package gameobjects;

import coolgame.*;

public class GameObject implements GameMovableElement  {

	public int[] position;
	public int[] velocity;
	public int[] size;

	protected CoolGame game;

	public GameObject(int[] startPositionArg, int[] velocityArg, int[] sizeArg, CoolGame gameArg){
		this.position = startPositionArg;
		this.velocity = velocityArg;
		this.size = sizeArg;
		this.game = gameArg;
	}

	public void move(){
		this.position[0] += this.velocity[0];
		this.position[1] += this.velocity[1];
	}

	public void checkColide(){}

}