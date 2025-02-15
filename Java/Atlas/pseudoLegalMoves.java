package Atlas;

import java.util.ArrayList;

public class pseudoLegalMoves {
    public static ArrayList<String> pawnMovement() {
        // Fluid size linear data structure to store movements of pawns
        ArrayList<String> moves = new ArrayList<>();

        // Loops through the entire array
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (// Checks if the piece is a pawn and
                    Character.toLowerCase(gameState.board[y][x]) == 'p' &&
                    // Checks if the piece matches the player moving
                    Character.isUpperCase(gameState.board[y][x]) == gameState.isWhiteTurn) {

                    if (gameState.board
                            [y + dictionaries.pawnDirection.get(gameState.isWhiteTurn) ]
                            [x]
                        == ' ') {

                    }


                }
            }
        }

        return moves;
    }
}
