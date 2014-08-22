package Ateam;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Vector;

public class Shooting extends Applet implements Runnable {
	// 自機画像
	private Vector<Chara> clist, clistTmp;
	Image jiki, tama, teki;
	private Image offImage;
	private Graphics gv;
	private int score;
	private int scene;
	private final int SCENE_INIT = 0;
	private final int SCENE_TITLE = 1;
	private final int SCENE_MAIN = 2;
	private final int SCENE_OVER = 3;
	private Font scoreFont;
	private int width = 700;
	private int height = 500;
	private MediaTracker mt;
	private int tekiInterval;
	private int tekiIntCount;
	AudioClip sndShort, sndBang;

	// 描画の処理
	private volatile Thread gameThread;

	// ブラウザが読み込まれた時の処理
	public void init() {
		System.out.println("sssssssss");
		width = getSize().width;
		height = getSize().height;

		score = SCENE_INIT;
		scoreFont = new Font("Arial", Font.BOLD, 12);

		setBackground(Color.black);
		setForeground(Color.white);

		offImage = createImage(width, height);
		gv = offImage.getGraphics();

		addKeyListener(new Key());
		Chara.app = this;
		mt = new MediaTracker(this);
		clist = new Vector<Chara>();
		clistTmp = new Vector<Chara>();

		jiki = getImage(getDocumentBase(), "jiki.gif");
		mt.addImage(jiki, 0);
		tama = getImage(getDocumentBase(), "01.png");
		mt.addImage(tama, 1);
		teki = getImage(getDocumentBase(), "teki.gif");
		mt.addImage(teki, 2);

		sndShort = getAudioClip(getDocumentBase(), "shot003.wav");
		sndBang = getAudioClip(getDocumentBase(), "baku008st.wav");
		requestFocus();
	}

	/*
	 * @see java.applet.Applet#start() ゲームの処理用のスレッドを作成して開始する Appretが表示されたときの処理
	 */
	@Override
	public void start() {
		if (gameThread == null)
			System.out.println("aaaaa");
		gameThread = new Thread(this);
		gameThread.start();
	}

	/*
	 * @see java.applet.Applet#stop() アプレットが停止した時に呼ばれる処理 ブラウザを他のページに切り替えたときに呼ばれる
	 */
	@Override
	public void stop() {
		gameThread = null;

	}

	/*
	 * @see java.lang.Runnable#run() スレッドの処理 ゲームの処理をここに書く
	 */
	@Override
	public void run() {
		System.out.println("qqqqqqq");
		while (gameThread == Thread.currentThread()) {
			System.out.println("wwwwww");
			gv.clearRect(0, 0, width, height);
			switch (scene) {
			case SCENE_INIT:
				gameInit();
				break;
			case SCENE_TITLE:
				gameTitle();
				break;
			case SCENE_MAIN:
				gameMain();
				break;
			case SCENE_OVER:
				gameOver();
				break;
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	private void gameInit() {
		System.out.println("bbbbbbbb");
		drawCenter("Loading...", 180);
		if (mt.statusAll(true) == MediaTracker.COMPLETE) {
			ready();
			scene = SCENE_TITLE;
		}
	}

	// 準備処理
	private void ready() {
		System.out.println("rrrrrrrrrrrr");
		score = 0;
		tekiInterval = 50;
		tekiIntCount = tekiInterval;
		// キャラクタリストクリア
		clist.setSize(0);
		clistTmp.setSize(0);
		addList(new Jiki());
	}

	public void gameTitle() {
		System.out.println("tttttttttt");
		if (Key.enter) {
			System.gc();
			scene = SCENE_MAIN;
		}
		gv.setFont(new Font("Arial", Font.BOLD, 28));
		drawCenter("SHOOTING GAME!",50);
		gv.setFont(new Font("Arial", Font.PLAIN, 20));
		drawCenter("HIT ENTER KEY.", 380);
	}

	public void gameMain() {
		System.out.println("mmmmmmmm");
		System.out.println(clist.size());
		int i = 0;
		int j;
		Chara c, c2;
			System.out.println("mvmvmvmv");
			while(i == 0){


			c = clist.elementAt(i);
			c.move();
			c.draw(gv);
			for (j = 0; j < clist.size(); j++) {
				c2 = (clist.elementAt(j));
				c.checkHit(c2);
			}

			while (i < clist.size()) {
				c = (clist.elementAt(i));
				if (c.isDead())
					clist.removeElementAt(i);
				else
					i++;
			}

			if (tekiIntCount <= 0) {
				addList(new Teki());
				tekiInterval--;
				if (tekiInterval < 1)
					tekiInterval = 1;
				tekiIntCount = tekiInterval;
			} else
				tekiIntCount--;

//			for (i = 0; i < clistTmp.size(); i++) {
//				clist.addElement(clistTmp.elementAt(i));
//			}
			clistTmp.setSize(0);
			gv.setFont(scoreFont);
			gv.drawString("SCORE:" + String.valueOf(score), 10, 20);
		}
	}


	public void gameOver() {
		if (Key.enter) {
			ready();
			scene = SCENE_TITLE;
		}
		gv.setFont(new Font("Arial", Font.BOLD, 28));
		drawCenter("GAME OVER", 180);
		gv.setFont(new Font("Arial", Font.PLAIN, 20));
		drawCenter("SCORE : "+ String.valueOf(score), 350);
	}

	public int getw() {
		return width;
	}

	public int geth() {
		return height;
	}

	private void drawCenter(String str,int y) {
		FontMetrics fm = getFontMetrics(gv.getFont());
		gv.drawString(str, (width - fm.stringWidth(str)) / 2, y);
	}

	void goOver() {
		scene = SCENE_OVER;
	}

	void addList(Chara c) {
		clist.addElement(c);

	}

	void addScore(int s) {
		score += s;
	}

	@Override
	public void paint(Graphics g) {
		// 裏画面から表画面へ転送
		g.drawImage(offImage, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

}
