import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;

    static int[][] mul(int[][] m1, int[][] m2) {
        int[][] res = new int[n][n];

        for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= 1000;
				}
			}
		}

        return res;
    }
    
    static int[][] cal(long b) {
        if(b == 1)
            return matrix;

        int[][] mat = cal(b / 2);
        mat = mul(mat, mat);
        if(b % 2 == 1)
            mat = mul(mat, matrix);

        return mat;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long b = sc.nextLong();
        matrix = new int[n][n];
        int[][] ans;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt() % 1000;
            }
        }

        ans = cal(b);

        for(int[] row: ans) {
            for(int e: row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
