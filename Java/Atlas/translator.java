package Atlas;

public class translator {

    private static final char[] VALID_PIECES = {'r', 'n', 'b', 'q', 'k', 'p'
                                        ,'R', 'N', 'B', 'Q', 'K', 'P'};


    // The FEN string to initialise a chess game
    public static String startString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    // Automatically sets the output to be equal to the start string if the
    public static void translation() {
        translation(startString, gameState.currentGameState);
    }

    // Translates the FEN input into the gameState Object
    public static void translation(String fen, gameState state) {

        // Resets the game state
        gameState.resetGameState(state);

        // Splits the FEN string into sections by information stored
        String[] fenSections = fen.split(" ");

        // Determine location of the board
        byte x = 0;
        byte y = 0;

        // Translates the board & pieces
        for (int i = 0; i < fenSections[0].length(); i++) {
            // Current character being translated
            char character = fenSections[0].charAt(i);

            // Translates the characters of the board state of the FEN string

            // Adds pieces to the board, and increments the pointer
            if (standardAlgorithms.contains(VALID_PIECES, character)) {
                state.board[y][x] = character;
                state.bitBoards.get(true)[y][x] = Character.isUpperCase(character);
                state.bitBoards.get(false)[y][x] = Character.isLowerCase(character);
                x++;
            }

            // Increments the pointer given a numerical value
            else if (Character.isDigit(character)) {
                x += (Character.getNumericValue(character));
            }

            // Changes the row of the pointer given a
            else if (character == '/') {
                y++;
                x = 0;
            }
        }

        // Translates the turn character
        state.isWhiteTurn = fenSections[1].equals("w");

        // Translates the castling rights
        if (fenSections[2].charAt(0) != '-') {
            for (int i = 0; i < fenSections[2].length(); i++) {
                // Current character being translated
                char character = fenSections[2].charAt(i);

                // Finds the individual castling rights
                if (character == 'K') {
                    state.castlingRights[0] = true;
                } else if (character == 'Q') {
                    state.castlingRights[1] = true;
                } else if (character == 'k') {
                    state.castlingRights[2] = true;
                } else if (character == 'q') {
                    state.castlingRights[3] = true;
                }
            }
        }

        // Translates the en passant square
        // I understand the following code looks very ugly, but it is the best way (in my opinion) to cast the
        // location of the en passant square
        if (fenSections[3].charAt(0) != '-') {

            // Uses the pre-defined Map to translate the letters to an X value the computer can handle
            state.enPassantX = dictionaries.letterToNumber.get(fenSections[3].charAt(0));

            // Uses a cast and a subtraction to translate from a board number to a computer Y value
            state.enPassantY = (byte) (8 - Character.getNumericValue(fenSections[3].charAt(1)));
        } else {

            // Sets the en passant squares to the null values of -1 if there is no en passant square
            state.enPassantX = -1;
            state.enPassantY = -1;
        }

        // Translates the halfmove clock
        state.halfMoveClock = Byte.parseByte(fenSections[4]);

        // Translates the fullmove counter
        state.fullMoveCount = Byte.parseByte(fenSections[5]);
    }

}
