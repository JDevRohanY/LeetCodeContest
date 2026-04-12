package WeekelyContest497;

import java.util.Arrays;

/*

 */
public class AnglesOfTriangle {
    static void main() {

    }

    public static double[] internalAngles(int[] sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        //check triangle validity
        if(((a+b)<=c) || ((a+c)<=b) ||((b+c)<=a)){
            return new double[]{};
        }

        //calculate degree of each
        double angle_A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2 * b * c)));
        double angle_B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2 * a * c)));
        double angle_C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2 * a * b)));

        double[] angles = new double[3];
        angles[0] = angle_A;
        angles[1] = angle_B;
        angles[2] = angle_C;

        // Sort in non-decreasing order
        Arrays.sort(angles);

        // Round each angle to 5 decimal places
        for (int i = 0; i < angles.length; i++) {
            angles[i] = Math.round(angles[i] * 1e5) / 1e5;
        }

        return angles;
    }
}
