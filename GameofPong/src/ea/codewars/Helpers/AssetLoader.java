package ea.codewars.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	
    public static TextureRegion wall;
    public static TextureRegion player;
    public static TextureRegion ball;
    
    public static void load() {
    	
    	texture = new Texture(Gdx.files.internal("data/texture.png"));
    	texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	
    	wall = new TextureRegion(texture, 0, 0, 170, 20);
    	wall.flip(false, true);
    	
    	player = new TextureRegion(texture, 0, 20, 32, 96);
    	player.flip(false, true);

    	ball = new TextureRegion(texture, 32, 20, 50, 50);
    	ball.flip(false, true);
    	
    }
    
    public static void dispose() {
    	
        texture.dispose();
        
    }
    
}
