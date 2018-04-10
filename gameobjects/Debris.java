package gameobjects;

class Debris extends GameObject {

	public void Debris(int[] startPositionArg, int[] velocityArg, coolgame.CoolGame gameArg){
		super(startPositionArg, velocityArg, new int[]{10,10}, gameArg);
		this.type = "debris";
	}

}