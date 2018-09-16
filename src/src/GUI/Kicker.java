package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;


public class Kicker extends JFrame {
    private Pitch pitch;
    private Score score;

    public Kicker() {
        super("Настольный футбол");
        setSize(945, 650);
        int[] numberOfFigures1 = {1, 4, 4, 2};
        int[] xOfLines1 = {20, 245, 520, 770};
        int[] numberOfFigures2 = {2, 4, 4, 1};
        int[] xOfLines2 = {125, 380, 655, 880};
        final Player player1 = new Player(Color.RED, xOfLines1, numberOfFigures1);
        final Player player2 = new Player(Color.BLUE, xOfLines2, numberOfFigures2);
        final Ball ball = new Ball(player1, player2);
        score = new Score();
        pitch = new Pitch(player1, player2, ball);
        pitch.setSize(945, 550);
        pitch.setLocation(0, 100);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pitch.setLayout(null);
        Color color = new Color(51, 102, 0);
        pitch.setBackground(color);
        Runnable runnable = new KickerRunnable(player1, player2, pitch, ball, score);
        Thread thread = new Thread(runnable);
        thread.start();
        pitch.setVisible(true);
        add(pitch);
        add(score);
    }
}
