package ea.codewars.core.object;

import com.badlogic.gdx.math.Vector2;

public class Bot {
	public Vector2 position;
	public int width;
	public int height;
	public float currentball;
	public float oldball;

	public Bot(float x, float y, int width, int height) {

		this.width = width;
		this.height = height;

		this.position = new Vector2(x, y);
		this.currentball = 400;
		this.oldball = 400;
	}

	public void moveBot1(Ball ball) {
		currentball = ball.position.x;
		if(currentball<350)
		{
			if (oldball -currentball > 30) {
				oldball = currentball;
				this.position.y = Math.min(ball.position.y - 40,position.y+10);
			}
		}
		else
		{
			oldball=400;
		}

	}

	public void moveBot2(Ball ball) {
		currentball = ball.position.x;
		if(currentball>450)
		{
			if (currentball - oldball > 30) {
				oldball = currentball;
				this.position.y = Math.min(ball.position.y - 40,position.y+10);
			}
		}
		else
		{
			oldball=400;
		}
	}

}
