package Projects.Chess;

import java.util.ArrayList;

public class CheckChecker {
    public static boolean InCheck (char[][] board, boolean isWhiteTurn) {
        boolean isCheck = false;

        int attackingSquareX = 0;
        int attackingSquareY = 0;

        ArrayList<String> opponentMoves = new ArrayList<>(PseudoLegalMoves.calculatePseudoLegalMoves(
                board, !isWhiteTurn, "", false, false,
                false, false));

        for (String i: opponentMoves) {
            attackingSquareX = Character.getNumericValue(i.charAt(3));
            attackingSquareY = Character.getNumericValue(i.charAt(4));

            if (Character.toLowerCase(board[attackingSquareY][attackingSquareX]) == 'k' &&
                    Character.isUpperCase(board[attackingSquareY][attackingSquareX]) == !isWhiteTurn) {
                isCheck = true;
                break;
            }
        }

        return isCheck;
    }
}
