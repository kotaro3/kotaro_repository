package Ateam;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		super.keyTyped(e);
	}

	static boolean left, right, space, enter;

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break; // ←
		case KeyEvent.VK_RIGHT:
			right = true;
			break; // →
		case KeyEvent.VK_SPACE:
			space = true;
			break; // SPACE
		case KeyEvent.VK_ENTER:
			enter = true;
			break; // Enter
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break; // ←
		case KeyEvent.VK_RIGHT:
			right = false;
			break; // →
		case KeyEvent.VK_SPACE:
			space = false;
			break; // SPACE
		case KeyEvent.VK_ENTER:
			enter = false;
			break; // Enter
		}
	}

}
