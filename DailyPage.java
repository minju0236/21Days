import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DailyPage extends JPanel implements ActionListener {
    private JPanel upPane = new JPanel();
    private JButton backBtn = new JButton("<-");
    private JLabel todayRecord = new JLabel("오늘의 기록");
    private JPanel centerPane1 = new JPanel();
    private JPanel centerPane2 = new JPanel();
    private JLabel goodthg = new JLabel(" 목표를 이루면서 잘한 점은?");
    private JTextArea goodthgArea = new JTextArea(2,40); //잘한점
    private JButton goodthgBtn = new JButton("V");
    private JLabel badthg = new JLabel(" 목표를 이루면서 아쉬웠던 점은?");
    private JTextArea badthgArea = new JTextArea(2,40); //아쉬운점
    private JButton badthgBtn = new JButton("V");
    private JPanel downPane = new JPanel();
    private JLabel goalNum = new JLabel("오늘의 목표 달성 점수");
    private JButton[] scoreBtns = new JButton[10]; //달성 점수
    private TodayEval todayEval; //해당일의 기록 보관


    public DailyPage(ActionListener listener) {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        upPane.setLayout(fl);
        FlowLayout fl1 = new FlowLayout();
        fl1.setAlignment(FlowLayout.LEFT);
        centerPane1.setLayout(fl1);
        FlowLayout fl2 = new FlowLayout();
        fl2.setAlignment(FlowLayout.LEFT);
        centerPane2.setLayout(fl2);
        FlowLayout fl3 = new FlowLayout();
        fl3.setAlignment(FlowLayout.LEFT);
        downPane.setLayout(fl3);

        upPane.setBackground(new Color(255, 254, 240));
        centerPane1.setBackground(new Color(255, 254, 240));
        centerPane2.setBackground(new Color(255, 254, 240));
        downPane.setBackground(new Color(255, 254, 240));

        //1
        backBtn.setPreferredSize(new Dimension(45,35));
        backBtn.setForeground(new Color(255, 250, 0));
        backBtn.setBackground(new Color(0, 116, 66));
        this.todayRecord.setFont(new Font("plain", Font.BOLD, 15));
        upPane.add(backBtn);
        upPane.add(todayRecord);
        add(upPane);

        //2
        this.goodthg.setFont(new Font("plain", Font.BOLD, 15));
        goodthg.setVerticalAlignment(SwingConstants.BOTTOM);
        add(goodthg);

        //3
        centerPane1.add(new JScrollPane(goodthgArea));
        goodthgBtn.setForeground(new Color(255, 250, 0));
        goodthgBtn.setBackground(new Color(0, 116, 66));
        goodthgBtn.addActionListener(this);
        goodthgBtn.setName("goodthgBtn");
        centerPane1.add(goodthgBtn);
        add(centerPane1);

        //4
        this.badthg.setFont(new Font("plain", Font.BOLD, 15));
        badthg.setVerticalAlignment(SwingConstants.BOTTOM);
        add(badthg);

        //5
        centerPane2.add(new JScrollPane(badthgArea));
        badthgBtn.setForeground(new Color(255, 250, 0));
        badthgBtn.setBackground(new Color(0, 116, 66));
        badthgBtn.addActionListener(this);
        badthgBtn.setName("badthgBtn");
        centerPane2.add(badthgBtn);
        add(centerPane2);


        //6
        this.goalNum.setFont(new Font("plain", Font.BOLD, 15));
        downPane.add(goalNum);
        for(int i = 0; i < 10; i++) {
            scoreBtns[i] = new JButton((i+1) + "");
            downPane.add(scoreBtns[i]);
            scoreBtns[i].setBackground(new Color(255, 253, 167));
            //버튼 클릭시 그 버튼만 빨강 나머지는 검정으로 변경
            scoreBtns[i].addActionListener(this);
        }
        add(downPane);

        this.backBtn.addActionListener(listener);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        if(btn.getText().equals("V")) {
            if(btn.getName().equals("goodthgBtn")) {
                this.todayEval.setGoodThgs(goodthgArea.getText());
            } else {
                this.todayEval.setBadThgs(badthgArea.getText());
            }
        } else {
            for(int i= 0; i< scoreBtns.length; i++) {
                this.scoreBtns[i].setForeground(Color.black);
                this.scoreBtns[i].setBackground(new Color(255, 253, 167));
            }
            btn.setForeground(new Color(0, 116, 66));
            btn.setBackground(new Color(255, 250, 0));
            this.todayEval.setScore(Integer.parseInt(btn.getText()));
        }
    }

    public void initPage(TodayEval todayEval) {
        this.todayEval = todayEval;
        goodthgArea.setText(this.todayEval.getGoodThgs());
        badthgArea.setText(this.todayEval.getBadThgs());

        int i = this.todayEval.getScore() - 1;
        if(i > -1) {
            scoreBtns[i].setForeground(new Color(0, 116, 66));
            scoreBtns[i].setBackground(new Color(255, 250, 0));
        }
    }

    public void clear() {
        goodthgArea.setText(null);
        badthgArea.setText(null);
        for(int i= 0; i< scoreBtns.length; i++) {
            this.scoreBtns[i].setForeground(Color.black);
            this.scoreBtns[i].setBackground(new Color(255, 253, 167));
        }
    }
}

