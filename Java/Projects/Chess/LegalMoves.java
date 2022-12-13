package Projects.Chess;

import java.util.ArrayList;

public class LegalMoves {
    public static ArrayList<String> calculateLegalMoves (
            char[][] board, ArrayList<String> pseudoLegalMoves, boolean isWhiteTurn) {

        ArrayList<String> legalMoves = new ArrayList<>(pseudoLegalMoves);
        ArrayList<String> opponentMoves;

        char[][] tempBoard = new char[8][8];
        int originX;
        int originY;
        int destinationX;
        int destinationY;

        int opponentCaptureX = 0;
        int opponentCaptureY = 0;

        for(String i: pseudoLegalMoves) {
            for (int j = 0; j < 8; j++) {
                tempBoard[j] = board[j].clone();
            }

            originX = -1;
            originY = -1;
            destinationX = -1;
            destinationY = -1;

            if (i.length() == 5 || Character.toLowerCase(i.charAt(0)) == 'p') {
                originX = Character.getNumericValue(i.charAt(1));
                originY = Character.getNumericValue(i.charAt(2));
                destinationX = Character.getNumericValue(i.charAt(3));
                destinationY = Character.getNumericValue(i.charAt(4));
            }

            if (i.charAt(0) == 'O') {
                if (isWhiteTurn) {
                    if (i.length() == 3) {
                        tempBoard[7][0] = '\u0000';
                        tempBoard[7][4] = '\u0000';
                        tempBoard[7][1] = 'K';
                        tempBoard[7][2] = 'R';
                    } else {
                        tempBoard[7][7] = '\u0000';
                        tempBoard[7][4] = '\u0000';
                        tempBoard[7][6] = 'K';
                        tempBoard[7][5] = 'R';
                    }
                } else {
                    if (i.length() == 3) {
                        tempBoard[0][0] = '\u0000';
                        tempBoard[0][4] = '\u0000';
                        tempBoard[0][1] = 'k';
                        tempBoard[0][2] = 'r';
                    } else {
                        tempBoard[0][8] = '\u0000';
                        tempBoard[0][4] = '\u0000';
                        tempBoard[0][6] = 'k';
                        tempBoard[0][5] = 'r';
                    }
                }
            } else if (i.charAt(0) == 'P' &&
                tempBoard[destinationY][destinationX] == '\u0000') {
                tempBoard[destinationY][destinationX] = tempBoard[originY][originX];
                tempBoard[originY][originX] = '\u0000';
                tempBoard[originY][destinationX] = '\u0000';

                //if (Math.abs(destinationY - originY) == 2) {
                //    enPassantSquare = new String(new char[]{(char) (97 + destinationX), (char) (56 - destinationY)});
                //}

            } else {
                tempBoard[destinationY][destinationX] = tempBoard[originY][originX];
                tempBoard[originY][originX] = '\u0000';
            }

            opponentMoves = PseudoLegalMoves.calculatePseudoLegalMoves(tempBoard, !isWhiteTurn,
                    "", false, false,
                    false, false);

            for (String j: opponentMoves) {
                opponentCaptureX = Character.getNumericValue(j.charAt(3));
                opponentCaptureY = Character.getNumericValue(j.charAt(4));

                if (isWhiteTurn) {
                    if (tempBoard[opponentCaptureY][opponentCaptureX] == 'K') {
                        legalMoves.remove(i);
                    }
                }
            }
        }

        return legalMoves;
    }

    public static boolean isMoveLegal(int originX, int originY, int destinationX, int destinationY,
          ArrayList<String> legalMoves, boolean isWhiteTurn) {

        for (String i: legalMoves) {
            if (Character.getNumericValue(i.charAt(1)) == originX &&
                Character.getNumericValue(i.charAt(2)) == originY &&
                Character.getNumericValue(i.charAt(3)) == destinationX &&
                Character.getNumericValue(i.charAt(4)) == destinationY) {
                return true;
            } else if (i.charAt(0) == 'O' && originX == 4) {
                if (isWhiteTurn && originY == 7 && destinationY == 7) {
                    if (i.length() == 3 && destinationX == 6) {
                        return true;
                    } else if (i.length() == 5 && destinationX == 2) {
                        return true;
                    }
                } else if (!isWhiteTurn && originY == 0 && destinationY == 0) {
                    if (i.length() == 3 && destinationX == 6) {
                        return true;
                    } else if (i.length() == 5 && destinationX == 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
