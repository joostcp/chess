package Chess.Model.pieces;

import Chess.Model.Field;

import java.util.List;

public abstract class Piece {

    public enum Color {
        WHITE,
        BLACK
    }

    int numberOfMoves;
    char sign;
    Color color = null;
    List<Move> moves = null;

    Field field = null;

    public abstract void makeMove();

    public abstract Color checkColor();

    @Override
    public String toString() {
        return this.getClass() +
                " color= " + color;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public char getSign() {
        return sign;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
}
