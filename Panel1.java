import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel1 extends JPanel {
    private JLabel blank = new JLabel("");
    private JLabel title = new JLabel("21일의 법칙", JLabel.CENTER);
    private JLabel contents;
    private JPanel btnPane = new JPanel();
    private JButton startBtn = new JButton("시작");

    public Panel1(ActionListener listener) {
        this.title.setFont(new Font("plain", Font.BOLD, 40));
        add(this.blank);
        add(this.title);

        this.contents = new JLabel("<html><center>\"무엇이든 21일간 계속하면 습관이 된다."
                + "<br>21일은 우리의 뇌가 새로운 행동에 익숙해지는 데 걸리는 최소한의 시간이다.\"</center></html>", JLabel.CENTER);
        this.contents.setFont(new Font("plain", Font.BOLD, 13));
        add(this.contents);

        startBtn.setPreferredSize(new Dimension(82,35));
        startBtn.setForeground(new Color(255, 250, 0));
        startBtn.setBackground(new Color(0, 116, 66));
        btnPane.setBackground(new Color(255, 254, 240));
        btnPane.add(startBtn);
        add(this.btnPane);

        this.startBtn.addActionListener(listener);

    }
}

