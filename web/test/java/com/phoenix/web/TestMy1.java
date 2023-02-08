package com.phoenix.web;

/**
 * @Auther: tianFeng
 * @Date: 2023-01-16 19:54
 */
public class TestMy1 {

    public static void main(String[] args) {

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
        int[] b = new int[22];
        for (int i = 0; i < 21; i++) {
            b[i+1] = a[i];
        }
        int f[][] = new int[22][1337782];
        /*cin>>n>>m;
        for (int i=1; i<=n; i++)
            cin>>a[i];*/
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= b[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - b[i]] + b[i]);
                else f[i][j] = f[i - 1][j];
            }
        }
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++)
                //cout<<f[i][j]<<" ";
                System.out.print(f[i][j] + " ");
            //cout<<endl;
            System.out.println();
        }
        if (Math.abs(f[n][m] - m) < 2) {
            System.out.println("yes");
            System.out.println(n);
            System.out.println(f[n][m]);
        }

        //cout<<"yes";
        else
            //cout<<"no";
            System.out.println("no");

        /*int f[] = new int[1337781];
        for (int i = 1; i <= n; i++) {
            for (int j = m - 1; j >= a[i]; j--) {
                f[j] = Math.max(f[j], f[j - a[i]] + a[i]);
            }
        }

        System.out.println(f[m-1]);*/


    }
}
