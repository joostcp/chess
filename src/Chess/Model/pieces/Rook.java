package Chess.Model.pieces;

import java.util.ArrayList;

public class Rook extends Piece {

    {
        this.moves = new ArrayList<>();

        for (int x = -8; x < 8; x++) {
            moves.add(new Move(x, 0));
        }

        for (int y = -8; y < 8; y++) {
            moves.add(new Move(0, y));
        }
    }


    @Override
    public void makeMove() {

    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public Rook(Color color) {
        this.color=color;
        this.sign='r';
    }


}
