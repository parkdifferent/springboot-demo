package com.phoenix.web;

/**
 * https://blog.csdn.net/qq_21989927/article/details/108471314
 * @Auther: tianFeng
 * @Date: 2023-01-16 19:54
 */
public class TestMy2 {

    public static void main(String[] args) {

        double[] b = {
                87154.81,
                8719.28,
                8544.68,
                77876.11,
                141592.92,
                132743.36,
                378761.08,
                930573.50,
                416760.00,
                5132.75,
                214620.00,
                279000.00,
                108900.00,
                19200.00,
                13600.00,
                14000.00,
                4423.11,
                19500.00,
                2750.00,
                8500.00,
                1120.00
        };

        int n = 21;
        int[] a = {87154,
                8719,
                8544,
                77876,
                141592,
                132743,
                378761,
                930573,
                416760,
                5132,
                214620,
                279000,
                108900,
                19200,
                13600,
                14000,
                4423,
                19500,
                2750,
                8500,
                1120};
        int m = 1337781;
        int[] v = new int[22];
        int[] w = new int[22];

        for (int i = 0; i < 21; i++) {
            v[i+1] = a[i];
            w[i+1] = a[i];
        }
        int f[][] = new int[22][1337782];

        //cin>>n>>m;
        /*for (int i=1; i<=n; i++){
            cin>>v[i]>>w[i];
        }*/
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= w[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - w[i]] + v[i]);
                else f[i][j] = f[i - 1][j];
            }
        }
        int j = m;
        //List<Integer> res = new ArrayList<>();
        double res = 0;
        for (int i = n; i >= 1; i--) {
            if (f[i][j] != f[i - 1][j]) {
                j = j - w[i];
                System.out.println(i + " ");
                //cout << i << " ";
                res += b[i-1];
            }
        }

        //cout<<endl<<f[n][m]<<endl;
        System.out.println();
        System.out.println(f[n][m]);
        System.out.println(res);



    }
}
