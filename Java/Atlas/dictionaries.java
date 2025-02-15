package Atlas;

import java.util.Map;

public class dictionaries {

    public static Map<Boolean, Byte> pawnDirection =
            Map.of(
                    true, (byte) -1,
                    false, (byte) 1
            );

    public static Map<Character, Byte> letterToNumber =
            Map.of(
                    'a', (byte) 0,
                    'b', (byte) 1,
                    'c', (byte) 2,
                    'd', (byte) 3,
                    'e', (byte) 4,
                    'f', (byte) 5,
                    'g', (byte) 6,
                    'h', (byte) 7
            );

    public static Map<Byte, Character> numberToLetter =
            Map.of(
                    (byte) 0, 'a',
                    (byte) 1, 'b',
                    (byte) 2, 'c',
                    (byte) 3, 'd',
                    (byte) 4, 'e',
                    (byte) 5, 'f',
                    (byte) 6, 'g',
                    (byte) 7, 'h'
            );

}
