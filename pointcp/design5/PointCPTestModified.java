// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.*;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest {
    //Class methods *****************************************************

    /**
     * This method is responsible for the creation of the PointCP5
     * object.  This can be done in two ways; the first, by using the
     * command line and running the program using <code> java
     * PointCP5Test &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
     * </code> and the second by getting the program to prompt the user.
     * If the user does not enter a valid sequence at the command line,
     * the program will prompte him or her.
     *
     * @param args[0] The coordinate type.  P for polar and C for
     *                cartesian.
     * @param args[1] The value of X or RHO.
     * @param args[2] The value of Y or THETA.
     */
    public static void main(String[] args) {
        PointCP5 point;
        PointCP5 testPoint = new PointCP5('C',2,3);

        System.out.println("Cartesian-Polar Coordinates Conversion Program");
        int counter = 0;
        long startTime = System.currentTimeMillis();

        // Check if the user input coordinates from the command line
        // If he did, create the PointCP5 object from these arguments.
        // If he did not, prompt the user for them.
        while (System.currentTimeMillis() - startTime < 10000) {
            try {
                point = getInput();
            } catch (IOException ex) {
                System.out.println("Error getting input. Ending program.");
                return;
            }
            System.out.println("\nYou entered:\n" + point);
            //point.convertStorageToCartesian();
            //point.convertStorageToPolar();
            //point.getDistance(testPoint);
            point.rotatePoint(new Random().nextDouble());
            //System.out.println("\nTest Completed\n");
            counter += 1;
            System.out.println(counter + " Points were generated and tested.");
        }

    }

    public static char getRandom(char[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * This method obtains input from the user and verifies that
     * it is valid.  When the input is valid, it returns a PointCP5
     * object.
     *
     * @return A PointCP5 constructed using information obtained
     * from the user.
     * @throws IOException If there is an error getting input from
     *                     the user.
     */
    private static PointCP5 getInput() throws IOException {
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'A'; // Temporary default, to be set to P or C
        char[] coords = {'C','P'};
        double a = 0.0;
        double b = 0.0;
        //automatically generate random pointCPs
        coordType = getRandom(coords);
        a = new Random().nextDouble();
        b = new Random().nextDouble();
        return new PointCP5(coordType, a, b);
    }
}
