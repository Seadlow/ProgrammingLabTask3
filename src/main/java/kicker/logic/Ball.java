package kicker.logic;

import kicker.gui.*;
import kicker.logic.Player;

import java.util.Random;

public class Ball {
    private int x;
    private int y;
    Random random = new Random();
    private int dx = 3 * (1 - 2 * random.nextInt(2));
    private int dy = 3 * (1 - 2 * random.nextInt(2));
    private Player player1;
    private Player player2;
    private final int diameter = 15;

    public int getDiameter() {
        return diameter;
    }

    public Ball(Player player1, Player player2) {
        this.x = (Pitch.getX2() + Pitch.getX1()) / 2;
        this.y = (Pitch.getY2() + Pitch.getY1()) / 2;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        checkingOnKick(x + dx, y + dy, player1);
        checkingOnKick(x + dx, y + dy, player2);
        x = x + dx;
        y = y + dy;
        if (x <= 10) {
            x = 10;
            dx = -dx;
        }
        if (y <= 10) {
            y = 10;
            dy = -dy;
        }
        if (x >= 913) {
            x = 913;
            dx = -dx;
        }
        if (y >= 490) {
            y = 490;
            dy = -dy;
        }
    }

    public boolean isGoal1() {
        return ((x <= 10) && ((y > 208) && (y < 308)));

    }

    public boolean isGoal2() {
        return ((x >= 913) && ((y > 208) && (y < 308)));
    }

    public void centringBall() {
        x = (Pitch.getX2() + Pitch.getX1()) / 2;
        y = (Pitch.getY2() + Pitch.getY1()) / 2;
        dx = 3 * (1 - 2 * random.nextInt(2));
        dy = 2 * (1 - 2 * random.nextInt(2));
    }

    private void checkingOnKick(int x, int y, Player player) {
        for (Line line : player.getLines()) {
            for (Figures figure : line.getFigures()) {
                int xOfCentreF = figure.getX() + figure.getDiam() / 2;
                int yOfCentreF = figure.getY() + figure.getDiam() / 2;
                int xOfCentreBall = x + diameter / 2;
                int yOfCentreBall = y + diameter / 2;
                double distance = Math.sqrt((xOfCentreBall - xOfCentreF) * (xOfCentreBall - xOfCentreF) + (yOfCentreBall - yOfCentreF) *
                        (yOfCentreBall - yOfCentreF));
                if (distance <= figure.getDiam() / 2 + diameter / 2) {
                    int dyOfF = player.getDirect();
                    dx = -dx;
                    dy = 0;
                    if (dyOfF == -3) dy = -2;
                    if (dyOfF == 3) dy = 2;
                    this.x += dx;
                    this.y += dy;
                }
            }
        }
    }
}