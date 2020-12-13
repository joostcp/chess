package com.company.components;

import com.company.pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {


    private Field[][] board;
    private List<Field> boardAsListOfFields;
    private List<Piece> blackPieces;
    private List<Piece> whitePieces;

    public Board() {
        this.boardAsListOfFields =new ArrayList<>();
        this.board=createBoard();
        setTheBoard();
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void removeFromBlackPieces(Piece toRemoveFromBlackPieces) {
       // remove
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public void removeFromWhitePieces(Piece toRemoveFromWhitePieces) {
      // remove
    }

    public void printBoard() {
        for (Field[] rij : board) {
            for (Field field :rij) {
                System.out.println(field.toString());
            }
        }
    }

    private Field[][] createBoard(){
        Field[][] board = new Field[8][8];
        Piece.Color color = Piece.Color.BLACK;
        RIJ:
        for (int i=0;i<8;i++) {
            KOLOM:
            for (int j=0 ;j<8;j++) {
                Field field = new Field(color);
                board[i][j]= field;
                field.setPositionOnBoard(new Point(i,j));
                boardAsListOfFields.add(field);
                color=switchColor(color);
            }
            color=switchColor(color);
        }
        return board;
    }

    private Piece.Color switchColor(Piece.Color color) {
        if (color.equals(Piece.Color.BLACK)) return Piece.Color.WHITE;
        else return Piece.Color.BLACK;
    }

    private void setTheBoard() {
        whitePieces = new ArrayList<>();
        setWhitePieces();
        blackPieces = new ArrayList<>();
        setBlackPieces();
    }

    private void setBlackPieces() {
        Piece.Color color = Piece.Color.BLACK;
        PAWNS:
        for (int i=0;i<8;i++) {
            Piece piece = new Pawn(color);
                board[1][i].pieceOnField= Optional.of(piece);
                piece.setField(board[1][i]);
                blackPieces.add(piece);
        }

        ROOKS: //toren
        for (int i=0;i<8;i+=7) {
            Piece piece = new Rook(color);
            board[0][i].pieceOnField = Optional.of(piece);
            piece.setField(board[0][i]);
            blackPieces.add(piece);
        }

        BISHOPS: //loper
        for (int i=2;i<8;i+=3) {
            Piece piece = new Bishop(color);
            board[0][i].pieceOnField = Optional.of(piece);
            piece.setField(board[0][i]);
            blackPieces.add(piece);
        }

        KNIGHTS: //paard
        for (int i=1;i<8;i+=5) {
            Piece piece = new Knight(color);
            board[0][i].pieceOnField = Optional.of(piece);
            piece.setField(board[0][i]);
            blackPieces.add(piece);
        }

        KING:
        {
            Piece piece = new King(color);
            board[0][4].pieceOnField = Optional.of(piece);
            piece.setField(board[0][4]);
            blackPieces.add(piece);
        }

        QUEEN:
        {
            Piece piece = new Queen(color);
            board[0][3].pieceOnField = Optional.of(piece);
            piece.setField(board[0][3]);
            blackPieces.add(piece);
        }

    }


    private void setWhitePieces() {
        Piece.Color color = Piece.Color.WHITE;
        PAWNS:
        for (int i=0;i<8;i++) {
            Piece piece = new Pawn(color);
            board[6][i].pieceOnField= Optional.of(piece);
            piece.setField(board[6][i]);
            whitePieces.add(piece);
        }

        ROOKS: //toren
        for (int i=0;i<8;i+=7) {
            Piece piece = new Rook(color);
            board[7][i].pieceOnField = Optional.of(piece);
            piece.setField(board[7][i]);
            whitePieces.add(piece);
        }

        BISHOPS: //loper
        for (int i=2;i<8;i+=3) {
            Piece piece = new Bishop(color);
            board[7][i].pieceOnField = Optional.of(piece);
            piece.setField(board[7][i]);
            whitePieces.add(piece);
        }

        KNIGHTS: //paard
        for (int i=1;i<8;i+=5) {
            Piece piece = new Knight(color);
            board[7][i].pieceOnField = Optional.of(piece);
            piece.setField(board[7][0]);
            whitePieces.add(piece);
        }

        KING:
        {
            Piece piece = new King(color);
            board[7][3].pieceOnField = Optional.of(piece);
            piece.setField(board[7][3]);
            whitePieces.add(piece);
        }

        QUEEN:
        {
            Piece piece = new Queen(color);
            board[7][4].pieceOnField = Optional.of(piece);
            piece.setField(board[7][4]);
            whitePieces.add(piece);
        }

    }

    public List<Field> getBoardAsListOfFields() {
        return boardAsListOfFields;
    }

    public void printBoardOnScreen() {

        int counterRows = 0;

        System.out.println("       0  1  2  3  4  5  6  7" + "\n");
        for (Field[] row: board) {
            System.out.print(counterRows+ "    ");
            for (Field field: row) {
                if (field.pieceOnField.isPresent()){

                    System.out.print("  " + field.pieceOnField.get().getSign());
                }
                else if (field.fieldColor.equals(Piece.Color.BLACK)) {
                    System.out.print("  " + field.getBlackField());
                }
                else System.out.print("  " + field.getWhiteField());
            }
            System.out.print("\n" );
            counterRows++;
        }
        System.out.println(" ");
    }
}
