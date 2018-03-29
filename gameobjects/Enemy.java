package gameobjects;

public class Enemy extends GameObject {

	private int maxYBorder;

	public Enemy(int[] startPositionArg, int[] velocityArg, int maxY){
		super(startPositionArg, velocityArg, new int[]{50,50});
		maxYBorder = maxY;
	}

	public void checkColide(){
		if (position[1] >= maxYBorder - size[1]){
			position[1] = size[1] / 2;
		}
	}

}