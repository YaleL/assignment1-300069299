// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP5
{
    //Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord,reqType;

    /**
     * Contains the current polar values
     */
    private PointCP2 polarPoint;

    /**
     * Contains the current cartesian values
     */
    private PointCP3 cartesianPoint;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP5(char type, double xOrRho, double yOrTheta)
    {
        if(type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        polarPoint = new PointCP2(type,xOrRho,yOrTheta);
        cartesianPoint = new PointCP3(type,xOrRho,yOrTheta);
        typeCoord = type;
        reqType = type;
    }


    //Instance methods **************************************************


    public double getX()
    {
        if(typeCoord == 'C')
            return cartesianPoint.getX();
        else
            return polarPoint.getX();
    }

    public double getY()
    {
        if(typeCoord == 'C')
            return cartesianPoint.getY();
        else
            return polarPoint.getY();
    }

    public double getRho()
    {
        if(typeCoord == 'C')
            return cartesianPoint.getRho();
        else
            return polarPoint.getRho();
    }

    public double getTheta()
    {
        if(typeCoord == 'C')
            return cartesianPoint.getTheta();
        else
            return polarPoint.getTheta();
    }


    /**
     * Converts Cartesian coordinates to Polar coordinates.
     */
    public void convertStorageToPolar()
    {
        reqType = 'P';
    }

    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    public void convertStorageToCartesian()
    {
        reqType = 'C';//Change coord type identifier
    }

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP5 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP5 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP5('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        if (reqType != 'C'){
            return polarPoint.toString();
        } else {
            return cartesianPoint.toString();
        }
    }
}
