package gameobjects;

import coolgame.*;

import java.lang.*;

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

	public boolean checkCollisionWith(GameObject otherObject){
		double distance = this.getDistance(this.position, otherObject.position);
		return distance < ((this.size[0]) + (otherObject.size[0]));
	}

	private double getDistance(int[] pos1, int[] pos2){
		return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
	}

}