import java.util.Scanner;
import java.lang.Math;

/**
 * Displays a number of powers for
 * each integer starting from 1 to
 * the integer indicated by the
 * user
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class LabThree {
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        int userInput = -1;
        int baseNum;
        int[][] myPowerArray;
        boolean doAgain = false;
        boolean correctInput;
        char startOver = 'z';


        do {

            // collects the integer from the user
            System.out.print("Please enter an integer: ");
            userInput = scnr.nextInt();
            System.out.println();

            // converts last column's cube to a string
            String lastCube = Integer.toString((int)Math.pow((double)userInput, 3.0));
            // gets that string's length
            int lastCubeLength;
            if (lastCube.length() < 7) {
                lastCubeLength = 8;
            }
            else {
                lastCubeLength = lastCube.length();
            }

            // prints the header to the table
            System.out.printf("%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\n", "Base", "Squared", "Cubed");
            System.out.printf("%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\n", "========", "========", "========");

            // initializes my array
            myPowerArray = new int[userInput][3];

            // prints the base number, square, and cube
            for(int i = 0; i < userInput; i++) {

                // baseNum will increment along with i, but will start at 1 and not 0
                baseNum = i + 1;

                // defines column i, row 1
                myPowerArray[i][0] = baseNum;
                //defines column i, row 2
                //takes baseNum, explicitly converts this to a double using the (double) prefix
                //uses Math.pow(double, double) to bring baseNum to the power of 2.0
                //converts this "square" back to an integer with (int) prefix
                myPowerArray[i][1] = (int)Math.pow((double)baseNum, 2.0);
                //repeats this process with exponent 3.0 to create a "cube"
                myPowerArray[i][2] = (int)Math.pow((double)baseNum, 3.0);

                System.out.printf("%-" + lastCubeLength + "d\t\t%-" + lastCubeLength + "d\t\t%-" + lastCubeLength + "d\n", myPowerArray[i][0], myPowerArray[i][1], myPowerArray[i][2]);
            }



            System.out.println();
            System.out.print("Do you want to go again?: ");
            do {
                // collects input the first character (a-z regardless of case), and switches to lowercase
                startOver = Character.toLowerCase(scnr.next("[a-zA-Z]").charAt(0));

                switch (startOver) {
                    case 'y':
                        correctInput = true;
                        doAgain = true;

                        break;
                    case 'n':
                        correctInput = true;
                        doAgain = false;
                        System.out.println("Goodbye!");

                        break;
                    case 'z':
                        System.out.println("Something went wrong with your switch!");
                        correctInput = false;
                        break;

                    default:
                        System.out.println("Incorrect input, please try again!");
                        correctInput = false;

                        break;
                }
            }
            while(!correctInput);
        }
        while(doAgain);
    }
}
