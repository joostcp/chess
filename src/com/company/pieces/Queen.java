package com.company.pieces;

import com.company.components.Field;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece {

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
