package Atlas;

import java.util.Map;

public class standardAlgorithms {

    // Determines if character is in character array
    public static boolean contains(char[] array, char key) {
        for (char c : array) {
            if (c == key) {
                return true;
            }
        }
        return false;
    }

    // Determines if String is in String array
    public static boolean contains(String[] array, String key) {
        for (String s : array) {
            if (s.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Determines if integer is in integer array
    public static boolean contains(int[] array, int key) {
        for (int j : array) {
            if (j == key) {
                return true;
            }
        }
        return false;
    }

    // Determines if long is in long array
    public static boolean contains(long[] array, long key) {
        for (long l : array) {
            if (l == key) {
                return true;
            }
        }
        return false;
    }

}
