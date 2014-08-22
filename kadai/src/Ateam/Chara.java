package Ateam;
import java.awt.Graphics;
import java.awt.Image;


abstract class Chara {
	protected static Shooting app;	// アプレット
	protected Image img;				// 画像
	protected int x, y;				// 座標
	protected int w, h;				// 幅、高さ
	private boolean dead;				// 死亡フラグ
	protected Chara(Image img){
		this.img = img;
		w = img.getWidth(app);
		h = img.getHeight(app);
		dead = false;
	}
	boolean isDead(){
		return dead;
	}
	void dead(){
		dead = true;
	}
	abstract void move();
	boolean checkHit(Chara t) {
		if (x > t.x - w && x < t.x + t.w && y > t.y - h && y < t.y + t.h) {
			return true;
		}
		return false;
	}

	// 描画
	void draw(Graphics g) {
		g.drawImage(img, x, y, app);
	}

}

