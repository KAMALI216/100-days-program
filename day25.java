//Image Smoother
class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {     // FIXED
            for (int j = 0; j < m; j++) { // FIXED

                int sum = 0;
                int count = 0;

                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {

                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            sum += img[x][y];
                            count++;
                        }
                    }
                }

                res[i][j] = sum / count;  // integer division = round down
            }
        }

        return res;
    }
}
