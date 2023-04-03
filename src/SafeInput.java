import java.util.Scanner;
public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }
        while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;  // Set this to zero. Loop runs until it isn’t
        String trash;

        System.out.print("\n" + prompt + ": "); // show prompt add space

        if (pipe.hasNextInt()) {
            // OK safe to read in a double
            retInt = pipe.nextInt();
            pipe.nextLine(); // clears the newline from the buffer
        } else {
            while (!pipe.hasNextInt()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": "); // show prompt add space

                if (pipe.hasNextInt()) {
                    // OK safe to read in a double
                    retInt = pipe.nextInt();
                    pipe.nextLine(); // clears the newline from the buffer
                    break;
                }
            }
        }

        return retInt;

    }


    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;  // Set this to zero. Loop runs until it isn’t
        String trash;


        System.out.print("\n" + prompt + ": "); // show prompt add space

        if (pipe.hasNextDouble()) {
            // OK safe to read in a double
            retDouble = pipe.nextDouble();
            pipe.nextLine(); // clears the newline from the buffer
        } else {
            while (!pipe.hasNextDouble()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": "); // show prompt add space

                if (pipe.hasNextInt()) {
                    // OK safe to read in a double
                    retDouble = pipe.nextInt();
                    pipe.nextLine(); // clears the newline from the buffer
                    break;
                }
            }
        }

        return retDouble;

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;  // Set this to zero. Loop runs until it isn’t
        String trash;

        System.out.print("\n" + prompt + ": "); // show prompt add space

        if (pipe.hasNextInt()) {
            // OK safe to read in a double
            retInt = pipe.nextInt();
            pipe.nextLine(); // clears the newline from the buffer
        } else {
            while (!pipe.hasNextInt()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": "); // show prompt add space

                if (pipe.hasNextInt()) {
                    // OK safe to read in a double
                    retInt = pipe.nextInt();
                    pipe.nextLine(); // clears the newline from the buffer
                    break;
                }
            }
        }

        while (retInt < low || retInt > high) {
            System.out.print("Please enter a number between " + low + " and " + high + ": ");
            retInt = pipe.nextInt();
        }
        return retInt;

    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0;  // Set this to zero. Loop runs until it isn’t
        String trash;

        System.out.print("\n" + prompt + ": "); // show prompt add space

        if (pipe.hasNextDouble()) {
            // OK safe to read in a double
            retDouble = pipe.nextDouble();
            pipe.nextLine(); // clears the newline from the buffer
        } else {
            while (!pipe.hasNextDouble()) {
                trash = pipe.nextLine();
                System.out.print("\n" + prompt + ": "); // show prompt add space

                if (pipe.hasNextDouble()) {
                    // OK safe to read in a double
                    retDouble = pipe.nextDouble();
                    pipe.nextLine(); // clears the newline from the buffer
                    break;
                }
            }
        }

        while (retDouble < low || retDouble > high) {
            System.out.print("Please enter a number between " + low + " and " + high + ": ");
            retDouble = pipe.nextDouble();
        }
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        System.out.print(prompt);
        String retString = pipe.nextLine();
        while (!retString.equalsIgnoreCase("Y") && !retString.equalsIgnoreCase("N")) {
            System.out.print("Please enter Y or N: ");

            retString = pipe.nextLine();

        }

        if (retString.equalsIgnoreCase("y")) {
            return true;
        } else
        {
            return false;
        }

    }
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String value = "";
        boolean gotAValue = false;

        do {
            System.out.print(prompt + ": ");
            value = pipe.nextLine();
            if (value.matches(regExPattern)) {
                gotAValue = true;
            } else {
                System.out.println("\nInvalid input: " + value);
            }
        } while(!gotAValue);

        return value;
    }
}

