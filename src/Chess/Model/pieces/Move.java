package Chess.Model.pieces;

public class Move {

    int addToX;
    int addToY;

    public Move(int addToX, int addToY) {
        this.addToX = addToX;
        this.addToY = addToY;
    }

    @Override
    public String toString() {
        return "Move{" +
                "addToX=" + addToX +
                ", addToY=" + addToY +
                '}';
    }

    public int getAddToX() {
        return addToX;
    }

    public int getAddToY() {
        return addToY;
    }
}
