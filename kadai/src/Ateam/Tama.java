package Ateam;
class Tama extends Chara {
	int vx, vy;

	Tama(int x, int y, int vx, int vy) {
		super(app.tama);
		this.x = x - w / 2;
		this.y = y - h / 2;
		this.vx = vx;
		this.vy = vy;
	}

	void move() {
		x += vx;
		y += vy;
		if (x < -w || x > app.getw() || y < -h || y > app.geth())
			dead();
	}

	boolean checkHit(Chara t) {
		return false;
	}

}
