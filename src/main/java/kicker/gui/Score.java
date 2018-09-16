package kicker.gui;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private int count1;
    private int count2;
    private JLabel first;
    private JLabel second;
    private int x1 = 0;
    private int x2 = 945;
    private int y1 = 0;
    private int y2 = 100;

    public int getCount2() {
        return count2;
    }

    public int getCount1() {
        return count1;
    }

    public Score() {
        setLocation(x1, y1);
        setSize(x2, y2);
        setVisible(true);
        setLayout(null);
        count1 = 0;
        count2 = 0;
        first = new JLabel("0", SwingConstants.CENTER);
        first.setBounds(x2 / 2 - 150, y2 / 2 - 15, 100, 30);
        first.setBackground(Color.WHITE);
        first.setOpaque(true);
        add(first);
        second = new JLabel("0", SwingConstants.CENTER);
        second.setBounds(x2 / 2 + 43, y2 / 2 - 15, 100, 30);
        second.setBackground(Color.WHITE);
        second.setOpaque(true);
        add(second);
    }

    public void addCount1() {
        count1++;
        first.setText(String.valueOf(count1));
    }

    public void addCount2() {
        count2++;
        second.setText(String.valueOf(count2));

    }

    public void startCount() {
        count1 = 0;
        count2 = 0;
        first.setText(String.valueOf(count1));
        second.setText(String.valueOf(count2));
    }

    protected void paintComponent(Graphics g) {
        Color cb = new Color(161, 179, 247);
        g.setColor(cb);
        g.fillRect(0, 0, 945, 100);
        g.setColor(Color.RED);
        g.fillRect(x2 / 2 - 190, y2 / 2 - 15, 40, 30);
        g.setColor(Color.BLUE);
        g.fillRect(x2 / 2 + 143, y2 / 2 - 15, 40, 30);
        g.setColor(Color.BLACK);
        g.fillRect(x2 / 2 - 10, y2 / 2 - 15, 10, 10);
        g.fillRect(x2 / 2 - 10, y2 / 2 + 5, 10, 10);
    }
}