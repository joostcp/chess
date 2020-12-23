package Chess.Model.pieces;

import java.util.ArrayList;

public class Bishop extends Piece {

    {
        moves = new ArrayList<>();

        for (int x = -8, y = -8; x < 8; x++, y++) {
            moves.add(new Move(x, y));
        }

        for (int x = 8, y = -8; x > -8; x--, y++) {
            moves.add(new Move(x, y));
        }

        for (int x = -8, y = 8; x < 8; x++, y--) {
            moves.add(new Move(x, y));
        }
    }


    @Override
    public void makeMove() {

    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public Bishop(Color color) {
        this.color = color;
        this.sign = 'b';
    }
}
