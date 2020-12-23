package Chess.Model;

import Chess.Model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {



    private final Piece.Color color;
    final String name;
    private List<Piece> taken;
    private List<Piece> pieces;

    public Player(Piece.Color color, String name) {
        this.color = color;
        this.name = name;
        taken = new ArrayList<>();
    }

    public Piece.Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public List<Piece> getTaken() {
        return taken;
    }

    public void addToTaken(List<Piece> taken) {
        this.taken = taken;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void printPieces() {
        System.out.println("the pieces of "+ this.name + " / " + this.color + " :");
        for (Piece piece:pieces) {
            System.out.println(piece.toString());
        }
        System.out.println("---");
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void removeFromPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
