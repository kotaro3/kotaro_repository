package com.example.app;

import android.app.Activity;
import android.os.Bundle;

public class Activity1 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GameSurfaceView(this));
	}

}
