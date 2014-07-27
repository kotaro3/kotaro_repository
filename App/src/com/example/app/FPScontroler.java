package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class FPScontroler extends Task{
	private long startTime = 0;
	private int cnt = 0;
	private Paint paint = new Paint();
	private float fps;
	private final static int N = 60;
	private final static int FONT_SIZE = 20;
	
	public FPScontroler(){
		paint.setColor(Color.BLUE);
		paint.setTextSize(FONT_SIZE);
	}

	@Override
	public boolean onUpdate() {
		if(cnt==0){
			startTime = System.currentTimeMillis();
		}else if(cnt == N){
			long t = System.currentTimeMillis();
			fps = 1000.f/((t-startTime)/(float)N);
			cnt = 0;
			startTime = t;
		}
		cnt++;
		return true;
	}
	@Override
	public void onDraw(Canvas c) {
		c.drawText(String.format("%.1f", fps),0,FONT_SIZE-2,paint);
	}
	
}
