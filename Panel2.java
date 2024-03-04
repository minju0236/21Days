import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel2 extends JPanel {
    private JLabel blank = new JLabel("");
    private JLabel title = new JLabel("이루고 싶은 목표를 입력하세요", JLabel.CENTER);
    private JPanel goalPane = new JPanel();
    private JTextField tField = new JTextField(30);
    private JButton startBtn = new JButton("V");
    private JLabel text = new JLabel("* 한번 적은 목표는 수정이 불가능합니다", JLabel.CENTER);

    public Panel2(ActionListener listener) {
        this.title.setFont(new Font("plain", Font.BOLD, 30));
        add(this.blank);
        add(this.title);

        tField = new JTextField("Ex. 일찍 일어나기", 30);
        goalPane.add(tField);
        startBtn.setForeground(new Color(255, 250, 0));
        startBtn.setBackground(new Color(0, 116, 66));
        goalPane.setBackground(new Color(255, 254, 240));
        goalPane.add(startBtn);
        add(this.goalPane);
        this.text.setFont(new Font("plain", Font.BOLD, 13));
        add(text);

        this.startBtn.addActionListener(listener);
    }

    public String getGoal() {
        return tField.getText();
    }
}

