package Chess.Model.pieces;

import java.util.ArrayList;

public class Queen extends Piece {

    {
        moves = new ArrayList<>();

        DIAGONALS:
        {
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

        HORIZONTALS:
        {
            for (int y = -8; y < 8; y++) {
                moves.add(new Move(0, y));
            }
        }

        VERTICALS:
        {
            for (int x = -8; x < 8; x++) {
                moves.add(new Move(x, 0));
            }
        }
    }


    @Override
    public void makeMove() {

    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public Queen(Color color) {
        this.color = color;
        this.sign = 'Q';
    }
}
