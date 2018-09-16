package kicker.logic;

import java.awt.*;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KickerLogicTest {
    int[] numberOfFigures1 = {1, 4, 4, 2};
    int[] xOfLines1 = {20, 245, 520, 770};
    int[] numberOfFigures2 = {2, 4, 4, 1};
    int[] xOfLines2 = {125, 380, 655, 880};
    final Player player1 = new Player(Color.RED, xOfLines1, numberOfFigures1);
    final Player player2 = new Player(Color.BLUE, xOfLines2, numberOfFigures2);
    final Ball ball = new Ball(player1, player2);
    @Test
    public void stepTest() {


    }
}
