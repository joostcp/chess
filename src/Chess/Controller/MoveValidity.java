package Chess.Controller;

import Chess.Model.Field;
import Chess.Model.pieces.*;

import java.awt.*;
import java.util.List;

public class MoveValidity {

    private static Piece piece;
    private static Move wantedMove;

    private static Field pieceField;
    private static Field targetField;

    // TODO: als de kleur BLACK is, is de primaire richting positief (1). als de kleur van hert stuk WHITE is, is die richting negatief (-1);
    private static int direction = 1;

    public static void validityInit(Field fp, Field tf) {
        pieceField = fp;
        targetField = tf;
        piece = pieceField.getPieceOnField().get();
        wantedMove = new Move((targetField.getPositionOnBoard().x - pieceField.getPositionOnBoard().x),
                (targetField.getPositionOnBoard().y - pieceField.getPositionOnBoard().y));
        if (piece.checkColor().equals(Piece.Color.BLACK)) {
            direction = 1;
        } else direction = -1;
    }

    public static boolean generalCheck() {
        return (isTargetFieldOccupied() && targetField.getPieceOnField().get().checkColor().equals(pieceField.getPieceOnField().get().checkColor()));
    }


    public static boolean checkValidityOfMove(Field pf, Field tf) {
        validityInit(pf, tf);
        // als het doelveld bezet wordt door een stuk van de eigen kleur -> geen valid move
        if (generalCheck()) return false;
        else {
            if (piece.getClass().equals(Pawn.class)) return validMovePawn();
            else return validMove();
        }
    }


    private static boolean validMove() {
        return isTargetFieldValid(piece.getMoves()) && isRouteToValidFieldFree();
    }


    public static boolean validMovePawn() {
        Pawn pawn = (Pawn) piece;
        return (isTargetFieldValid(pawn.getMoves()) && !isTargetFieldOccupied()) ||
                (isTargetFieldValid(pawn.getFirstMoves()) && piece.getNumberOfMoves() == 0) && !isTargetFieldOccupied() ||
                (isTargetFieldValid(pawn.getStrikeMoves()) && isTargetFieldOccupied());
    }

    private static boolean isTargetFieldOccupied() {
        return targetField.getPieceOnField().isPresent();
    }

//    public static boolean validMoveKingKnight() {
//        return isTargetFieldValid(piece.getMoves());
//    }

    // TODO een compareTo -method schrijven om Moves te vergelijken
    private static boolean isTargetFieldValid(List<Move> moveList) {
        for (Move move : moveList) {
//            if (wantedMove.equals(move)) {
//                System.out.println("valid target field");
//                return true;
//            }
//        }
            if ((move.getAddToX() == wantedMove.getAddToX()) && (move.getAddToY() == wantedMove.getAddToY())) {
                return true;
            }
        }
        return false;
    }

    //  TODO checken of er niks in de weg staat op een route naar een valide targetfield
    private static boolean isRouteToValidFieldFree() {
        if (piece.getClass().equals(Knight.class) || piece.getClass().equals(King.class)) return true;
        // want als het stuk een heer of een paard is, hoeft de weg niet vrij te zijn

        boolean diagonaal = false;
//        if (piece.getClass().equals(Rook.class)) return clearWayHorizontal();
//        if (piece.getClass().equals(Bishop.class)) return clearWayVertical();
        if (pieceField.getPositionOnBoard().x == targetField.getPositionOnBoard().x) return clearWayHorizontal();
        if (pieceField.getPositionOnBoard().y == targetField.getPositionOnBoard().y) return clearWayVertical();
        //if (pieceField.positionOnBoard.y != targetField.positionOnBoard.y &&
        //        pieceField.positionOnBoard.x != targetField.positionOnBoard.x) diagonaal = true;
        return true;
    }

    private static boolean clearWayHorizontal() {

        for (int y = 0; y < (targetField.getPositionOnBoard().y - pieceField.getPositionOnBoard().y); y++) {
            for (Field field : Game.board.getBoardAsListOfFields()) {
                if (field.getPositionOnBoard().equals(new Point(pieceField.getPositionOnBoard().x, y))) {
                    if (field.getPieceOnField().isPresent()) return false;
                }
            }
        }
        return true;
    }


//        for (int i = piece.positionOnBoard.y; i < target.getPositionOnBoard().y; i++) {
//            Point point = new Point(piece.getPositionOnBoard().x, i);
//            for (Field field : board.getBoardAsListOfFields()) {
//                if (field.getPositionOnBoard().getLocation().equals(point) && field.pieceOnField.isPresent())
//                    return false;
//            }
//        }
//        return true;
//    }

    private static boolean clearWayVertical() {

        for (int x = 0; x < (targetField.getPositionOnBoard().x - pieceField.getPositionOnBoard().x); x++) {
            for (Field field : Game.board.getBoardAsListOfFields()) {
                if (field.getPositionOnBoard().equals(new Point(x, pieceField.getPositionOnBoard().y))) {
                    if (field.getPieceOnField().isPresent()) return false;
                }
            }
        }
        return true;
//        for (int i = piece.positionOnBoard.x; i < target.getPositionOnBoard().x; i++) {
//            Point point = new Point(i, piece.getPositionOnBoard().y);
//            for (Field field : board.getBoardAsListOfFields()) {
//                if (field.getPositionOnBoard().getLocation().equals(point) && field.pieceOnField.isPresent())
//                    return false;
//            }
//        }
//        return true;
    }

//    private boolean clearWayDiagonal (Field target, Field piece) {
//        return false;
//    }
}