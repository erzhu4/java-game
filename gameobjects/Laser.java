package gameobjects;

public class Laser extends GameObject {

	public Laser(int[] startPositionArg, int xVelocity, coolgame.CoolGame gameArg){
		super(startPositionArg, new int[]{xVelocity, -20}, new int[]{5,5}, gameArg);
		this.type = "laser";
	}

	public void checkColide(){
		if (this.position[1] < this.size[1]){
			this.game.removeLaser(this);
		}

		for (int i = 0; i < this.game.enemies.size(); i++){
			if ( this.checkCollisionWith(this.game.enemies.get(i)) ){
				this.game.removeEnemy(this.game.enemies.get(i));
				this.game.removeLaser(this);
				return;
			}
		}
	}
}