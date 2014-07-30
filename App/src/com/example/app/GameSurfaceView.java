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
		thread = new Thread(this); //�ʃX���b�h�Ń��C�����[�v�쐬
		thread.start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// �𑜓x���ύX�ʒm���\�b�h

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread = null;

	}

	@Override
	public void run() {
		while(thread!=null){// ���C�����[�v
			gameMgr.onUpdate();
			onDraw(getHolder());
		}
	}

	private void onDraw(SurfaceHolder holder) {
		//�`�惁�\�b�h
		Canvas c = holder.lockCanvas();
		if(c==null){
			return;
		}
		//�����ɃQ�[���`�揈��������
		gameMgr.onDraw(c);
		holder.unlockCanvasAndPost(c);
		
	}

}
