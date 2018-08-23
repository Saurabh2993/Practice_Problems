package leetcode_easy;

public class Image_Smoother {

    public static void main(String args[]) {

        int[][] M = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};

        Image_Smoother smoother = new Image_Smoother();
        int result[][] = smoother.imageSmoother(M);

        for (int i = 0; i < result.length; i ++) {
            for (int j = 0; j < result[0].length; j ++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int[][] imageSmoother(int[][] M) {

        if (M.length == 0) {
            return M;
        }

        int m = M.length;
        int n = M[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int k = Math.max(0, i - 1); k < Math.min(i + 2, m); k++) {
                    for(int l = Math.max(0, j - 1); l < Math.min(j + 2, n); l++) {
                        sum += M[k][l];
                        count ++;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
