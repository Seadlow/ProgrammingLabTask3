package Logic;


import java.awt.*;
import java.util.*;
import java.util.List;

public class Player {
    private Color color;
    private List<Line> lines;
    private int direct = 0;
    private int top = 61;
    private int bottom = 462;

    public Player(Color color, int[] xOfLines, int[] numberOfFigures) {
        this.color = color;
        lines = new ArrayList<>();
        for (int i = 0; i < xOfLines.length; i++) {
            lines.add(new Line(numberOfFigures[i], xOfLines[i]));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public Color getColor() {
        return color;
    }

    public void setDirection(int d) {
        direct = d;
    }

    public void move() {
        top += direct;
        bottom += direct;
        int d = 0;
        if (top < -50) {
            d = -50 - top;
            top = -50;
            bottom = 351;
        }
        if (bottom > 556) {
            d = -(bottom - 556);
            bottom = 556;
            top = 155;
        }
        for (Line line : lines) {
            line.move(direct + d);
        }
    }

    public int getDirect() {
        return direct;
    }
}