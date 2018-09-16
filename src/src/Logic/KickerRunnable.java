package Logic;

import GUI.Pitch;
import GUI.Score;

import javax.swing.*;

public class KickerRunnable implements Runnable {
    private Player player1;
    private Player player2;
    private Pitch pitch;
    private Ball ball;
    private Score score;

    public KickerRunnable(Player player1, Player player2, Pitch pitch, Ball ball, Score score) {
        this.pitch = pitch;
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        this.score = score;
    }

    @Override
    public void run() {
        while (true) {
            player1.move();
            player2.move();
            ball.move();
            if (ball.isGoal1()) {
                score.addCount2();
                ball.centringBall();
            }
            if (ball.isGoal2()) {
                score.addCount1();
                ball.centringBall();
            }
            pitch.repaint();
            if (score.getCount1() == 5 || score.getCount2() == 5) {
                String winPlayer = score.getCount1() == 5 ? "1" : "2";
                JOptionPane.showMessageDialog(null, "Player " + winPlayer  +" won",
                        "Victory", JOptionPane.INFORMATION_MESSAGE);
                score.startCount();
                ball.centringBall();
                for (Line line1 : player1.getLines()) {
                    line1.startPositions();
                }
                for (Line line2 : player2.getLines()) {
                    line2.startPositions();
                }
            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}