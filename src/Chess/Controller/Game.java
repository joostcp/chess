package Chess.Controller;

import Chess.Model.Board;
import Chess.Model.Player;
import Chess.Model.pieces.Piece;

import java.time.LocalTime;

public class Game {

    private final Player[] players = new Player[2];
    private final boolean finished;
    private final LocalTime startTime;
    public static Board board;
    private Player whosTurn;

    public boolean check;
    public boolean checkMate;

    public static int reachableCount = 0;
    public static int validCount = 0;


    public Game() {
        this.finished = false;
        this.startTime = LocalTime.now();
        board = new Board();
        this.check = false;
        this.checkMate = false;

        Player player1 = new Player(Piece.Color.WHITE, "Eddy");
        Player player2 = new Player(Piece.Color.BLACK, "Hans");
        player1.setPieces(board.getWhitePieces());
        player2.setPieces(board.getBlackPieces());
        this.players[0] = player1;
        this.players[1] = player2;
        whosTurn = player1;
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
}
