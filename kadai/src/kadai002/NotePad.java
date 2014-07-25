package kadai002;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import kadai002.Save;

/**
 * @author x13g020
 * 
 */
public class NotePad {
	static JFrame frame;
	static JTextArea area;
	static JPanel panel;
	static JButton save;
	static JButton load;
	static Save sv;


	/**
	 * @param args
	 *            main
	 */
	public static void main(String[] args) {
		frame = new JFrame("メモ帳");

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		area = new JTextArea(15, 40);
		area.setLineWrap(true);

		panel = new JPanel();
		save = new JButton("保存");
		save.addActionListener(new ActionListener() {
			/*
			 * (非 Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) 保存
			 */
			public void actionPerformed(ActionEvent event) {
				String str = area.getText();
				sv = new Save(str);

			}

		});
		load = new JButton("読込");
		load.addActionListener(new ActionListener() {
			/*
			 * (非 Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) 読込
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("i://メモ.txt");
					Scanner s = new Scanner(file);
					s.useDelimiter("\\r\\n");

					while (s.hasNext()) {
						String str = s.next();
						area.setText(str);
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			}
		});

		panel.add(area);
		panel.add(save);
		panel.add(load);

		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
