package ea.codewars.GameWorld;

import java.util.ArrayList;

import ea.codewars.GameOjects.Ball;
import ea.codewars.GameOjects.Bot;
import ea.codewars.GameOjects.Player;
import ea.codewars.GameOjects.Wall;


public class GameWorld {
	
	public ArrayList<Wall> walls = new ArrayList<Wall>();
	
	public Player player1;
	public Player player2;
	public Bot bot1;
	public Bot bot2;
	public Ball ball;
	
    public float gameWidth;
    public float gameHeight;
	
	public GameWorld(float gameWidth, float gameHeight) {
		
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		
		for (int i = 0; i < 5; i++)
			walls.add(new Wall(i * 170, 0, 170, 20));
		
		for (int i = 0; i < 5; i++)
			walls.add(new Wall(i * 170, 460, 173, 20));
		
		player1 = new Player(0, 100, 32, 96);
		player2 = new Player(770, 100, 32, 96);
		bot1 = new Bot(0, 100, 32, 96);
		bot2 = new Bot(770, 100, 32, 96);
		ball = new Ball(400, 240, 50, 50);
		
	}
	
	public void update(float delta) {
		
		ball.update(delta);
		
	}


}
