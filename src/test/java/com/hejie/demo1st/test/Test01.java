package com.hejie.demo1st.test;

public class Test01 {
    public static void main(String[] args) {
        int num = 10;
        int[][] yanghui = new int[num][];
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i + 1];
        }

        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                yanghui[i][0] = yanghui[i][i] = 1;

                if (i > 1 && j > 0 && j < i) {
                    yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
                }
            }
        } for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < (num - i - 1) / 2; j++)
                System.out.print("\t");
            for (int j = 0; j < yanghui[i].length; j++)
                System.out.print(yanghui[i][j] + " ");

            System.out.println();
        }


    }

}
