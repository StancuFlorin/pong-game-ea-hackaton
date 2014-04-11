package ea.codewars.GameOjects;

import com.badlogic.gdx.math.Vector2;

public class Wall {

	public Vector2 position;
	
	public int width;
	public int height;
	
	public Wall(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		this.position = new Vector2(x, y);
		
	}
	
}
