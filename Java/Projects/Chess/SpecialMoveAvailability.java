package Projects.Chess;

public class SpecialMoveAvailability {
    public static boolean[] CastlingChecker (char[][] board,
         boolean whiteCanKingSideCastle, boolean whiteCanQueenSideCastle,
         boolean blackCanKingSideCastle, boolean blackCanQueenSideCastle) {
        return new boolean[]{
                board[7][7] == 'R' && board[7][4] == 'K' && whiteCanKingSideCastle,
                board[7][0] == 'R' && board[7][4] == 'K' && whiteCanQueenSideCastle,
                board[0][7] == 'r' && board[0][4] == 'k' && blackCanKingSideCastle,
                board[0][0] == 'r' && board[0][4] == 'k' && blackCanQueenSideCastle
        };
    }

    public static String EnPassantChecker (char pieceMoved, int originY, int destinationY,
           int originX) {

        if (Character.toLowerCase(pieceMoved) == 'p' && (
                (destinationY == 4 && originY == 6) ||
                (destinationY == 3 && originY == 1)
                )
        ) {

            if (originY == 6) {
                return new String(new char[] {(char) (97 + originX), '3'});
            } else {
                return new String(new char[] {(char) (97 + originX), '6'});
            }

        }

        return "";
    }
}
