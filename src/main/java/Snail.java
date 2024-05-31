import java.util.ArrayList;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {

        if(array2d == null){

            return new int[0];

        }

        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }

        int n = array2d.length;
        int[] result = new int[n * n];

        int index = 0;

        // declare boundaries

        int top = 0; // top: index 0 (first index of each 1d array)
        int bottom = n - 1; // bottom: index 4 (index of last 1d array)
        int right = n - 1; // right: index 4 (last index of each 1d array)
        int left = 0; // left: (index of first 1d array)

        while(top <= bottom && left <= right){

            // pattern: right, down, left, up

            // going right across top (change row value ++)

            for(int i = left; i <= right; i++){

                result[index++] = array2d[top][i];

            }
            top++; // top borders close by 1 index

            // going down across right (change column value ++)

            for(int i = top; i <= bottom; i++){

                result[index++] = array2d[i][right];

            }
            right--;

            // going left across bottom (change row value --)

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {

                    result[index++] = array2d[bottom][i];

                }
                bottom--;
            }

            // going up across left (change column value --)

            if(left <= right) {
                for (int i = bottom; i >= top; i--) {

                    result[index++] = array2d[i][left];

                }

                left++;
            }

        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {

        if(array1d == null){

            return new int[0][0];

        }

        if(!isPerfectSquare(array1d)){

            return new int[0][0];

        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] result = new int[n][n];
        int index = 0;

        // declare boundaries

        int top = 0; // top: index 0 (first index of each 1d array)
        int bottom = n - 1; // bottom: index 4 (index of last 1d array)
        int right = n - 1; // right: index 4 (last index of each 1d array)
        int left = 0; // left: (index of first 1d array)

        while(top <= bottom && left <= right){

            // pattern: right, down, left, up

            // going right across top (change row value ++)

            for(int i = left; i <= right; i++){

                result[top][i] = array1d[index++];
                // result[index++] = array2d[top][i];

            }
            top++; // top borders close by 1 index

            // going down across right (change column value ++)

            for(int i = top; i <= bottom; i++){

                result[i][right] = array1d[index++];

            }
            right--;

            // going left across bottom (change row value --)

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {

                    result[bottom][i] = array1d[index++];

                }
                bottom--;
            }

            // going up across left (change column value --)

            if(left <= right){

                for(int i = bottom; i >= top; i--){

                    result[i][left] = array1d[index++];

                }

                left++;

            }
        }

        return result;

    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {

        for(int i: array1d){
            System.out.println(i);
        }

    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {

        for(int[] oneD: array2d){

            for(int a: oneD){

                System.out.println(a);

            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {

        double sqrt = Math.sqrt(array1d.length);

        if (sqrt - Math.floor(sqrt) == 0) {

            return true;

        }

        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {

        int i = array2d.length;

        for(int[] oneD: array2d){

            if(oneD.length != i){

                return false;

            }

        }

        return true;
    }


}