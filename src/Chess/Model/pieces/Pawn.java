package Chess.Model.pieces;


import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    private int move;
    List<Move> strikeMoves;
    List<Move> firstMoves;

    {
        this.moves = new ArrayList<>();
        moves.add(new Move(1, 0));

        this.firstMoves = new ArrayList<>();
        firstMoves.add(new Move(2, 0));

        this.strikeMoves = new ArrayList<>();
        strikeMoves.add(new Move(1, 1));
        strikeMoves.add(new Move(1, -1));
    }

    @Override
    public void makeMove() {
    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public Pawn(Color color) {
        this.move = 0;
        this.color = color;
        this.sign = 'p';
    }

    public int getNumberOfMoves() {
        return move;
    }

    public List<Move> getFirstMoves() {
        return firstMoves;
    }

    public List<Move> getStrikeMoves() {
        return strikeMoves;
    }


}
