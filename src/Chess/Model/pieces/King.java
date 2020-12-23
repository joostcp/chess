package Chess.Model.pieces;

import java.util.ArrayList;

public class King extends Piece{

    {
        this.moves=new ArrayList<>();
        for (int x=-1;x<2;x++){
            for (int y=-1; y<2;y++){
                moves.add(new Move(x,y)); }
            }
    }


    @Override
    public void makeMove() {
    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public King(Color color) {
        this.color=color;
        this.sign = 'K';
    }


}
