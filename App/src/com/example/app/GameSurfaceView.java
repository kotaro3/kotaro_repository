package com.example.app;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView extends SurfaceView implements Runnable,
		SurfaceHolder.Callback {
	private Thread thread;
	private GameMgr gameMgr = new GameMgr();

	public GameSurfaceView(Context context) {
		super(context);
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread = new Thread(); //別スレッドでメインループ作成
		thread.start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// 解像度情報変更通知メソッド

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread = null;

	}

	@Override
	public void run() {
		while(thread!=null){// メインループ
			gameMgr.onUpdate();
			onDraw(getHolder());
		}
	}

	private void onDraw(SurfaceHolder holder) {
		//描画メソッド
		Canvas c = holder.lockCanvas();
		if(c==null){
			return;
		}
		//ここにゲーム描画処理を書く
		gameMgr.onDraw(c);
		holder.unlockCanvasAndPost(c);
		
	}

}
