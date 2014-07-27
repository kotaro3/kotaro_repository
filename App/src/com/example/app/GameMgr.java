package com.example.app;

import java.util.LinkedList;

import android.graphics.Canvas;
import android.graphics.Color;

public class GameMgr {
	private LinkedList <Task>taskList = new LinkedList<Task>();//タスクリスト
	public GameMgr() {
		taskList.add(new FPScontroler());
	}

	public boolean onUpdate() {
		for(int i=0;i<taskList.size();i++){
			if(taskList.get(i).onUpdate() == false){//更新失敗したら
				taskList.remove();                  //そのタスクを破棄する
				i--;
			}
		}
		return true;
	}

	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE);//白で塗りつぶす
		for(int i=0;i<taskList.size();i++){
			taskList.get(i).onDraw(c);//描画
		}
;		
	}

}
