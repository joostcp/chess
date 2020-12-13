package com.company.components;

import com.company.pieces.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Game {

   private Player[] players = new Player[2];
   private boolean finished;
   private LocalTime startTime;
   public static Board board;
   private Player whosTurn;


    public Game() {
        this.finished=false;
        this.startTime=LocalTime.now();
        this.board = new Board();

            Player player1 = new Player(Piece.Color.WHITE, "Eddy");
            Player player2 = new Player(Piece.Color.BLACK, "Hans");
            player1.setPieces(board.getWhitePieces());
            player2.setPieces(board.getBlackPieces());
        this.players[0]=player1;
        this.players[1]=player2;
        whosTurn=player1;
    }



    public Player[] getPlayers() {
        return players;
    }

    public boolean isFinished() {
        return finished;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Board getBoard() {
        return board;
    }

    public boolean validMove(Piece piece, Field target) {
        boolean occupiedByOtherColor = false;
        if (target.pieceOnField.isPresent() && !target.pieceOnField.get().checkColor().equals(piece.checkColor())){
            occupiedByOtherColor = true;
        }
        Field currentFieldOfPiece = piece.getField();
        Move wantedMove = new Move ((currentFieldOfPiece.positionOnBoard.x+target.getPositionOnBoard().x)
                                    ,(currentFieldOfPiece.positionOnBoard.y+target.positionOnBoard.y));

        //System.out.println("wantedMove: " + wantedMove.toString());
        //printMovesOfPiece(piece);
        boolean possibleMove = isPossibleMove(wantedMove,piece);
        //System.out.println(possibleMove);
        if (possibleMove&&!occupiedByOtherColor){
            System.out.println("a valid move! " + target.getPositionOnBoard().toString());return true;}
        else {
            System.out.println("an invalid move..."+ target.getPositionOnBoard().toString());return false;}
    }

    private void printMovesOfPiece (Piece piece) {
        for (Move move:piece.getMoves()) {
            System.out.println("-> " + move.toString());
        }
    }

    private boolean isPossibleMove(Move wantedMove, Piece piece) {
        for (Move move: piece.getMoves()) {
            if ((move.getAddToX()==wantedMove.getAddToX() )&&(move.getAddToY()==wantedMove.getAddToY()) ) return true;
        }
        return false;
    }
}
