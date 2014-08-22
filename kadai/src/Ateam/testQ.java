import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testQ extends Applet
implements ActionListener{
	//private Checkbox CB[];
	//private CheckboxGroup CBG;
	private Button BT1,BT2,BT3,BT4;
	private Label QL,PL;
	private Panel P1,P2;
	private String[][]question ={
			{"問題1:朝賀先生は何部の顧問？","A","B","C","D","1"},//問題表示
			{"問題2:合宿で泊まった場所は？","ファームシティ","FJB","カプセルホテル","キャンプ","2"},
			{"問題3:サイコロの目の表と裏の合計","7","13","9","10","3"},
			{"問題4:二日目の昼食を運んだのは？","セブンイレブン","ローソン","ウェルシア","朝賀先生","4"},
			{"問題","A","B","C","D","5"},};

	private int rightAns, count;
	String result;
	public void init(){
		rightAns = Integer.parseInt(question[0][5]);
		count = 0;

		setLayout(new GridLayout(5,1));
		// CBG = new CheckboxGroup();
		add(QL = new Label(question[0][0]));
		add(P1 = new Panel(new GridLayout(2,3)));
		P1.add(BT1 = new Button("技術部"));
		P1.add(BT2 = new Button("華道部"));
		add(P2 = new Panel(new GridLayout(2,3)));
		P2.add(BT3 = new Button("野球部"));
		P2.add(BT4 = new Button ("全部活担当"));//解答ボタン作成
		//add(BT = new Button("答える"));

		BT1.addActionListener(this);
		BT1.setActionCommand("BT1");

		BT2.addActionListener(this);
		BT2.setActionCommand("BT2");

		BT3.addActionListener(this);
		BT3.setActionCommand("BT3");

		BT4.addActionListener(this);
		BT4.setActionCommand("BT4");

		add(PL = new Label(""));
	}

	public void actionPerformed(ActionEvent ae){
		try{
			if(ae.getActionCommand().compareTo("BT1")==0){
				//if(CB[rightAns].getState()){
				judgement(true);
			}
			else if(ae.getActionCommand().compareTo("BT2")==0){
				judgement(false);
			}
			else if(ae.getActionCommand().compareTo("BT3")==0){
				judgement(false);
			}
			else if(ae.getActionCommand().compareTo("BT4")==0){
				judgement(false);
			}
			setQuestion();
			//}
		}
		catch(Exception e){
			PL.setText(e.toString());
		}
	}

	private void setQuestion(){
		QL.setText(question[count][0]);
		rightAns = Integer.parseInt(question[count][5]);
		BT1.setLabel(question[count][1]);
		BT2.setLabel(question[count][2]);
		BT3.setLabel(question[count][3]);
		BT4.setLabel(question[count][4]);
		repaint();
	}
	private void judgement(boolean ans){

		if(ans == true){
			result = "正解";
			PL.setText(result);
		}
		else if(ans == false){
			result = "不正解";
			PL.setText(result);
		}
		if(count == 9){
			PL.setText(result);
		}
		else{
			PL.setText(result);
			count++;//結果表示
		}
	}
}


