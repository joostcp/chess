package com.company.pieces;


import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    private int move;
    List<Move> firstMoves;
    List<Move> strikeMoves;

    {   this.moves=new ArrayList<>();
        moves.add(new Move(1,0));

        this.firstMoves=new ArrayList<>();
        moves.add(new Move(2,0));

        this.strikeMoves=new ArrayList<>();
        moves.add(new Move(1,1));
        moves.add(new Move(1,-1)); }

    @Override
    public void makeMove() {
    }

    @Override
    public Color checkColor() {
        return this.color;
    }

    public Pawn(Color color) {
        this.move=0;
        this.color=color;
        this.sign = 'p';
    }

    public int getMove() {
        return move;
    }
}
