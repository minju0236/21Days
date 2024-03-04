import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StratUp extends JFrame implements ActionListener {
    private Panel1 panel1;
    private Panel2 panel2;
    private Main main;
    private DailyPage dailyPage;


    public StratUp() {
        setTitle("21일의 법칙");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Container c = getContentPane();
//        c.setLayout(new GridLayout(5,1));

        panel1 = new Panel1(this);
        panel2 = new Panel2(this);
        main = new Main(this);
        dailyPage = new DailyPage(this);

        panel1.setLayout(new GridLayout(5,1));
        setContentPane(panel1);
        panel2.setLayout(new GridLayout(5,1));
        main.setLayout(new GridLayout(2,1));
        dailyPage.setLayout(new GridLayout(6,1));

        panel1.setBackground(new Color(255, 254, 240));
        panel2.setBackground(new Color(255, 254, 240));
        main.setBackground(new Color(255, 254, 240));
        dailyPage.setBackground(new Color(255, 254, 240));


        setSize(650,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        if(btn.getText().equals("시작")) {
            panel1.setVisible(false);
            setContentPane(panel2);
            panel2.setVisible(true);
        } else if(btn.getText().equals("V")) {
            String goal = panel2.getGoal();
            main.setGoal(goal);
            panel2.setVisible(false);
            goMainPage();
        } else if(btn.getText().equals("<-")) {
            dailyPage.clear();
            dailyPage.setVisible(false);
            goMainPage();
        }
    }

    public void goMainPage() {
        setContentPane(main);
        main.initPage();
        main.setVisible(true);
    }

    public void goDailyPage(TodayEval todayEval) {
        main.setVisible(false);
        setContentPane(dailyPage);
        dailyPage.initPage(todayEval);
        dailyPage.setVisible(true);
    }

    public static void main(String[] args) {
        new StratUp();
    }
}

