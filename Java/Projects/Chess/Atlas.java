package Projects.Chess;

import java.util.HashMap;

public class Atlas {
    private static HashMap<String, String> perftTree = new HashMap<>();

    public static int PerftCalculation (
            char[][] board, boolean isWhiteTurn, String enPassantSquare,
            boolean whiteCanKingSideCastle, boolean whiteCanQueenSideCastle,
            boolean blackCanKingSideCastle, boolean blackCanQueenSideCastle,
            int depth) {
        perftTree = new HashMap<>();

        for (int i = 1; i <= depth; i++) {

        }


        return perftTree.size();
    }
}
