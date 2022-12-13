package Projects.Chess;

public class MoveMaker {
    public static char[][] makeMove (char[][] boardInput,
             int pieceOriginX, int pieceOriginY, int pieceDestinationX,
             int pieceDestinationY, boolean isWhiteTurn, String enPassantSquare) {

        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = boardInput[i].clone();
        }

        char pieceMoved = board[pieceOriginY][pieceOriginX];
        board[pieceDestinationY][pieceDestinationX] = pieceMoved;
        board[pieceOriginY][pieceOriginX] = '\u0000';

        if (Character.toLowerCase(pieceMoved) == 'k' &&
                pieceDestinationX - pieceOriginX == 2) {
            if (isWhiteTurn) {
                board[7][7] = '\u0000';
                board[7][5] = 'R';
            } else {
                board[0][7] = '\u0000';
                board[0][5] = 'r';
            }
        } else if (Character.toLowerCase(pieceMoved) == 'k' &&
                pieceDestinationX - pieceOriginX == -2) {
            if (isWhiteTurn) {
                board[7][0] = '\u0000';
                board[7][3] = 'R';
            } else {
                board[0][0] = '\u0000';
                board[0][3] = 'r';
            }
        }    else if (Character.toLowerCase(pieceMoved) == 'p' &&
                new String(new char[]{
                        (char) (97 + pieceDestinationX), (char) (56 - pieceDestinationY)
                }).equals(enPassantSquare)
        ) {
            board[pieceOriginY][pieceDestinationX] = '\u0000';
        }

        return board;
    }
}
