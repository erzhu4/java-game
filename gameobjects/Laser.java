package gameobjects;

public class Laser extends GameObject {

	public Laser(int[] startPositionArg, int xVelocity, coolgame.CoolGame gameArg){
		super(startPositionArg, new int[]{xVelocity, -20}, new int[]{5,5}, gameArg);
		this.type = "laser";
	}

	public void checkColide(){
		if (this.checkOutOfBounds()){
			this.game.removeObject(this);
		}

		for (int i = 0; i < this.game.allGameObjects.size(); i++){
			if (this.game.allGameObjects.get(i).type != "enemy"){
				continue;
			}

			if ( this.checkCollisionWith(this.game.allGameObjects.get(i)) ){
				this.game.allGameObjects.get(i).destroy();
				this.destroy();
				return;
			}
		}
	}
}