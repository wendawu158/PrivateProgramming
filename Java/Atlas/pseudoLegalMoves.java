package Atlas;

import java.util.ArrayList;

// The following methods covers the entirety of finding every pseudo-legal moves given the input
// On second thought, rather than having gameState be a static object, it might be better to have it be an instance

public class pseudoLegalMoves {

    // Finds all pseudo-legal moves#
    // A pseudo-legal where a move is possible only according to the movement rules of the piece, and does not take
    // into account checks and threats on the king
    public static ArrayList<String> findPseudoLegalMoves(gameState state) {
        // Fluid size linear data structure to store movements of pawns
        ArrayList<String> moves = new ArrayList<>();

        // Loops through the entire array
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                if (// Checks if the piece colour matches the player moving
                    state.bitBoards.get(state.isWhiteTurn)[y][x] &&
                    // Checks if the piece is empty
                    state.board[y][x] != ' ') {

                    // Pawn moves
                    if (// Checks if the piece is a pawn
                        Character.toLowerCase(state.board[y][x]) == 'p') {

                        // Calls predefined function to find all pawn moves
                        moves.addAll(pawn(y, x, state));


                    } else if (
                        // Checks if the piece is a rook
                        Character.toLowerCase(state.board[y][x]) == 'r') {

                        // Calls predefined function to find all pawn moves
                        moves.addAll(rook(y, x, state));
                    }
                }
            }
        }

        return moves;
    }

    public static ArrayList<String> pawn(int y, int x, gameState state) {
        // Stores the legal moves for the pawn
        ArrayList<String> moves = new ArrayList<>();

        // Stores the initial location of the pawn
        String originalLocation = dictionaries.numberToLetter.get((byte) x) + Integer.toString(y);

        // Stores the new location of the pawn
        String newLocation;

        // Determines the pseudo-legal moves
        if (// These conditions check the square ahead of the pawn is empty
            !state.bitBoards.get(state.isWhiteTurn)
            // Determines what constitutes as "forward" for the pawn
            [y + dictionaries.pawnDirection.get(state.isWhiteTurn)]
            [x] &&
            !state.bitBoards.get(!state.isWhiteTurn)
            [y + dictionaries.pawnDirection.get(state.isWhiteTurn)]
            [x]
            ) {

            newLocation = dictionaries.numberToLetter.get
                    ((byte) (x))
                    + Integer.toString(y + dictionaries.pawnDirection.get(state.isWhiteTurn));

            moves.add(originalLocation + newLocation);

            // Double move
            if (// These conditions check that the square two squares ahead is empty
                !state.bitBoards.get(state.isWhiteTurn)
                // Determines what constitutes as "forward" for the pawn
                [y + 2 * dictionaries.pawnDirection.get(state.isWhiteTurn)]
                [x] &&
                !state.bitBoards.get(state.isWhiteTurn)
                [y + 2 * dictionaries.pawnDirection.get(state.isWhiteTurn)]
                [x]

                // Determines if the pawn is in the correct rank
                &&
                (y == 1 && !state.isWhiteTurn) ||
                (y == 6 && state.isWhiteTurn)
            ) {

                newLocation = dictionaries.numberToLetter.get
                ((byte) (x))
                + Integer.toString(y + 2 * dictionaries.pawnDirection.get(state.isWhiteTurn));

                moves.add(originalLocation + newLocation);
            }
        }

        if (// This condition checks if the target location contains a character that does not belong to
            // the moving side. If the bitboard is true there is a character that can be captured there
            state.bitBoards.get(!state.isWhiteTurn)
            [y + dictionaries.pawnDirection.get(state.isWhiteTurn)]
            [x + 1]

            ||

            // Target location equal to en passant square location
            y == state.enPassantY && x + 1 == state.enPassantX
            ) {

            newLocation = dictionaries.numberToLetter.get
                    ((byte) (x + 1))
                    + Integer.toString(y + dictionaries.pawnDirection.get(state.isWhiteTurn));

            moves.add(originalLocation + newLocation);
        }

        if (// This condition checks if the target location contains a character that does not belong to
            // the moving side
            state.bitBoards.get(!state.isWhiteTurn)
            [y + dictionaries.pawnDirection.get(state.isWhiteTurn)]
            [x - 1]

            ||

            // Target location equal to en passant square location
            y == state.enPassantY && x - 1 == state.enPassantX
        ) {

            newLocation = dictionaries.numberToLetter.get
                    ((byte) (x - 1))
                    + Integer.toString(y + dictionaries.pawnDirection.get(state.isWhiteTurn));

            moves.add(originalLocation + newLocation);
        }

        return moves;
    }

    public static ArrayList<String> rook(int y, int x, gameState state) {
        // Stores the legal moves for the pawn
        ArrayList<String> moves = new ArrayList<>();

        // Stores the initial location of the pawn
        String originalLocation = dictionaries.numberToLetter.get((byte) y) + Integer.toString(x);

        // Stores the new location of the pawn
        String newLocation;

        // Slide to the right
        for (int i = 1; x + i <= 7; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y][x + i]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y][x + i]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x + i))
                        + Integer.toString(y);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x + i))
                        + Integer.toString(y);

                moves.add(originalLocation + newLocation);
            }
        }

        // Slide to the left
        for (int i = 1; x - i >= 0; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y][x - i]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y][x - i]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x - i))
                        + Integer.toString(y);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x - i))
                        + Integer.toString(y);

                moves.add(originalLocation + newLocation);
            }
        }

        // Reverse reverse, reverse reverse
        for (int i = 1; y + i <= 7; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y + i][x]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y + i][x]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);
            }
        }

        // Cha-cha now y'all
        for (int i = 1; y - i >= 0; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y - i][x]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y - i][x]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y - i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y - i);

                moves.add(originalLocation + newLocation);
            }
        }


        return moves;
    }

    public static ArrayList<String> bishop(int y, int x, gameState state) {
        // Stores the legal moves for the pawn
        ArrayList<String> moves = new ArrayList<>();

        // Stores the initial location of the pawn
        String originalLocation = dictionaries.numberToLetter.get((byte) y) + Integer.toString(x);

        // Stores the new location of the pawn
        String newLocation;

        // Bottom right
        for (int i = 1; x + i <= 7 && y + i <= 7; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y + i][x + i]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y + i][x + i]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x + i))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x + i))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);
            }
        }

        // Bottom left
        for (int i = 1; x - i >= 0 && y + i <= 7; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y + i][x - i]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y + i][x - i]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x - i))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x - i))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);
            }
        }

        // Bottom right
        for (int i = 1; y + i <= 7; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y + i][x]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y + i][x]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y + i);

                moves.add(originalLocation + newLocation);
            }
        }

        // Cha-cha now y'all
        for (int i = 1; y - i >= 0; i++) {
            // If the target location contains a friendly piece
            if (state.bitBoards.get(state.isWhiteTurn)[y - i][x]) {
                break;
            }
            // If the target location contains an enemy piece
            else if (state.bitBoards.get(!state.isWhiteTurn)[y - i][x]) {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y - i);

                moves.add(originalLocation + newLocation);

                break;
            }
            // If the target location is empty
            else {
                newLocation = dictionaries.numberToLetter.get
                        ((byte) (x))
                        + Integer.toString(y - i);

                moves.add(originalLocation + newLocation);
            }
        }


        return moves;
    }


    }
