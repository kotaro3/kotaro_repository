package Ateam;

public class Jiki extends Chara {
	private int tamaIntCount;

	Jiki() {
		super(app.jiki);
		tamaIntCount = 0;
		x = (app.getw() - w) / 2;
		y = app.geth() - h - 16;

	}
 @Override
	void move() {
		// 左移動
		if (Key.left) {
			x -= 4;
			if (x < 0)
				x = 0;
		}
		// 右移動
		if (Key.right) {
			x += 4;
			if (x > app.getw() - w)
				x = app.getw() - w;
		}
		// 弾発射
		if (tamaIntCount > 0)
			tamaIntCount--;
		if (Key.space) {
			if (tamaIntCount <= 0) {
				app.addList(new Tama(x + w / 2, y, 0, -8));
				app.sndShort.play();
				tamaIntCount = 5;
			}
		}
	}
@Override
	boolean checkHit(Chara t) {
		if (t instanceof Teki) {
			if (super.checkHit(t)) {
				// 敵と当たったら爆発、死亡、ゲームオーバー画面に移行
				app.sndBang.play();
				dead();
				app.goOver();
				return true;
			}
		}
		return false;
	}
}
