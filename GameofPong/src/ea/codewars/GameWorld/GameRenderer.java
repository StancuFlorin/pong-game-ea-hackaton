package ea.codewars.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ea.codewars.GameOjects.Wall;
import ea.codewars.Helpers.AssetLoader;

public class GameRenderer {

	public int scor1, scor2;
	public boolean human;
	private GameWorld myWorld;
	private OrthographicCamera cam;

	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;

	private float gameHeight;

	public boolean game_over = false;

	public GameRenderer(GameWorld world) {

		setMyWorld(world);

		this.gameHeight = world.gameHeight;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 800, gameHeight);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		this.scor1 = 0;
		this.scor2 = 0;
		this.human = true;
	}

	public void render(float runTime) {

		SpriteBatch spriteBatch = new SpriteBatch();
		BitmapFont font = new BitmapFont();

		// Fill the entire screen with black, to prevent potential flickering.
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// Begin SpriteBatch
		batcher.begin();

		// Disable transparency
		// This is good for performance when drawing images that do not require
		// transparency.
		batcher.disableBlending();

		for (Wall wall : myWorld.walls) {
			batcher.draw(AssetLoader.wall, wall.position.x, wall.position.y,
					wall.width, wall.height);
		}
		myWorld.bot1.moveBot1(myWorld.ball);
		myWorld.bot2.moveBot2(myWorld.ball);
		if (human) {
			batcher.draw(AssetLoader.player, myWorld.player1.position.x,
					myWorld.player1.position.y, myWorld.player1.width,
					myWorld.player1.height);
		} else {
			batcher.draw(AssetLoader.player, myWorld.bot1.position.x,
					myWorld.bot1.position.y, myWorld.bot1.width,
					myWorld.bot1.height);
		}
		batcher.draw(AssetLoader.player, myWorld.bot2.position.x,
				myWorld.bot2.position.y, myWorld.bot2.width,
				myWorld.bot2.height);
		// batcher.draw(AssetLoader.player, myWorld.player2.position.x,
		// myWorld.player2.position.y, myWorld.player2.width,
		// myWorld.player2.height);

		if (game_over) {
			batcher.end();
			myWorld.ball.reset();
			game_over = false;
			return;
		}

		// The bird needs transparency, so we enable that again.
		batcher.enableBlending();

		batcher.draw(AssetLoader.ball, myWorld.ball.position.x,
				myWorld.ball.position.y, myWorld.ball.width,
				myWorld.ball.height);

		// End SpriteBatch
		batcher.end();

		if (myWorld.ball.position.y < 20)
			myWorld.ball.shimba2();

		if (myWorld.ball.position.y > 400)
			myWorld.ball.shimba2();
		if (human) {
			if (myWorld.ball.position.x < 40)
				if ((myWorld.player1.position.y + 32 < myWorld.ball.position.y + 25)
						&& (myWorld.player1.position.y + 64 > myWorld.ball.position.y + 25))
					myWorld.ball.schimba(1, 0);
				else if ((myWorld.player1.position.y < myWorld.ball.position.y + 25)
						&& (myWorld.player1.position.y + 32 > myWorld.ball.position.y + 25))
					myWorld.ball.schimba(1, 0.5f);
				else if ((myWorld.player1.position.y + 64 < myWorld.ball.position.y + 25)
						&& (myWorld.player1.position.y + 96 > myWorld.ball.position.y + 25))
					myWorld.ball.schimba(1, -0.5f);
				else {
					game_over = true;
					scor1++;
					return;
				}
		}
		else
			if (myWorld.ball.position.x < 40)
				if ((myWorld.bot1.position.y + 32 < myWorld.ball.position.y )
						&& (myWorld.bot1.position.y + 64 > myWorld.ball.position.y ))
					myWorld.ball.schimba(1, 0);
				else if ((myWorld.bot1.position.y < myWorld.ball.position.y )
						&& (myWorld.bot1.position.y + 32 > myWorld.ball.position.y ))
					myWorld.ball.schimba(1, 0.5f);
				else if ((myWorld.bot1.position.y + 64 < myWorld.ball.position.y )
						&& (myWorld.bot1.position.y + 96 > myWorld.ball.position.y ))
					myWorld.ball.schimba(1, -0.5f);
				else {
					game_over = true;
					scor1++;
					return;
				}	
		if (myWorld.ball.position.x > 800 - 80)
			if ((myWorld.bot2.position.y + 32 < myWorld.ball.position.y )
					&& (myWorld.bot2.position.y + 64 > myWorld.ball.position.y ))
				myWorld.ball.schimba(-1, (float) Math.random());
			else if ((myWorld.bot2.position.y < myWorld.ball.position.y )
					&& (myWorld.bot2.position.y + 32 > myWorld.ball.position.y ))
				myWorld.ball.schimba(-1, (float) Math.random());
			else if ((myWorld.bot2.position.y + 64 < myWorld.ball.position.y )
					&& (myWorld.bot2.position.y + 96 > myWorld.ball.position.y ))
				myWorld.ball.schimba(-1, -(float) Math.random());
			else {
				game_over = true;
				scor2++;
				return;
			}

		spriteBatch.begin();
		font.draw(spriteBatch, "Scor Player2: " + scor2, 10, 50);
		font.draw(spriteBatch, "Scor Player1: " + scor1, 680, 50);
		spriteBatch.end();

	}

	public GameWorld getMyWorld() {
		return myWorld;
	}

	public void setMyWorld(GameWorld myWorld) {
		this.myWorld = myWorld;
	}

}
