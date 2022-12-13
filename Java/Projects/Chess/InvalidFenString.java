package Projects.Chess;

public class InvalidFenString extends RuntimeException{
    public InvalidFenString(String message) {
        super("This is an invalid FEN string : " + message);
    }

    // Error code 1 - Illegal character in FEN string in board declaration
    // Error code 2 - Illegal board size described by FEN string in board declaration
    // Error code 3 - Illegal character in FEN string in turn declarations
    // Error code 4 - Illegal character in FEN string in castling right declarations
    // Error code 5 - Illegal character in FEN string in en passant eligibility declarations

}
