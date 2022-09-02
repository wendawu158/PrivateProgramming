package Projects.Lessons;

public class Lesson_2_Variables_and_Data_Types {

    public static void main(String[] args){
        // A variable, just like in mathematics, is something that holds a value
        // However, there are multiple different types of variables
        // Integers, Floats, Booleans, and Chars, are all examples of data types
        // When creating a variable, we must first define what type of variable it will be
        // Java does not allow for variables to change data types after they are set
        // Note that variables must not contain spaces or special characters (excluding underscores)

        // Declaring and Defining an Integer (Whole number)
        int integer1 = 5;
        System.out.println(integer1);

        // Note that the following commented code would not work
        // System.out.println(integer2)
        // int integer2 = 10;
        // This is because the computer reads code left to right and top to bottom, meaning that
        // the variable is called before it is defined, causing an error

        // Declaring and Defining a Float (decimal point number)
        float real1 = 10.5f;

        // The f is there at the end of the number to cast the number as a float

        // Declaring and Defining a Boolean (True or false)
        boolean boolean1 = true;

        // Declaring and Defining a Character (single text character)
        char character1 = 'c';

        // Declaring and Defining a String (Text)
        String string1 = "hello";

        // Note that strings are "" while characters are ''

        // List of all data types
        byte integer2 = -128; // Stores whole numbers between -128 and 127
        short integer3 = -32768; // Stores whole numbers between -32768 to 32767
        int integer4 = -2147483648; // Stores whole numbers from -2,147,483,648 to 2,147,483,647
        long integer5 = -9223372036854775808L; // Stores whole numbers from -9,223,372,036,854,775,808 to
                        // 9,223,372,036,854,775,807
        float real2 = 1.23456789f; // Stores fractional numbers.
                                   // Sufficient for storing 6 to 7 decimal digits
        double real3 = 1.223456789123456789; // Stores fractional numbers.
                                             // Sufficient for storing 15 decimal digits
        boolean bool2 = false; // Stores true or false values
        char character2 = 'h'; // Stores a single character/letter or ASCII values
    }
}
