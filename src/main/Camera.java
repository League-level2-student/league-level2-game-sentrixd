package main;

public class Camera {
	GamePanel panel;
	Character chr;
	Map map;
	
	int x,y,lastx,lasty;
	
	Camera(GamePanel p, Map g) {
		panel = p;
		chr = panel.localPlayer;
		map = g;
		
		x = panel.x;
		y = panel.y;
		
		lastx = panel.x;
		lasty = panel.y;
	}
	
	void update() {
		x = panel.x;
		y = panel.y;
		
		if (lastx != x || lasty != y) {
			map.adjustMap(x,y);
		}
		
		lastx = panel.x;
		lasty = panel.y;
		chr.x = Platformer.WIDTH / 2 - chr.width;
		chr.y = Platformer.HEIGHT / 2 - chr.height;
	}
}
