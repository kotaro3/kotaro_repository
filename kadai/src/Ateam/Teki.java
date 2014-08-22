package Ateam;

class Teki extends Chara {

	Teki() {
		super(app.teki);
		x = (int) (Math.random() * app.getw() - w);
		y = -h;
	}
 @Override
	void move() {
		y += 8;
		if (y > app.geth())
			dead();
	}
@Override
	boolean checkHit(Chara t) {
	super.checkHit(t);
		if (t instanceof Tama) {
			if (super.checkHit(t)) {
				app.sndBang.play();
				app.addScore(100);
				dead();
				t.dead();
				return true;
			}
		}
		return false;
	}

}
