package Chess.Controller;

import Chess.Model.Field;
import Chess.Model.pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Turn {

    public static void pieceCheck(Game game, List<Field> fieldList) {
        for (Field field : fieldList) {
            System.out.println("\n----" + field.toString());

            for (int i = 0; i < 64; i++) {
                if (MoveValidity.checkValidityOfMove(field, game.getBoard().getBoardAsListOfFields().get(i))) {
                    System.out.println(game.getBoard().getBoardAsListOfFields().get(i).getPositionOnBoard().toString() + " is valid!");
                }
            }
        }
    }

    public static List<Field> findPieces(Piece.Color color) {
        List<Field> list = new ArrayList<>();
        list.addAll(findFieldForPiece(Rook.class, color));
        list.addAll(findFieldForPiece(Queen.class, color));
        list.addAll(findFieldForPiece(King.class, color));
        list.addAll(findFieldForPiece(Knight.class, color));
        //list.addAll(findFieldForPiece(Pawn.class, color));
        list.addAll(findFieldForPiece(Bishop.class, color));
        return list;
    }

    public static List<Field> findFieldForPiece(Class piece, Piece.Color color) {
        List<Field> fieldList = new ArrayList<>();
        for (Field field : Game.board.getBoardAsListOfFields()) {
            if (field.getPieceOnField().isPresent()) {
                if (field.getPieceOnField().get().checkColor().equals(color)) {
                    if (field.getPieceOnField().get().getClass().equals(piece)) {
                        fieldList.add(field);
                    }
                }
            }
        }
        if (fieldList.isEmpty()) {
            Field tempField = new Field(Piece.Color.WHITE);
            tempField.setPositionOnBoard(new Point(-1, -1));
            fieldList.add(tempField);
        }
        return fieldList;
    }
}
