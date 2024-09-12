package ea.codewars.core.object;

import com.badlogic.gdx.math.Vector2;

public class Player {

	public Vector2 position;
	
	public int width;
	public int height;
	
	public Player(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		this.position = new Vector2(x, y);
		
	}
	
	public void move(int y) {
		
		this.position.y = y;
		
	}
	
}
