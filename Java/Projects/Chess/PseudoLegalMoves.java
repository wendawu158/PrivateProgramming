package Projects.Chess;

import java.util.ArrayList;

public class PseudoLegalMoves {
    public static ArrayList<String> calculatePseudoLegalMoves (
            char[][] board, boolean isWhiteTurn, String enPassantSquare,
            boolean whiteCanKingSideCastle, boolean whiteCanQueenSideCastle,
            boolean blackCanKingSideCastle, boolean blackCanQueenSideCastle
            ) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        for (int pieceY = 0; pieceY < 8; pieceY++){
            for (int pieceX = 0; pieceX < 8; pieceX++) {

                char pieceType = Character.toLowerCase(board[pieceY][pieceX]);
                boolean pieceIsWhite = Character.isUpperCase(board[pieceY][pieceX]);

                if (isWhiteTurn == Character.isUpperCase(board[pieceY][pieceX])) {
                    if (pieceType == 'r') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                rookPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                    } else if (pieceType == 'b') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                bishopPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                    } else if (pieceType == 'q') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                rookPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                bishopPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                    } else if (pieceType == 'k') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                kingPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                    } else if (pieceType == 'n') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                knightPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite));
                    } else if (pieceType == 'p') {
                        pseudoLegalMoves.addAll(PseudoLegalMoves.
                                pawnPseudoLegalMoves(board, pieceX, pieceY, pieceIsWhite,
                                    enPassantSquare));
                    }
                }
            }
        }

        pseudoLegalMoves.addAll(PseudoLegalMoves.castling(board, isWhiteTurn,
                whiteCanKingSideCastle, whiteCanQueenSideCastle,
                blackCanKingSideCastle, blackCanQueenSideCastle));

        return pseudoLegalMoves;
    }

    public static ArrayList<String> rookPseudoLegalMoves (
            char[][] board, int pieceX, int pieceY, boolean pieceIsWhite) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        int[][] rookMoves = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] i: rookMoves){
            for (int j = 1; j * i[0] + pieceY < 8 && j * i[1] + pieceX < 8 &&
                j * i[0] + pieceY > -1 && j * i[1] + pieceX > -1; j++){
                if (board[j * i[0] + pieceY][j * i[1] + pieceX] == '\u0000') {
                    pseudoLegalMoves.add("R" + pieceX + pieceY +
                            (j * i[1] + pieceX) + (j * i[0] + pieceY));
                } else if (pieceIsWhite != Character.isUpperCase(
                        board[j * i[0] + pieceY][j * i[1] + pieceX])) {
                    pseudoLegalMoves.add("R" + pieceX + pieceY +
                            (j * i[1] + pieceX) + (j * i[0] + pieceY));
                    break;
                } else {
                    break;
                }
            }
        }

        /*

        for (int i = pieceX + 1; i < 8; i++) {
            if (board[pieceY][i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + i + pieceY);
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY][i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + i + pieceY);
                break;
            } else {
                break;
            }
        }

        for (int i = pieceX - 1; i > -1; i--) {
            if (board[pieceY][i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + i + pieceY);
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY][i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + i + pieceY);
                break;
            } else {
                break;
            }
        }

        for (int i = pieceY + 1; i < 8; i++) {
            if (board[i][pieceX] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + pieceX + i);
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY][i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + pieceX + i);
                break;
            } else {
                break;
            }
        }

        for (int i = pieceY - 1; i > -1; i--) {
            if (board[i][pieceX] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + pieceX + i);
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY][i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + pieceX + i);
                break;
            } else {
                break;
            }
        }

        */

        return pseudoLegalMoves;
    }

    public static ArrayList<String> bishopPseudoLegalMoves (
            char[][] board, int pieceX, int pieceY, boolean pieceIsWhite) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        int[][] bishopMoves = {
                {1, 1},
                {-1, -1},
                {-1, 1},
                {1, -1}
        };

        for (int[] i: bishopMoves){
            for (int j = 1; j * i[0] + pieceY < 8 && j * i[1] + pieceX < 8 &&
                    j * i[0] + pieceY > -1 && j * i[1] + pieceX > -1; j++){
                if (board[j * i[0] + pieceY][j * i[1] + pieceX] == '\u0000') {
                    pseudoLegalMoves.add("B" + pieceX + pieceY +
                            (j * i[1] + pieceX) + (j * i[0] + pieceY));
                } else if (pieceIsWhite != Character.isUpperCase(
                        board[j * i[0] + pieceY][j * i[1] + pieceX])) {
                    pseudoLegalMoves.add("B" + pieceX + pieceY +
                            (j * i[1] + pieceX) + (j * i[0] + pieceY));
                    break;
                } else {
                    break;
                }
            }
        }

        /*

        for (int i = 1; pieceX + i < 8 && pieceY + i < 8; i++) {
            if (board[pieceY + i][pieceX + i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX + i) + (pieceY + i));
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY + i][pieceX + i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX + i) + (pieceY + i));
                break;
            } else {
                break;
            }
        }

        for (int i = 1; pieceX - i > -1 && pieceY - i > -1; i++) {
            if (board[pieceY + i][pieceX + i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX - i) + (pieceY - i));
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY - i][pieceX - i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX - i) + (pieceY - i));
                break;
            } else {
                break;
            }
        }

        for (int i = 1; pieceX + i < 8 && pieceY - i > -1; i++) {
            if (board[pieceY + i][pieceX + i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX + i) + (pieceY - i));
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY + i][pieceX - i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX + i) + (pieceY - i));
                break;
            } else {
                break;
            }
        }

        for (int i = 1; pieceX - i > -1 && pieceY + i < 8; i++) {
            if (board[pieceY + i][pieceX + i] == '\u0000') {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX - i) + (pieceY + i));
            } else if (pieceIsWhite != Character.isUpperCase(board[pieceY - i][pieceX + i])) {
                pseudoLegalMoves.add("" + pieceX + pieceY + (pieceX - i) + (pieceY + i));
                break;
            } else {
                break;
            }
        }

        */

        return pseudoLegalMoves;
    }

    public static ArrayList<String> knightPseudoLegalMoves (
            char[][] board, int pieceX, int pieceY, boolean pieceIsWhite) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        int[][] knightMoves = {
                {1, 2},
                {-1, -2},
                {1, -2},
                {-1, 2},
                {2, 1},
                {-2, -1},
                {2, -1},
                {-2, 1}
        };

        for (int[] i: knightMoves) {
            if (pieceY + i[0] < 8 && pieceY + i[0] > -1
                    && pieceX + i[1] < 8 && pieceX + i[1] > -1) {
                if (board[pieceY + i[0]][pieceX + i[1]] == '\u0000' ||
                        pieceIsWhite != Character.isUpperCase(
                                board[pieceY + i[0]][pieceX + i[1]])) {
                    pseudoLegalMoves.add("N" + pieceX + pieceY + (pieceX + i[1]) + (pieceY + i[0]));
                }
            }
        }

        return pseudoLegalMoves;
    }

    public static ArrayList<String> kingPseudoLegalMoves (
            char[][] board, int pieceX, int pieceY, boolean pieceIsWhite) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        int[][] kingMoves = {
                {1, 1},
                {1, 0},
                {1, -1},
                {0, 1},
                {0, -1},
                {-1, 1},
                {-1, 0},
                {-1, -1}
        };

        for (int[] i: kingMoves) {
            if (pieceY + i[0] < 8 && pieceY + i[0] > -1
                    && pieceX + i[1] < 8 && pieceX + i[1] > -1) {
                if (board[pieceY + i[0]][pieceX + i[1]] == '\u0000' ||
                        pieceIsWhite != Character.isUpperCase(
                                board[pieceY + i[0]][pieceX + i[1]])) {
                    pseudoLegalMoves.add("K" + pieceX + pieceY + (pieceX + i[1]) + (pieceY + i[0]));
                }
            }
        }

        return pseudoLegalMoves;
    }

    public static ArrayList<String> pawnPseudoLegalMoves (
            char[][] board, int pieceX, int pieceY, boolean pieceIsWhite, String enPassantSquare) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        int enPassantX = -1;
        int enPassantY = -1;

        if (enPassantSquare.length() == 2) {
            enPassantX = Character.toLowerCase(enPassantSquare.charAt(0)) - 61;
            enPassantY = 8 - Character.getNumericValue(enPassantSquare.charAt(1));
        }

        char[] promotions = {'R', 'Q', 'K', 'B'};

        int pawnDirection;

        if (pieceIsWhite) {
            pawnDirection = -1;
        } else {
            pawnDirection = 1;
        }

        if ((pieceIsWhite && pieceY + pawnDirection != 0) ||
                (!pieceIsWhite && pieceY + pawnDirection != 7)) {
            if (board[pieceY + pawnDirection][pieceX] == '\u0000') {
                pseudoLegalMoves.add("P" + pieceX + pieceY + pieceX + (pieceY + pawnDirection));
                if (board[pieceY + 2 * pawnDirection][pieceX] == '\u0000' &&
                        ((pieceY == 6 && pieceIsWhite) || (pieceY == 1 && !pieceIsWhite))) {
                    pseudoLegalMoves.add("P" + pieceX + pieceY +
                            pieceX + (pieceY + pawnDirection * 2));
                }
            }
            if (pieceX != 0) {
                if ((Character.isUpperCase(board[pieceY + pawnDirection][pieceX - 1]) != pieceIsWhite
                        || (pieceY + pawnDirection == enPassantY && pieceX - 1 == enPassantX))
                        && board[pieceY + pawnDirection][pieceX - 1] != '\u0000') {
                    pseudoLegalMoves.add("P" + pieceX + pieceY +
                            (pieceX - 1) + (pieceY + pawnDirection));
                }
            }
            if (pieceX != 7) {
                if ((Character.isUpperCase(board[pieceY + pawnDirection][pieceX + 1]) != pieceIsWhite
                        || (pieceY + pawnDirection == enPassantY && pieceX + 1 == enPassantX))
                        && board[pieceY + pawnDirection][pieceX + 1] != '\u0000') {
                    pseudoLegalMoves.add("P" + pieceX + pieceY +
                            (pieceX + 1) + (pieceY + pawnDirection));
                }
            }

        } else {
            if (board[pieceY + pawnDirection][pieceX] == '\u0000') {
                for (char i: promotions) {
                    pseudoLegalMoves.add("P" + pieceX + pieceY + pieceX
                            + (pieceY + pawnDirection) + "=" + i);
                }
            }
            if (pieceX != 0) {
                for (char i: promotions) {
                    if (Character.isUpperCase(board[pieceY + pawnDirection][pieceX - 1]) != pieceIsWhite
                            && board[pieceY + pawnDirection][pieceX - 1] != '\u0000') {
                        pseudoLegalMoves.add("P" + pieceX + pieceY +
                                (pieceX - 1) + (pieceY + pawnDirection) + "=" + i);
                    }
                }
            }
            if (pieceX != 7) {
                for (char i: promotions) {
                    if (Character.isUpperCase(board[pieceY + pawnDirection][pieceX + 1]) != pieceIsWhite
                            && board[pieceY + pawnDirection][pieceX + 1] != '\u0000') {
                        pseudoLegalMoves.add("P" + pieceX + pieceY +
                                (pieceX + 1) + (pieceY + pawnDirection) + "=" + i);
                    }
                }
            }
        }

        return pseudoLegalMoves;
    }

    public static ArrayList<String> castling (
            char[][] board, boolean isWhiteTurn,
            boolean whiteCanKingSideCastle, boolean whiteCanQueenSideCastle,
            boolean blackCanKingSideCastle, boolean blackCanQueenSideCastle) {
        ArrayList<String> pseudoLegalMoves = new ArrayList<>();

        if (whiteCanKingSideCastle || whiteCanQueenSideCastle || blackCanKingSideCastle || blackCanQueenSideCastle) {
            if (!CheckChecker.InCheck(board, isWhiteTurn)) {
                int yValue;
                boolean kingsideCastlingAvailability;
                boolean queensideCastlingAvailability;

                if (isWhiteTurn) {
                    yValue = 7;
                    kingsideCastlingAvailability = whiteCanKingSideCastle;
                    queensideCastlingAvailability = whiteCanQueenSideCastle;
                } else {
                    yValue = 0;
                    kingsideCastlingAvailability = blackCanKingSideCastle;
                    queensideCastlingAvailability = blackCanQueenSideCastle;
                }

                if (kingsideCastlingAvailability
                        && board[yValue][5] == '\u0000' && board[yValue][6] == '\u0000') {
                    if (isWhiteTurn) {
                        board[yValue][5] = 'K';
                    } else {
                        board[yValue][5] = 'k';
                    }
                    board[yValue][4] = '\u0000';
                    if (!CheckChecker.InCheck(board, isWhiteTurn)) {
                        pseudoLegalMoves.add("O-O");
                    }
                }
                if (queensideCastlingAvailability
                        && board[yValue][1] == '\u0000' && board[yValue][2] == '\u0000'
                        && board[yValue][3] == '\u0000') {
                    if (isWhiteTurn) {
                        board[yValue][3] = 'K';
                    } else {
                        board[yValue][3] = 'k';
                    }
                    board[yValue][4] = '\u0000';
                    if (!CheckChecker.InCheck(board, isWhiteTurn)) {
                        pseudoLegalMoves.add("O-O-O");
                    }
                }
            }
        }
        return pseudoLegalMoves;
    }
}
