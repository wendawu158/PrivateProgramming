package Atlas;

public class translator {
    public static String startString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public char[][] translation() {
        return translation(startString);
    }

    public char[][] translation(String fen) {
        String[] fenSections = startString.split(" ");
    }

}
