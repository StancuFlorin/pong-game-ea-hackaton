package ea.codewars.Screens;

public class Singleton {

	private static Singleton instance = new Singleton();

    private float gameWidth;
    private float gameHeight;
	
    public Singleton() {}
    
	public Singleton(float gameWidth, float gameHeight) {
		
		Singleton.getInstance().setGameHeight(gameHeight);
		Singleton.getInstance().setGameWidth(gameWidth);
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}

	public float getGameWidth() {
		return gameWidth;
	}

	public void setGameWidth(float gameWidth) {
		this.gameWidth = gameWidth;
	}

	public float getGameHeight() {
		return gameHeight;
	}

	public void setGameHeight(float gameHeight) {
		this.gameHeight = gameHeight;
	}
	
}
