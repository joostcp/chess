package Chess;

import Chess.Controller.Game;
import Chess.Model.pieces.Piece;

import static Chess.Controller.Turn.findPieces;
import static Chess.Controller.Turn.pieceCheck;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.getBoard().printBoardOnScreen();
        pieceCheck(game, findPieces(Piece.Color.BLACK));
    }


//    public static void knightCheck(Game game) {
//        // checking for the black knights what moves are valid
//        for (Field field : findFieldForPiece(com.company.pieces.Knight.class, Piece.Color.BLACK)) {
//            System.out.println("\n----" + field.toString() );
//
//            for (int i = 0; i < 64; i++) {
//                if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))){
//                    System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//                }
//            }
//        }
//    }
//
//    public static void pawnCheck(Game game) {
//        // checking for the black pawns what moves are valid
//        for (Field field : findFieldForPiece(com.company.pieces.Pawn.class, Piece.Color.BLACK)) {
//            System.out.println("\n----" + field.toString() );
//
//            for (int i = 0; i < 64; i++) {
//                if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))){
//                    System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//                }
//            }
//        }
//    }
//
//    public static void kingCheck(Game game) {
//        // checking for the black king what moves are valid
//        Field field = findFieldForPiece(com.company.pieces.King.class, Piece.Color.BLACK).get(0);
//        System.out.println("\n----" + field.toString() );
//        for (int i = 0; i < 64; i++) {
//            if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))) {
//                System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//            }
//        }
//    }
//
//    public static void bishopCheck(Game game) {
//        // checking for the black bishops what moves are valid
//        for (Field field : findFieldForPiece(com.company.pieces.Bishop.class, Piece.Color.BLACK)) {
//            System.out.println("\n----" + field.toString());
//
//            for (int i = 0; i < 64; i++) {
//                if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))) {
//                    System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//                }
//            }
//
//        }
//    }
//
//    public static void rookCheck(Game game) {
//        // checking for the black rooks what moves are valid
//        for (Field field : findFieldForPiece(com.company.pieces.Rook.class, Piece.Color.BLACK)) {
//            System.out.println("\n----" + field.toString() );
//
//            for (int i = 0; i < 64; i++) {
//                if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))){
//                    System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//                }
//            }
//        }
//
//    }
//
//    public static void queenCheck(Game game) {
//        // checking for the black queen what moves are valid
//        Field field = findFieldForPiece(com.company.pieces.Queen.class, Piece.Color.BLACK).get(0);
//        System.out.println("\n----" + field.toString() );
//        for (int i = 0; i < 64; i++) {
//            if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))) {
//                System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
//            }
//        }
//
//    }
}