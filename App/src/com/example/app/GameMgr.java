package com.example.app;

import java.util.LinkedList;

import android.graphics.Canvas;
import android.graphics.Color;

public class GameMgr {
	private LinkedList <Task>taskList = new LinkedList<Task>();//�^�X�N���X�g
	public GameMgr() {
		taskList.add(new Player());
		taskList.add(new FPScontroler());
	}

	public boolean onUpdate() {
		for(int i=0;i<taskList.size();i++){
			if(taskList.get(i).onUpdate() == false){//�X�V���s������
				taskList.remove();                  //���̃^�X�N��j���
				i--;
			}
		}
		return true;
	}

	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE);//���œh��Ԃ�
		for(int i=0;i<taskList.size();i++){
			taskList.get(i).onDraw(c);//�`��
		}
;		
	}

}
