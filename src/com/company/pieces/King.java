package com.company.pieces;

import com.company.components.Field;
import com.company.components.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
