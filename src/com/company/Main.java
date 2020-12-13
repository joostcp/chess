package com.company;

import com.company.components.Field;
import com.company.components.Game;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        //game.getBoard().printBoard();
        game.getBoard().printBoardOnScreen();


//        System.out.println(game.getBoard().getBlackPieces().get(14).getField().getPositionOnBoard().toString());
//        System.out.println(game.getBoard().getBlackPieces().get(14).toString());
//
//        System.out.println(game.getBoard().getBlackPieces().get(1).getField().getPositionOnBoard().toString());
//        System.out.println(game.getBoard().getBlackPieces().get(1));

        System.out.println(game.getBoard().getBlackPieces().get(12).getField().getPositionOnBoard().toString());
        System.out.println(game.getBoard().getBlackPieces().get(12).toString());

//        game.validMove(game.getBoard().getBlackPieces().get(14), game.getBoard().getBoardAsListOfFields().get(52));
//
//    game.validMove(game.getBoard().getBlackPieces().get(12), game.getBoard().getBoardAsListOfFields().get(16));

        for (int i=0;i<64;i++) {
            System.out.print(i + ": ");
            game.validMove(game.getBoard().getBlackPieces().get(12), game.getBoard().getBoardAsListOfFields().get(i));
        }
    }
}