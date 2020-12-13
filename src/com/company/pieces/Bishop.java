package com.company.pieces;

import com.company.components.Field;

import java.awt.*;
import java.util.ArrayList;

public class Bishop  extends Piece {

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
