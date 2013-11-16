package ca.proj.game.entities;

import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;

public abstract class Entity {
	
	public int x;
	public int y;
	protected static Level level;
	
	public Entity(Level level) {
		init(level);
		
	}
	
	public final void init(Level level) {
		this.level = level;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen);

}
