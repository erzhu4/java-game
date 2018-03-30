package gameobjects;

import coolgame.*;

public class GameObject {

	public int[] position;
	public int[] velocity;
	public int[] size;

	public GameObject(int[] startPositionArg, int[] velocityArg, int[] sizeArg){
		position = startPositionArg;
		velocity = velocityArg;
		size = sizeArg;
	}

	public void move(){
		position[0] += velocity[0];
		position[1] += velocity[1];
	}

	public void destroy(){

	}

	public void checkColide(CoolGame game){

	}

}