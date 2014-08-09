package kadai004;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DBframe extends JFrame implements ActionListener {
	JFrame f;
	JPanel p, p1, p2, p3, p4, p5, p6, show, btnp;
	JLabel l = null;
	JLabel message = null;
	CardLayout layout;
	GridLayout glayout;
	JButton load, create, print, max, min, avg, close;
	DBCall db = new DBCall();
	JLabel dblabel = new JLabel();

	public static void main(String[] args) {
		DBframe df = new DBframe();
		df.setVisible(true);
	}

	DBframe() {
		setTitle("DB操作システム");
		setSize(700, 500);

		panel();
		layout = new CardLayout();
		glayout = new GridLayout();
//		message = new JLabel("作成されました");

		createb();
		printb();
		maxb();
		minb();
		avgb();
		closeb();

		show.setLayout(layout);
		show.add(p1, "create");
		show.add(p2, "print");
		show.add(p3, "max");
		show.add(p4, "min");
		show.add(p5, "avg");
		show.add(p6, "close");

		btnp.setLayout(glayout);
		btnp.add(create);
		btnp.add(print);
		btnp.add(max);
		btnp.add(min);
		btnp.add(avg);
		btnp.add(close);

		l = new JLabel("操作を選択してください。");
		p.add(l);

		add(p, BorderLayout.NORTH);
		add(btnp, BorderLayout.SOUTH);
		add(show, BorderLayout.CENTER);

	}

	public void panel() {
		show = new JPanel();
		btnp = new JPanel();
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
	}

	public void createb() {
		create = new JButton("DB作成");
		p1.add(create);
		create.addActionListener(this);
		create.setActionCommand("create");
	}

	public void printb() {
		print = new JButton("DB表示");
		message = new JLabel("表示されました");
		p2.add(print);
		p2.add(message);
		print.addActionListener(this);
		print.setActionCommand("print");
	}

	public void maxb() {
		max = new JButton("最高気温日");
		message = new JLabel("最高気温日です");
		p3.add(max);
		p3.add(message);
		max.addActionListener(this);
		max.setActionCommand("max");
	}

	public void minb() {
		min = new JButton("最低気温日");
		message = new JLabel("最低気温です");
		p4.add(min);
		p4.add(message);
		min.addActionListener(this);
		min.setActionCommand("min");
	}

	public void avgb() {
		avg = new JButton("年間平均気温");
		message = new JLabel("年間平均気温です");
		p5.add(avg);
		p5.add(message);
		avg.addActionListener(this);
		avg.setActionCommand("avg");
	}

	public void closeb() {
		close = new JButton("DB切断");
		message = new JLabel("DBサーバ切断しました。");
		p6.add(close);
		p6.add(message);
		close.addActionListener(this);
		close.setActionCommand("close");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("create")) {
			db.DBcreate();
			layout.show(show, cmd);
		} else if (cmd.equals("print")) {
			db.printData();
			layout.show(show, cmd);

		} else if (cmd.equals("max")) {
			db.DataMax();
			dblabel.setText(DBCall.maxD);
			p3.add(dblabel);
			layout.show(show, cmd);
		} else if (cmd.equals("min")) {
			db.DataMin();
			dblabel.setText(DBCall.minD);
			p4.add(dblabel);
			layout.show(show, cmd);
		} else if (cmd.equals("avg")) {
			db.DataAvg();
			dblabel.setText(DBCall.avgD);
			p5.add(dblabel);
			layout.show(show, cmd);
		} else if (cmd.equals("close")) {
			db.close();
			System.exit(0);
		}

	}
}
