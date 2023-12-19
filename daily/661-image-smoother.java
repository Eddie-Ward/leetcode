package daily;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int numCols = img[0].length;
        int numRows = img.length;
        int[][] smoothImg = new int[numRows][numCols];
        for (int curRow = 0; curRow < numRows; curRow++) {
            for (int curCol = 0; curCol < numCols; curCol++) {
                smoothImg[curRow][curCol] = smoothPixel(img, curRow, curCol);
            }
        }
        return smoothImg;
    }

    private int smoothPixel(int[][] img, int curRow, int curCol) {
        int total = img[curRow][curCol];
        int numPixels = 1;
        int numCols = img[0].length;
        int numRows = img.length;
        if (curRow - 1 >= 0) {
            if (curCol - 1 >= 0) {
                total += img[curRow - 1][curCol - 1];
                numPixels++;
            }
            if (curCol + 1 < numCols) {
                total += img[curRow - 1][curCol + 1];
                numPixels++;
            }
            total += img[curRow - 1][curCol];
            numPixels++;
        }
        if (curRow + 1 < numRows) {
            if (curCol - 1 >= 0) {
                total += img[curRow - 1][curCol - 1];
                numPixels++;
            }
            if (curCol + 1 < numCols) {
                total += img[curRow - 1][curCol + 1];
                numPixels++;
            }
            total += img[curRow + 1][curCol];
            numPixels++;
        }
        if (curCol - 1 >= 0) {
            total += img[curRow][curCol - 1];
            numPixels++;
        }
        if (curCol + 1 < numCols) {
            total += img[curRow][curCol + 1];
            numPixels++;
        }
        return Math.floorDiv(total, numPixels);
    }
}
