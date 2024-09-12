package ea.codewars.core;

import com.badlogic.gdx.Game;

import ea.codewars.core.helper.AssetLoader;
import ea.codewars.core.screen.GameScreen;

public class PongGame extends Game {

	@Override
	public void create() {

		AssetLoader.load();
		setScreen(new GameScreen());
		
	}
	
    @Override
    public void dispose() {
    	
        super.dispose();
        AssetLoader.dispose();
        
    }

}
