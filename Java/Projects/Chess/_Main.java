package Projects.Chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _Main {
    public static void main(String[] args) {
        // Creates the board
        char[][] board = new char[8][8];

        // Declares a bunch of variables vital to game function

        // Used to determine who's turn it is
        boolean isWhiteTurn = true;

        // Used to determine castling privileges
        boolean[] castlingPrivileges;
        boolean whiteCanKingSideCastle = false;
        boolean whiteCanQueenSideCastle = false;
        boolean blackCanKingSideCastle = false;
        boolean blackCanQueenSideCastle = false;

        // Used to determine which, if any, square is a valid target for en passant
        String enPassantSquare = "";

        // Used to determine the 50 move rule
        short halfmoveClock = 0;

        // Used to determine the number of moves that have passed
        short fullmoveNumber = 0;

        // Used to calculate which moves are legal
        ArrayList<String> pseudoLegalMoves;
        ArrayList<String> legalMoves;

        // Used to determine which piece has moved and from where to where
        String pieceOrigin;
        String pieceDestination;
        char pieceMoved = 'r';

        // Used to determine if a check has occurred
        boolean inCheck;
        
        // Used to determine if a valid move has occurred
        boolean validMove;
        
        // Used to move the pieces
        int pieceOriginX = 0;
        int pieceOriginY = 0;
        int pieceDestinationX = 0;
        int pieceDestinationY = 0;

        // Starting FEN string
        String startingPosition = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        // Gives the player the option to enter a new position or to use the standard starting string
        System.out.println("To begin a new game, copy and paste the following string");
        System.out.println(startingPosition);
        System.out.print("Enter the FEN string for the current position: ");

        // Prepares to receive the FEN string for the current position
        Scanner input = new Scanner(System.in);

        // Receives the current FEN string and stores it
        String position = input.nextLine();

        // Prepares to translate the FEN string

        // Stores the current segment of the FEN string being processed
        byte sectionInFen = 0;

        // Stores the current location in the board
        byte boardPointer = 0;

        // Translates the FEN string
        for (char ch: position.toCharArray()) {

            // Moves to the next section of the FEN string if a whitespace is declared
            if (ch == ' ') {
                sectionInFen++;
                continue;
            }

            // Deals with the board
            if (sectionInFen == 0) {

                // Checks that FEN string is correct, forward slashes are used to denote a new row
                if (ch == '/') {
                    // If the FEN string is invalid an error is thrown
                    if ((boardPointer % 8) != 0) {
                        throw new InvalidFenString("Error code 002");
                    }
                }
                // Adds pieces to the board
                else if (Character.isAlphabetic(ch)) {
                    // Declares legal alphabetic characters
                    ArrayList<Character> validInputs = new ArrayList<>(Arrays.asList(
                            'r', 'n', 'b', 'q', 'k', 'p'));

                    // Catches illegal alphabetic characters
                    if (!validInputs.contains(Character.toLowerCase(ch))){
                        throw new InvalidFenString("Error code 001");
                    }

                    // Adds the piece specified to the board at the board pointer location
                    board[boardPointer / 8][boardPointer % 8] = ch;

                    // Increments the board pointer by 1 to move to the next location on the board
                    boardPointer++;
                }
                // Adds empty squares to the board
                else if (Character.isDigit(ch)) {
                    boardPointer += Character.getNumericValue(ch);
                }
                // Catches illegal characters in the FEN string
                else {
                    throw new InvalidFenString("Error code 001");
                }

            }
            // Determines the side to move in the current position
            else if (sectionInFen == 1) {
                // Verifies that the board is the correct size
                if (boardPointer == 64) {
                    boardPointer = -1;
                }
                // If this statement is true, then we know that this code has been repeated and that
                // the segment of the FEN string that deals with the turn is longer than expected
                else if (boardPointer == -1) {
                    throw new InvalidFenString("Error code 003");
                }
                // If this segment of the code is run then we know that the size of the board is
                // wrong, and that we should throw an exception
                else {
                    throw new InvalidFenString("Error code 002");
                }

                // Determines the side to play in the current position
                if (ch == 'w') {
                    isWhiteTurn = true;
                } else if (ch == 'b') {
                    isWhiteTurn = false;
                }
                // Catches illegal characters
                else {
                    throw new InvalidFenString("Error code 003");
                }
            }
            // Determines castling privileges in the FEN string
            else if (sectionInFen == 2) {
                // If this code is true, then we know that something has gone wrong as we have read
                // a dash, meaning that we should have skipped this bit and moved onto the next FEN
                // string section
                if (boardPointer == -2) {
                    throw new InvalidFenString("Error code 004");
                }
                // Basically, this bit of code is to ensure that if any character is repeated,
                // then we know that the FEN string is invalid, and that we should reject the
                // FEN string by throwing an exception.
                if (ch == 'K' & !whiteCanKingSideCastle) {
                    whiteCanKingSideCastle = true;
                } else if (ch == 'k' & !blackCanKingSideCastle) {
                    blackCanKingSideCastle = true;
                } else if (ch == 'Q' & !whiteCanQueenSideCastle) {
                    whiteCanQueenSideCastle = true;
                } else if (ch == 'q' & !blackCanQueenSideCastle) {
                    blackCanQueenSideCastle = true;
                }
                // Tells the code that we have already been through this segment
                else if (ch == '-' ^
                        (whiteCanKingSideCastle || whiteCanQueenSideCastle
                        || blackCanKingSideCastle || blackCanQueenSideCastle)) {
                    boardPointer = -2;
                }
                // Catches illegal characters
                else {
                    throw new InvalidFenString("Error code 004");
                }
            }
            // Determines the en passant square of the FEN string
            else if (sectionInFen == 3) {
                // If we have already iterated through this part of the code then we know that something
                // has gone wrong, and we throw an exception. This is because we set boardPointer to -3
                // if we read a dash, and we should expect to move on to the next section of the FEN
                // string. If the length of the String enPassantSquare is greater than or equal to two
                // then we know that something has gone wrong as we should be moving on to the next
                // section of the FEN string.
                if (boardPointer == -3 || enPassantSquare.length() >= 2) {
                    throw new InvalidFenString("Error code 005");
                }

                // Tells the code that we have already iterated through this section of the FEN string
                if (ch == '-') {
                    boardPointer = -3;
                }

                // Determines the en passant Square

                // If the en passant square variable is empty, then we know that we should expect a
                // letter between a and e
                else if (enPassantSquare.length() == 0)
                {
                    // ASCII value of 'a' is 97, and ASCII value of 'b' is 104
                    if (!(ch >= 97 && ch <= 104)) {
                        throw new InvalidFenString("Error code 005");
                    }
                }
                // Otherwise if the en passant square variable has a length of 1, i.e. there is already
                // a letter being stored by the en passant square, then we know that we should expect a
                // number between 1 and 8
                else {
                    // ASCII value of '1' is 49, and ASCII value of '8' is 56
                    if (!(ch >= 49 && ch <= 56)) {
                        throw new InvalidFenString("Error code 005");
                    }
                }

                enPassantSquare = enPassantSquare + ch;
            }
            // Calculates the 50 move rule
            else if (sectionInFen == 4) {
                halfmoveClock = (short) (halfmoveClock * 10 + Character.getNumericValue(ch));

                // If a non number digit is added then an exception is thrown
                if (!Character.isDigit(ch)) {
                    throw new InvalidFenString("Error code 006");
                }
            }
            // Calculates how many moves have been played
            else if (sectionInFen == 5) {
                fullmoveNumber = (short) (fullmoveNumber * 10 + Character.getNumericValue(ch));
                if (!Character.isDigit(ch)) {
                    throw new InvalidFenString("Error code 007");
                }
            }
            // Catches if the FEN string is longer than expected
            else {
                throw new InvalidFenString("Error code 008");
            }
        }

        // The game
        while (true) {
            // Command line display of the current board
            for (int i = 0; i < 8; i++) {
                System.out.print((8 - i) + " [ ");
                for (char j : board[i]) {
                    System.out.print(j + " ");
                }
                System.out.println("]");
            }
            System.out.println("    a b c d e f g h");

            if (isWhiteTurn) {
                System.out.println("White to play");
            } else {
                System.out.println("Black to play");
            }

            if (whiteCanKingSideCastle) {
                System.out.println("White can castle kingside");
            } else {
                System.out.println("White cannot castle kingside");
            }
            if (whiteCanQueenSideCastle) {
                System.out.println("White can castle queenside");
            } else {
                System.out.println("White cannot castle queenside");
            }
            if (blackCanKingSideCastle) {
                System.out.println("Black can castle kingside");
            } else {
                System.out.println("Black cannot castle kingside");
            }
            if (blackCanQueenSideCastle) {
                System.out.println("Black can castle queenside");
            } else {
                System.out.println("Black cannot castle queenside");
            }

            if (enPassantSquare.equals("-")) {
                System.out.println("En Passant is not possible right now");
            } else {
                System.out.println("En Passant is possible on " + enPassantSquare);
            }

            if (halfmoveClock < 100) {
                System.out.println(halfmoveClock + " half moves since a pawn move or a check, " +
                        (100 - halfmoveClock) + " half moves until 50 move rule");
            } else {
                System.out.println("The 50 move rule may be claimed");
            }

            if (fullmoveNumber % 10 == 1) {
                System.out.println("This is the " + fullmoveNumber + "st move");
            } else if (fullmoveNumber % 10 == 2) {
                System.out.println("This is the " + fullmoveNumber + "nd move");
            } else if (fullmoveNumber % 10 == 3) {
                System.out.println("This is the " + fullmoveNumber + "rd move");
            } else {
                System.out.println("This is the " + fullmoveNumber + "th move");
            }

            // System.out.println("Testing...");
            pseudoLegalMoves = PseudoLegalMoves.calculatePseudoLegalMoves(board, isWhiteTurn,
                    enPassantSquare, whiteCanKingSideCastle, whiteCanQueenSideCastle,
                    blackCanKingSideCastle, blackCanQueenSideCastle);
            legalMoves = LegalMoves.calculateLegalMoves(board, pseudoLegalMoves, isWhiteTurn);

            inCheck = CheckChecker.InCheck(board, isWhiteTurn);

            if (legalMoves.size() == 0 ) {
                if (inCheck) {
                    System.out.print("This is a Checkmate ");
                } else {
                    System.out.print("This is a Stalemate ");
                }

                if (isWhiteTurn) {
                    System.out.println(" for white");
                } else {
                    System.out.println(" for black");
                }
            } else {
                /*
                System.out.println("I found : " + legalMoves.size() + " legal moves in this position");
                System.out.println("The moves are: ");

                for (String i: legalMoves) {
                    System.out.println(i);
                }

                */

                if (inCheck) {
                    if (isWhiteTurn) {
                        System.out.println("White is in check");
                    } else {
                        System.out.println("Black is in check");
                    }
                }
            }

            /*
            System.out.print("Test complete! Press enter to continue");
            input.nextLine();
            */
            
            validMove = false;
            
            while (!validMove) {
                System.out.print("Enter the location of the piece you want to move : ");
                pieceOrigin = input.nextLine().toLowerCase();

                if (pieceOrigin.length() >= 2) {
                    pieceOriginY = 8 - Character.getNumericValue(pieceOrigin.charAt(1));
                    pieceOriginX = Character.toLowerCase(pieceOrigin.charAt(0)) - 97;
                } else {
                    System.out.println("Please do not enter an empty input");
                    continue;
                }

                if (pieceOriginY < 0 || pieceOriginY > 8 ||
                        pieceOriginX < 0 || pieceOriginX > 8) {
                    System.out.println("Please enter a valid square target");
                    continue;
                }

                pieceMoved = board[pieceOriginY][pieceOriginX];

                if (pieceMoved == '\u0000') {
                    System.out.println("Please select a square that has a piece on it");
                    continue;
                }

                System.out.print("Enter the destination of the piece you want to move : ");
                pieceDestination = input.nextLine().toLowerCase();

                if (pieceDestination.length() >= 2) {
                    pieceDestinationY = 8 - Character.getNumericValue(pieceDestination.charAt(1));
                    pieceDestinationX = Character.toLowerCase(pieceDestination.charAt(0)) - 97;
                } else {
                    System.out.println("Please do not enter an empty input");
                    continue;
                }

                if (pieceDestinationY < 0 || pieceDestinationY > 8 ||
                        pieceDestinationX < 0 || pieceDestinationX > 8) {
                    System.out.println("Please enter a valid square target");
                    continue;
                }
                
                if (LegalMoves.isMoveLegal(pieceOriginX, pieceOriginY, pieceDestinationX, pieceDestinationY
                        ,legalMoves, isWhiteTurn)) {
                    validMove = true;
                } else {
                    System.out.println("That was not a legal move");
                }
            }

            char[][] boardUpdate = MoveMaker.makeMove(board, pieceOriginX, pieceOriginY,
                    pieceDestinationX, pieceDestinationY, isWhiteTurn, enPassantSquare);

            for (int i = 0; i < 8; i++) {
                board[i] = boardUpdate[i].clone();
            }

            castlingPrivileges = SpecialMoveAvailability.CastlingChecker(board,
                    whiteCanKingSideCastle, whiteCanQueenSideCastle, blackCanKingSideCastle, blackCanQueenSideCastle);

                whiteCanKingSideCastle = castlingPrivileges[0];
                whiteCanQueenSideCastle = castlingPrivileges[1];
                blackCanKingSideCastle = castlingPrivileges[2];
                blackCanQueenSideCastle = castlingPrivileges[3];

            enPassantSquare = SpecialMoveAvailability.EnPassantChecker(pieceMoved, pieceOriginY,
                    pieceDestinationY, pieceOriginX);

            if (!isWhiteTurn) {
                fullmoveNumber++;
            }

            if (CheckChecker.InCheck(board, isWhiteTurn) || Character.toLowerCase(pieceMoved) == 'p') {
                halfmoveClock = 0;
            } else {
                halfmoveClock++;
            }

            isWhiteTurn = !isWhiteTurn;


        }
    }
}
