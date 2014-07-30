package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player extends Task {
	private final static float SIZE = 20;// 自機の大きさ
	private Circle cir = null;
	private Paint paint = new Paint();
	private Vec vec = new Vec();

	public Player() {
		cir = new Circle(240, 0, SIZE);
		paint.setColor(Color.BLUE);
		paint.setAntiAlias(true);
		vec.y = 2;
	}

	@Override
	public boolean onUpdate() {
		cir.x += vec.x;
		cir.y += vec.y;
		return true;
	}

	@Override
	public void onDraw(Canvas c) {
		c.drawCircle(cir.x, cir.y, cir.r, paint);
		super.onDraw(c);
	}

}
