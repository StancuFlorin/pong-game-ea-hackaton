

import com.badlogic.gdx.Game;

import ea.codewars.Helpers.AssetLoader;
import ea.codewars.Screens.GameScreen;

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
