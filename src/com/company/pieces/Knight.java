package com.company.pieces;

import com.company.components.Field;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece {

    {
        this.moves=new ArrayList<>();
        // x+2, y+1
        // x+2, y-1

        // x-2, y+1
        // x-2, y-1

        // x+1, y
        // x-1, y-2

        // x+1, y+2
        // x-1, y+2

        for (int x=-2; x<3; x+=4) {
            for (int y=-1;y<2;y+=2) {
                moves.add(new Move(x, y));
            }
        }

        for (int y=-2; y<3; y+=4) {
            for (int x=-1;x<2;x+=2) {
                moves.add(new Move(x, y));
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

    public Knight(Color color) {
        this.color = color;
        this.sign = 'k';
    }
}
