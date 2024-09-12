package ea.codewars.core.object;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Ball {

	public Vector2 position;
	
	public int width;
	public int height;
	public float speed = 5;
	
	private float x, y;
	
	public Ball(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		this.position = new Vector2(x, y);
		
		this.x = 1;
		this.y = 0;
		
	}
	
	public void update(float delta) {
		
		this.position.x += speed * this.x;
		this.position.y += speed * this.y;
		
	}
	
	public void schimba(float x, float y) {
		
		this.x = x;
		this.y = y;
		
		this.speed += 0.5;
		
	}
	
	public void reset() {
		
		Random ran = new Random();
		
		this.position.x = 400;
		this.position.y = 240;
		
		this.speed = 10;
		this.x = 1;
		this.y = ran.nextFloat();
		
	}
	
	public void shimba2() {
		
		this.y = -this.y;
		
	}
	
}
