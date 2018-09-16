package Logic;


import java.util.ArrayList;
import java.util.List;

public class Line {
    private int numberOfFigures;
    private int length = 490;
    private List<Figures> figures;

    public Line(int numberOfFigures, int x) {
        this.numberOfFigures = numberOfFigures;
        figures = new ArrayList<>();
        int yOfFigure = length / numberOfFigures;
        for (int i = 0; i < numberOfFigures; i++) {
            figures.add(i, new Figures(x, (yOfFigure * i + (yOfFigure + 1) / 2)));
        }
    }

    public void startPositions() {
        int yOfFigure = length / numberOfFigures;
        for (int i = 0; i < numberOfFigures; i++) {
            figures.get(i).setY(yOfFigure * i + (yOfFigure + 1) / 2);
        }

    }

    public List<Figures> getFigures() {
        return figures;
    }

    public void move(int direct) {
        for (Figures figure : getFigures()) {
            figure.move(direct);
        }
    }
}