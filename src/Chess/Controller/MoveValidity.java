package Chess.Controller;

import Chess.Model.Field;
import Chess.Model.pieces.*;

import java.util.ArrayList;
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
        // geeft true als er een stuk van de eigen kleur op het targetfield staat
    }


    public static boolean checkValidityOfMove(Field pf, Field tf) {
        validityInit(pf, tf);
        if (generalCheck())
            return false; // als het doelveld bezet wordt door een stuk van de eigen kleur -> geen valid move
        else {
            if (piece.getClass().equals(Pawn.class)) return isMoveValidPawn();
            else return isMoveValidInverted(piece.getMoves());
        }
    }

    public static boolean isMoveValidPawn() {
        Pawn pawn = (Pawn) piece;
        return (isMoveValid(pawn.getMoves()) && !isTargetFieldOccupied()) ||
                (isMoveValid(pawn.getFirstMoves()) && piece.getNumberOfMoves() == 0) && !isTargetFieldOccupied() ||
                (isMoveValid(pawn.getStrikeMoves()) && isTargetFieldOccupied());
    }

    private static boolean isTargetFieldOccupied() {
        return targetField.getPieceOnField().isPresent();
    }

    // TODO een compareTo -method schrijven om Moves te vergelijken
    private static boolean isMoveValid(List<Move> moveList) {
        for (Move move : moveList) {
//            if (wantedMove.equals(move)) {
//                System.out.println("valid target field");
//                return true;
//            }
//        }
            if ((move.getAddToX() == wantedMove.getAddToX()) && (move.getAddToY() == wantedMove.getAddToY())) {
                // System.out.println("targetfield "+ targetField.getPositionOnBoard().toString() +"  is in move-lijst van het stuk");
                if (isRouteToValidFieldFree()) {
                    //System.out.println("vrije route-check --->");
                    return true;
                }
            }
        }
        return false;
    }

    // TODO een compareTo -method schrijven om Moves te vergelijken
    private static boolean isMoveValidInverted(List<Move> moveList) {
        if (isRouteToValidFieldFree()) {


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
        }
        return false;
    }

    //  TODO checken of er niks in de weg staat op een route naar een valide targetfield
    private static boolean isRouteToValidFieldFree() {
        if (piece.getClass().equals(Knight.class) || piece.getClass().equals(King.class) || piece.getClass().equals(Pawn.class)) {
            System.out.println("pion/heer/paard");
            return true;
        }
        // want als het stuk een pion, een heer of een paard is, hoeft de weg niet vrij te zijn

        boolean diagonaal = false;
//        if (piece.getClass().equals(Rook.class)) return clearWayHorizontal();
//        if (piece.getClass().equals(Bishop.class)) return clearWayVertical();
        if (pieceField.getPositionOnBoard().x == targetField.getPositionOnBoard().x) return isRouteFreeHorizontal();
        //System.out.println("horizontale route: " + pieceField.getPositionOnBoard().toString() + "---> " + targetField.getPositionOnBoard().toString());
        //return clearWayHorizontal();
        if (pieceField.getPositionOnBoard().y == targetField.getPositionOnBoard().y) return isRouteFreeVertical();

        //    System.out.println("vertikale route" + pieceField.getPositionOnBoard().toString() + "---> " + targetField.getPositionOnBoard().toString());
        //return clearWayVertical();

        if (pieceField.getPositionOnBoard().y != targetField.getPositionOnBoard().y &&
                pieceField.getPositionOnBoard().x != targetField.getPositionOnBoard().x) diagonaal = true;
        return true;
    }


    private static Boolean isRouteFreeHorizontal() {

        List<Field> routeFields = new ArrayList<>();
        if (targetField.getPositionOnBoard().y > pieceField.getPositionOnBoard().y) {

            for (int y = pieceField.getPositionOnBoard().y + 1; y < targetField.getPositionOnBoard().y; y++) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == pieceField.getPositionOnBoard().x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }

        } else if (targetField.getPositionOnBoard().y < pieceField.getPositionOnBoard().y) {

            for (int y = pieceField.getPositionOnBoard().y - 1; y > targetField.getPositionOnBoard().y; y--) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == pieceField.getPositionOnBoard().x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }
        }
        return isRouteFree(routeFields);
    }

    private static Boolean isRouteFreeVertical() {

        List<Field> routeFields = new ArrayList<>();
        if (targetField.getPositionOnBoard().x > pieceField.getPositionOnBoard().x) {

            for (int x = pieceField.getPositionOnBoard().x + 1; x < targetField.getPositionOnBoard().x; x++) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == pieceField.getPositionOnBoard().y) {
                        routeFields.add(field);
                    }
                }
            }

        } else if (targetField.getPositionOnBoard().x < pieceField.getPositionOnBoard().x) {

            for (int x = pieceField.getPositionOnBoard().x - 1; x > targetField.getPositionOnBoard().x; x--) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == pieceField.getPositionOnBoard().y) {
                        routeFields.add(field);
                    }
                }
            }
        }
        return isRouteFree(routeFields);
    }

    private static Boolean isRouteFreeDiagonal() {

        List<Field> routeFields = new ArrayList<>();

        if (targetField.getPositionOnBoard().x < pieceField.getPositionOnBoard().x &&
                targetField.getPositionOnBoard().y < pieceField.getPositionOnBoard().y) {
            for (int x = pieceField.getPositionOnBoard().x - 1, y = pieceField.getPositionOnBoard().y - 1; x > targetField.getPositionOnBoard().x; x--, y--) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }
        }

        if (targetField.getPositionOnBoard().x < pieceField.getPositionOnBoard().x &&
                targetField.getPositionOnBoard().y > pieceField.getPositionOnBoard().y) {
            for (int x = pieceField.getPositionOnBoard().x - 1, y = pieceField.getPositionOnBoard().y + 1; x > targetField.getPositionOnBoard().x; x--, y++) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }
        }

        if (targetField.getPositionOnBoard().x > pieceField.getPositionOnBoard().x &&
                targetField.getPositionOnBoard().y < pieceField.getPositionOnBoard().y) {
            for (int x = pieceField.getPositionOnBoard().x + 1, y = pieceField.getPositionOnBoard().y - 1; x < targetField.getPositionOnBoard().x; x++, y--) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }
        }

        if (targetField.getPositionOnBoard().x > pieceField.getPositionOnBoard().x &&
                targetField.getPositionOnBoard().y > pieceField.getPositionOnBoard().y) {
            for (int x = pieceField.getPositionOnBoard().x + 1, y = pieceField.getPositionOnBoard().y + 1; x < targetField.getPositionOnBoard().x; x++, y++) {
                for (Field field : Game.board.getBoardAsListOfFields()) {
                    if (field.getPositionOnBoard().x == x && field.getPositionOnBoard().y == y) {
                        routeFields.add(field);
                    }
                }
            }
        }

        return isRouteFree(routeFields);
    }

    private static Boolean isRouteFree(List<Field> routeFields) {

        for (Field field : routeFields) {
            if (field.getPieceOnField().isPresent()) {
                return false;
            }
        }
        return true;
    }


}