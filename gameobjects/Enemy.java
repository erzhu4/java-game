package gameobjects;

public class Enemy extends GameObject {

	public Enemy(int[] startPositionArg, int[] velocityArg, coolgame.CoolGame gameArg){
		super(startPositionArg, velocityArg, new int[]{50,50}, gameArg);
		this.type = "enemy";
	}

	public void checkColide(){
		if (this.checkOutOfBounds()){
			this.game.removeObject(this);
		}
	}

	public void destroy(){

	}

}