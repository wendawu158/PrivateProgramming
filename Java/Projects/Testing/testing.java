package Projects.Testing;

import java.util.Scanner;

public class testing{
    public static void main(String[] args) {
        int destinationY = 0;
        int destinationX = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {
            destinationY = sc.nextInt();
            destinationX = sc.nextInt();

            String enPassantSquare = "";
            enPassantSquare = new String(new char[]{(char) (97 + destinationX), (char) (56 - destinationY)});

            System.out.println(enPassantSquare);
        }
    }
}
