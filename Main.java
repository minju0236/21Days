import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Main extends JPanel implements ActionListener {
    private StratUp startUp;
    private JPanel upPane = new JPanel();
    private JPanel upPane1 = new JPanel();
    private JPanel upPane2 = new JPanel();
    private JLabel label = new JLabel(" ", JLabel.CENTER);
    private JPanel btnPanel = new JPanel();
    private JButton todayBtn = new JButton("오늘의 기록 보기");
    private JLabel blank = new JLabel(" ");
    private JLabel averageName = new JLabel("평균 목표 달성 점수", JLabel.CENTER);
    private JLabel average = new JLabel("0", JLabel.CENTER); //목표평균점수
    private JPanel downPane = new JPanel();
    private JPanel downPane1 = new JPanel();
    private JPanel downPane2 = new JPanel();
    private JPanel downPane3 = new JPanel();
    private JButton[][] dayBtns = new JButton[3][7];
    private Data data = new Data(); //목표 및 기록 데이터

    public Main(ActionListener listener) {
        this.startUp = (StratUp) listener;

        upPane.setLayout(new GridLayout(1,2));
        upPane1.setLayout(new GridLayout(2,1));
        upPane2.setLayout(new GridLayout(2,1));
        downPane.setLayout(new GridLayout(5,1));

        upPane.setBackground(new Color(255, 254, 240));
        upPane1.setBackground(new Color(255, 254, 240));
        upPane2.setBackground(new Color(255, 254, 240));
        btnPanel.setBackground(new Color(255, 254, 240));
        downPane.setBackground(new Color(255, 254, 240));
        downPane1.setBackground(new Color(255, 254, 240));
        downPane2.setBackground(new Color(255, 254, 240));
        downPane3.setBackground(new Color(255, 254, 240));

        //위 내용 - 왼쪽
        upPane1.add(label);
        this.label.setFont(new Font("plain", Font.BOLD, 25));
        todayBtn.setPreferredSize(new Dimension(200,70));
        todayBtn.setForeground(new Color(255, 250, 0));
        todayBtn.setBackground(new Color(0, 116, 93));
        btnPanel.add(todayBtn);
        upPane1.add(btnPanel);
        upPane.add(upPane1);

        //위 내용 - 오른쪽
        this.averageName.setFont(new Font("plain", Font.BOLD, 25));
        upPane2.add(averageName);
        this.average.setFont(new Font("plain", Font.BOLD, 65));
        average.setForeground(new Color(0, 116, 66));
        upPane2.add(average);
        upPane.add(upPane2);
        add(this.upPane);

        //밑 내용
        for(int j = 0; j < 7; j++) {
            dayBtns[0][j] = new JButton("DAY" + (j+1));
            dayBtns[0][j].setPreferredSize(new Dimension(82,30));
            downPane1.add(dayBtns[0][j]);
            dayBtns[0][j].addActionListener(this);
            dayBtns[0][j].setBackground(new Color(255, 253, 167));
        }
        for(int j = 0; j < 7; j++) {
            dayBtns[1][j] = new JButton("DAY" + ((j+1) + 7));
            dayBtns[1][j].setPreferredSize(new Dimension(82,30));
            downPane2.add(dayBtns[1][j]);
            dayBtns[1][j].addActionListener(this);
            dayBtns[1][j].setBackground(new Color(255, 253, 167));
        }
        for(int j = 0; j < 7; j++) {
            dayBtns[2][j] = new JButton("DAY" + ((j+1) + 2*7));
            dayBtns[2][j].setPreferredSize(new Dimension(82,30));
            downPane3.add(dayBtns[2][j]);
            dayBtns[2][j].addActionListener(this);
            dayBtns[2][j].setBackground(new Color(255, 253, 167));
        }

        downPane.add(blank);
        downPane.add(downPane1);
        downPane.add(downPane2);
        downPane.add(downPane3);
        add(this.downPane);
        this.todayBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        if(btn.getText().equals("오늘의 기록 보기")) {
            System.out.println("오늘의 기록 보기");
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH) + 1;
            int day = now.get(Calendar.DAY_OF_MONTH);
            String date = year + "-" + month + "-" + day;
            TodayEval dayEval = data.getTodayEval(date);
            if (dayEval != null) {
                setVisible(false);
                startUp.goDailyPage(dayEval);
            }
        } else {
            String day = btn.getText();
            TodayEval dayEval = data.getTodayEval(Integer.parseInt(day.substring(3)));
            setVisible(false);
            startUp.goDailyPage(dayEval);
        }

    }

    public void setGoal(String goal) {
        this.label.setText(goal);
        data.setGoal(goal);
    }

    public void initPage() {
        average.setText(data.getAvg() + "");
        TodayEval[] evals = data.getEvals();
        for(int i=0; i < evals.length; i++) {
            if (evals[i].isValid()) {
                int j = i / 7;
                int k = i % 7;
                dayBtns[j][k].setBackground(new Color(255, 255, 0));
            }
        }
    }

}

