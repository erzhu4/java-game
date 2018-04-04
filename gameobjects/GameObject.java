package gameobjects;

import coolgame.CoolGame;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class GameObject implements GameMovableElement  {

	public int[] position;
	public int[] velocity;
	public int[] size;
	public BufferedImage image;

	protected CoolGame game;

	public GameObject(int[] startPositionArg, int[] velocityArg, int[] sizeArg, CoolGame gameArg, String imagePath){
		this.position = startPositionArg;
		this.velocity = velocityArg;
		this.size = sizeArg;
		this.game = gameArg;
		try {
			this.image = ImageIO.read(new File(imagePath));
		} catch (IOException e){
			System.out.println(e);
		}
	}

	public GameObject(int[] startPositionArg, int[] velocityArg, int[] sizeArg, CoolGame gameArg){
		this(startPositionArg, velocityArg, sizeArg, gameArg, "images/noimage.jpg");
	}

	public void move(){
		this.position[0] += this.velocity[0];
		this.position[1] += this.velocity[1];
	}

	protected boolean checkOutOfBounds(){
		return (
			this.position[1] >= this.game.height - this.size[1] 
			|| this.position[1] < 0
		);
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