package com.example.app;

public class Vec {
	public float x, y;

	Vec() {
		x = y = 0;
	}

	Vec(float x, float y) {
		x = x;
		y = y;
	}

	float getAngle() {
		return (float) Math.atan2(y, x);
	}

	float getLength() {
		return (float) Math.sqrt(x * x + y * y);
	}

}
