package com.company.pieces;

import com.company.components.Field;
import com.company.components.Game;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{

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
