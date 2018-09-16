package kicker.gui;

import kicker.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pitch extends JPanel {
    private Player player1;
    private Player player2;
    private Ball ball;
    static final int x1 = 10;
    static final int x2 = 928;
    static final int y1 = 10;
    static final int y2 = 506;
    static final int r = 120;

    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getY1() {
        return y1;
    }

    public static int getY2() {
        return y2;
    }

    public Pitch(final Player player1, final Player player2, final Ball ball) {
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        JButton action = new JButton();
        action.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    player1.setDirection(-3);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    player1.setDirection(+3);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player2.setDirection(-3);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player2.setDirection(+3);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    player1.setDirection(-3);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    player1.setDirection(+3);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player2.setDirection(-3);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player2.setDirection(+3);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    player1.setDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    player1.setDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player2.setDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player2.setDirection(0);
                }
            }
        });
        add(action);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x1, y1, x1, y2);
        g.drawLine(x1, y2, x2, y2);
        g.drawLine(x2, y1, x2, y2);
        g.drawLine((x2+x1)/2, y1, (x2+x1)/2, y2);
        g.drawOval((x2 + x1) / 2 - r / 2, (y2 + y1) / 2 - r / 2, r, r);
        g.drawRect(x1, (y1 + y2) / 2 - 150, 150, 300);
        g.drawRect(x2 - 150, (y1 + y2) / 2 - 150, 150, 300);
        g.drawArc(x1 + 150 -r/2, (y1 + y2)/2 - r/ 2, r, r, -90, 180);
        g.drawArc(x2-150-r/2, (y1+y2)/2-r/2, r, r, 90, 180);
        g.setColor(player1.getColor());
        for (Line line : player1.getLines()) {
            for (Figures figure : line.getFigures()) {
                g.fillOval(figure.getX(), figure.getY(), figure.getDiam(), figure.getDiam());
            }
        }
        g.setColor(player2.getColor());
        for (Line line : player2.getLines()) {
            for (Figures figure : line.getFigures()) {
                g.fillOval(figure.getX(), figure.getY(), figure.getDiam(), figure.getDiam());
            }
        }
        g.setColor(Color.WHITE);
        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        g.setColor(Color.BLACK);
        g.drawOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        g.setColor(Color.WHITE);
        g.fillRect(0, (y1+y2)/2-50, 10, 100);
        g.fillRect(x2, (y1+y2)/2-50, 11, 100);
    }
}