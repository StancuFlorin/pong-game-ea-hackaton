package ea.codewars.core.helper;

import com.badlogic.gdx.InputProcessor;

import ea.codewars.core.object.Player;
import ea.codewars.core.world.GameRenderer;

import com.badlogic.gdx.Input;
public class InputHandler implements InputProcessor {

	private Player player1, player2;
	GameRenderer human;
	int x1, x2;
	int y1, y2;
	public InputHandler(Player p1, Player p2) {
		
		this.player1 = p1;
		this.player2 = p2;
		
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Input.Keys.SPACE)
		{
			
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (screenY < 400) {
			x1 = screenX;
			y1 = screenY;
			
			player1.move(screenY);
			
		} else {
			x2 = screenX;
			y2 = screenY;
			
			player2.move(screenY);
			
		}
		
		return false;
		
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		
		if (screenX > 400) {
			
			player2.move(screenY);
			
		} else {
			
			player1.move(screenY);
			
		}
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		//mario.onClick();
		if (screenX < 400) {
			
			player1.move(screenY);
			
		} else {
			
			player2.move(screenY);
			
		}
	
		return true;
	
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
