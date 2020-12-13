package com.company.components;

import com.company.pieces.Piece;

import java.awt.*;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class Field {

    Optional<Piece> pieceOnField;
    Piece.Color fieldColor;
    Point positionOnBoard;
    char whiteField = '-';
    char blackField = '+';

    public Field(Piece.Color fieldColor) {
        this.pieceOnField = Optional.empty();
        this.fieldColor = fieldColor;
    }

    public void setPositionOnBoard(Point positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    @Override
    public String toString() {
        return "Field{" +
                "pieceOnField=" + pieceOnField.toString() +
                ", fieldColor=" + fieldColor +
                ", positionOnBoard=" + positionOnBoard.toString() +
                '}';
    }

    public Point getPositionOnBoard() {
        return positionOnBoard;
    }

    public Optional<Piece> getPieceOnField() {
        return pieceOnField;
    }

    public char getWhiteField() {
        return whiteField;
    }

    public char getBlackField() {
        return blackField;
    }
}
