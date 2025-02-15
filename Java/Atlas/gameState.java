package Atlas;

import java.util.Map;

public class gameState {

    // All the pieces on the board
    public char[][] board = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public Boolean[][] whitePieces = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
    };

    public Boolean[][] blackPieces = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
    };

    public Map<Boolean, Boolean[][]> bitBoards = Map.of(
            true, whitePieces,
            false, blackPieces
    );

    // Determines the turn
    public boolean isWhiteTurn = true;

    // Determines the right to castle
    // In order of White Kingside, White Queenside, Black Kingside, Black Queenside
    public boolean[] castlingRights = {false, false, false, false};

    // Determines the position of the enPassant square
    public byte enPassantX = -1;
    public byte enPassantY = -1;

    // 50-move rule
    public byte halfMoveClock = 0;

    // Moves that Black has made; also a counter for how long a game has last
    public short fullMoveCount = 1;

    // Resets game state
    public static void resetGameState(gameState state) {
        state.board = new char[][] {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        state.isWhiteTurn = false;

        state.castlingRights = new boolean[] {
                false, false, false, false
        };

        state.enPassantX = -1;
        state.enPassantY = -1;

        state.halfMoveClock = 0;
        state.fullMoveCount = 1;
    }

    public static gameState currentGameState = new gameState();
}
