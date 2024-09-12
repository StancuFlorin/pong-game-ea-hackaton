package ea.codewars.core.screen;

import ea.codewars.core.world.GameRenderer;
import ea.codewars.core.world.GameWorld;
import ea.codewars.core.helper.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;
	
	private float runTime;
	
	public GameScreen() {
		
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = 800;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
		world = new GameWorld(gameWidth, gameHeight);
		renderer = new GameRenderer(world);
		
		Gdx.input.setInputProcessor(new InputHandler(world.player1, world.player2));
		
		runTime = 0;
		
	}
	
	@Override
	public void render(float delta) {

		runTime += delta;
		
		world.update(delta);
		renderer.render(runTime);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
